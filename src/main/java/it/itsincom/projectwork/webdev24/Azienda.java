package it.itsincom.projectwork.webdev24;

import java.util.ArrayList;

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

    @Override
    public String toString() {
        return "Azienda [nomeAzienda=" + nomeAzienda + "\nDipendenti=\n" + dipendenti + "]";
    }




}
