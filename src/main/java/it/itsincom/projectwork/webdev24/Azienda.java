package it.itsincom.projectwork.webdev24;

import java.util.ArrayList;
import java.util.Collections;

public class Azienda {
    private String nomeAzienda = "Recruit ITSolutions";
    private ArrayList<Dipendente> dipendenti;

    public Azienda(ArrayList<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public ArrayList<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(ArrayList<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    public void aggiungiDipendente(Dipendente d) throws Exception {
        // Eseguo un'iterazione sull'arraylist di dipendenti
        for (Dipendente dipendente : dipendenti) {
            // Eseguo un controllo con il dipendente passato come parametro
            if (dipendente.getCodFiscale().equals(d.getCodFiscale())) {
                // Se il dipendente è già presente nell'arraylist, viene sollevata un'eccezione
                throw new Exception("Dipendente " + d + " già presente");
            }
        }
        // Se il dipendente non è presente nell'arraylist, viene aggiunto tenendo
        // presente la classe a cui appartiene
        if (d instanceof Tecnico) {
            dipendenti.add(d);
        } else if (d instanceof Manager) {
            dipendenti.add(d);
        } else if (d instanceof Dirigente) {
            dipendenti.add(d);
        }
    }

    @Override
    public String toString() {
        String s = "Azienda " + nomeAzienda + "\nLista Dipendenti\n";
        for (Dipendente d : dipendenti) {
            s += d.toString();
        }
        return s;
    }

    public String visualizzaStipendi() {
        String s = "Elenco dei dipendenti con relativi stipendi mensili\n";
        Collections.sort(dipendenti);
        for (Dipendente d : dipendenti) {
            s += "Codice Fiscale: " + d.getCodFiscale() + ", Nome: " + d.getNome() + ", Cognome: " + d.getCognome()
                    + ", Stipendio: " + String.valueOf(d.getStipendio()) + "\n";
        }
        return s;
    }
}
