package it.itsincom.projectwork.webdev24;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        //Lettura da File
        Scanner elencoDip = new Scanner(new File("C:\\Project Work\\main\\elenco dipendenti.txt"));
        ArrayList<Dipendente> listaDipendenti = new ArrayList<>();
        while (elencoDip.hasNextLine()) {
            String token[] = elencoDip.nextLine().split(";");
            if (token[0].equals("dirigente")) {
                listaDipendenti.add(new Dirigente(token[0], token[1], token[2], token[3], LocalDate.parse(token[4]), token[5]));
            } else if (token[0].equals("tecnico")) {
                listaDipendenti.add(new Tecnico(token[0], token[1], token[2], token[3], LocalDate.parse(token[4]), token[5], token[6]));
            } else if (token[0].equals("manager")) {
                listaDipendenti.add(new Manager(token[0], token[1], token[2], token[3], LocalDate.parse(token[4]), token[5], token[6]));
            }
        }
        //Creazione azienda con arraylist passato da file
        Azienda recruitItSolutions = new Azienda(listaDipendenti);
        //Stampa del nome dell'azienda con la lista dei dipendenti
        System.out.println(recruitItSolutions.toString());

        //Stampa dell'elenco in ordine alfabetico dei dipendenti
        Collections.sort(recruitItSolutions.getDipendenti());
        System.out.println("Elenco dei dipendenti in ordine alfabetico\n" + recruitItSolutions.toString());
        elencoDip.close();
    }
}
