package it.itsincom.projectwork.webdev24;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dirigente extends Dipendente {
    private String divisione;

    public Dirigente(String ruolo, String codFiscale, String nome, String cognome, LocalDate dataAssunzione,
            String divisione) {
        super(ruolo, codFiscale, nome, cognome, dataAssunzione);
        this.divisione = divisione;
    }

    public Dirigente() {
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

    public void calcolaStipendio(ArrayList<Dipendente> d) {
        for (Dipendente dipendente : d) {
            // Verifico se il dipendente che sto ciclando è di tipo Dirigente
            if (dipendente instanceof Dirigente) {
                // Eseguo un cast per convertire un dipendente in un oggetto di tipo Dirigente e
                // per poter accedere ai suoi metodi specifici
                Dirigente dirigente = (Dirigente) dipendente;
                // Imposto un stipendio base di 2000
                dirigente.stipendio = 2500;
                // Eseguo un'altra iterazione per aggiungere allo stipendio dei Dirigenti il 10%
                // dello stipendio di tutti i dipendenti
                for (Dipendente dipendente2 : d) {
                    // Verifico se il dipendente che sto ciclando non è di tipo Dirigente
                    if (!(dipendente2 instanceof Dirigente)) {
                        // Se true, sovrascrivo lo stipendio del dirigente aggiungendo il 10% dello
                        // stipendio del dipendente che sto ciclando
                        dirigente.stipendio += dipendente2.getStipendio() * 0.1;
                    }
                }
            }
        }
    }

}
