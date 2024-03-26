package it.itsincom.projectwork.webdev24;

import java.time.LocalDate;

public class Dirigente extends Dipendente {
    private String divisione;

    public Dirigente(String ruolo, String codFiscale, String nome, String cognome, LocalDate dataAssunzione,
            String divisione) {
        super(ruolo, codFiscale, nome, cognome, dataAssunzione);
        this.divisione = divisione;
    }

    public String getDivisione() {
        return divisione;
    }

    public void setDivisione(String divisione) {
        this.divisione = divisione;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dirigente other = (Dirigente) obj;
        if (divisione == null) {
            if (other.divisione != null)
                return false;
        } else if (!divisione.equals(other.divisione))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " Divisione: " + divisione + "\n";
    }
}
