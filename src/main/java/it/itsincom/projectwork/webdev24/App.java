package it.itsincom.projectwork.webdev24;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Lettura da File
        Scanner elencoDip = new Scanner(new File("C:\\Project Work\\main\\elenco dipendenti.txt"));
        ArrayList<Dipendente> listaDipendenti = new ArrayList<>();
        while (elencoDip.hasNextLine()) {
            String token[] = elencoDip.nextLine().split(";");
            if (token[0].equals("dirigente")) {
                listaDipendenti.add(
                        new Dirigente(token[0], token[1], token[2], token[3], LocalDate.parse(token[4]), token[5]));
            } else if (token[0].equals("tecnico")) {
                listaDipendenti.add(new Tecnico(token[0], token[1], token[2], token[3], LocalDate.parse(token[4]),
                        token[5], token[6]));
            } else if (token[0].equals("manager")) {
                listaDipendenti.add(new Manager(token[0], token[1], token[2], token[3], LocalDate.parse(token[4]),
                        token[5], token[6]));
            }
        }
        // Creazione azienda con arraylist passato da file
        Azienda recruitItSolutions = new Azienda(listaDipendenti);
        // Stampa del nome dell'azienda con la lista dei dipendenti
        System.out.println(recruitItSolutions.toString());

        // Stampa dell'elenco in ordine alfabetico dei dipendenti
        Collections.sort(recruitItSolutions.getDipendenti());
        System.out.println("Elenco dei dipendenti in ordine alfabetico\n" + recruitItSolutions.toString());

        // L'elenco dei dipendenti (dati anagrafici) di una categoria presa come parametro in ordine di tempo di permanenza in azienda
        sortCategory(recruitItSolutions.getDipendenti(), "tecnico"); //cambiare il secondo parametro a seconda della categoria che si vuole filtrare

        //Creo un oggetto di tipo Manager che utilizzo per calcolare gli stipendi dei manager e applico il metodo calcolaStipendio() della classe Manager utilizzando la lista dei dipendenti
        Manager manager = new Manager();
        manager.calcolaStipendio(recruitItSolutions.getDipendenti());

        //Creo un oggetto di tipo Dirigente che utilizzo per calcolare gli stipendi dei dirigenti e applico il metodo calcolaStipendio() della classe Dirigente utilizzando la lista dei dipendenti
        Dirigente dirigente = new Dirigente();
        dirigente.calcolaStipendio(recruitItSolutions.getDipendenti());

        //Stampa dell'elenco di tutti gli stipendi
        for (Dipendente dipendente : recruitItSolutions.getDipendenti()) {
            System.out.println(dipendente.getStipendio());
        }


        elencoDip.close();
    }

    public static void sortCategory(ArrayList<Dipendente> a, String p) {
        //Ordinamento dell'ArrayList in base alla data di assunzione tramite una classe anonima che implementa l'interfaccia Comparator<Dipendente> per definire il criterio di ordinamento.
        a.sort(new Comparator<Dipendente>() {
            //Implementazione del metodo compare, che confronta due oggetti Dipendente in base alla loro data di assunzione.
            @Override
            public int compare(Dipendente o1, Dipendente o2) {
                return o1.getDataAssunzione().compareTo(o2.getDataAssunzione());
            }
        });
        //Utilizzo di un ciclo foreach che stampa solo i dipendenti della categoria passata come parametro
        System.out.println("Elenco dipendenti della categoria " + p + "\n");
        for (Dipendente dipendente : a) {
            if (dipendente.getRuolo().equals(p)) {
                System.out.println(dipendente);
            }
        }
    }
}
