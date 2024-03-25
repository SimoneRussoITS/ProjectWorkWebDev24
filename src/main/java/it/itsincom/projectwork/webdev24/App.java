package it.itsincom.projectwork.webdev24;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Lettura da File
        Scanner elencoDip = new Scanner(new File("../main/elenco dipendenti.txt"));
        ArrayList<Dipendente> listaDipendenti = new ArrayList<>();
        // Creazione azienda con arraylist vuoto che verrà popolato con i dipendenti
        // presenti nel file recruitItSolutions.aggiungiDipendente
        Azienda recruitItSolutions = new Azienda(listaDipendenti);
        // Inizio a ciclare le righe del file txt
        while (elencoDip.hasNextLine()) {
            // Creo un array token[] composto dalle stringhe di ogni riga separate da ";"
            String token[] = elencoDip.nextLine().split(";");
            // Eseguo un controllo sul primo elemento dell'array token[] (che rappresenta la
            // categoria di dipendente)
            if (token[0].equals("dirigente")) {
                // Se la categoria è "dirigente", viene aggiunto all'arraylist un dipendente di
                // classe Dirigente utilizzando gli elementi dell'array token[]
                recruitItSolutions.aggiungiDipendente(
                        new Dirigente(token[0], token[1], token[2], token[3], LocalDate.parse(token[4]), token[5]));
            } else if (token[0].equals("tecnico")) {
                // Se la categoria è "tecnico", viene aggiunto all'arraylist un dipendente di
                // classe Tecnico utilizzando gli elementi dell'array token[]
                recruitItSolutions.aggiungiDipendente(
                        new Tecnico(token[0], token[1], token[2], token[3], LocalDate.parse(token[4]),
                                token[5], token[6]));
            } else if (token[0].equals("manager")) {
                // Se la categoria è "manager", viene aggiunto all'arraylist un dipendente di
                // classe Manager utilizzando gli elementi dell'array token[]
                recruitItSolutions.aggiungiDipendente(
                        new Manager(token[0], token[1], token[2], token[3], LocalDate.parse(token[4]),
                                token[5], token[6]));
            }
        }
        // Stampa del nome dell'azienda con la lista dei dipendenti
        System.out.println(recruitItSolutions.toString());

        // Prima Richiesta: Stampa dell'elenco in ordine alfabetico dei dipendenti
        Collections.sort(recruitItSolutions.getDipendenti());
        System.out.println("Elenco dei dipendenti in ordine alfabetico\n" + recruitItSolutions.toString());

        // Seconda Richiesta: L'elenco dei dipendenti (dati anagrafici) di una categoria
        // presa come parametro in ordine di tempo di permanenza in azienda
        sortCategory(recruitItSolutions.getDipendenti(), "manager"); // cambiare il secondo parametro a seconda della
                                                                     // categoria che si vuole filtrare

        // Creo un oggetto di tipo Manager che utilizzo per calcolare gli stipendi dei
        // manager e applico il metodo calcolaStipendio() della classe Manager
        // utilizzando la lista dei dipendenti
        Manager manager = new Manager();
        manager.calcolaStipendio(recruitItSolutions.getDipendenti());

        // Creo un oggetto di tipo Dirigente che utilizzo per calcolare gli stipendi dei
        // dirigenti e applico il metodo calcolaStipendio() della classe Dirigente
        // utilizzando la lista dei dipendenti
        Dirigente dirigente = new Dirigente();
        dirigente.calcolaStipendio(recruitItSolutions.getDipendenti());

        // Terza Richiesta: L’elenco dei dipendenti (la stringa contenente: codice
        // fiscale, nome, cognome stipendio) con relativo stipendio mensile
        System.out.println(recruitItSolutions.visualizzaStipendi());

        // Richiesta Facoltativa: Scrittura dei dati in un file json di struttura analoga a quella fornita nella sottoprova 4
        // Creazione di un oggetto Gson con formattazione per la visualizzazione leggibile
        Gson gson = new GsonBuilder()
                .setPrettyPrinting() // Impostazione della formattazione per una visualizzazione più leggibile del JSON
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()) // Registrazione di un adapter personalizzato per il tipo LocalDate
                .create(); // Creazione dell'oggetto Gson
        // Conversione dell'oggetto recruitItSolutions in formato JSON
        String json = gson.toJson(recruitItSolutions);
        // Creazione di un FileWriter per scrivere il JSON su file
        FileWriter file = new FileWriter("../main/azienda.json");
        // Scrittura del JSON sul file
        file.write(json);
        // Chiusura del FileWriter
        file.close();

        elencoDip.close();
    }

    public static void sortCategory(ArrayList<Dipendente> a, String p) {
        // Ordinamento dell'ArrayList in base alla data di assunzione tramite una classe
        // anonima che implementa l'interfaccia Comparator<Dipendente> per definire il
        // criterio di ordinamento.
        a.sort(new Comparator<Dipendente>() {
            // Implementazione del metodo compare, che confronta due oggetti Dipendente in
            // base alla loro data di assunzione.
            @Override
            public int compare(Dipendente o1, Dipendente o2) {
                return o1.getDataAssunzione().compareTo(o2.getDataAssunzione());
            }
        });
        // Utilizzo di un ciclo foreach che stampa solo i dipendenti della categoria
        // passata come parametro
        System.out.println("Elenco dipendenti della categoria " + p + "\n");
        for (Dipendente dipendente : a) {
            if (dipendente.getRuolo().equals(p)) {
                System.out.println("\033[A" + dipendente.toString()); // "\033[A" serve per spostare il cursore una riga
                                                                      // verso l'alto (\033 è il codice ASCII per il
                                                                      // carattere ESC, [A indica l'azione da
                                                                      // intraprendere)
            }
        }
    }

}
