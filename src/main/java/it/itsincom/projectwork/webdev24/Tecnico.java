package it.itsincom.projectwork.webdev24;

import java.time.LocalDate;
import java.time.Period;

public class Tecnico extends Dipendente {
    private String figuraRiferimento;
    private String specialita;

    public Tecnico(String ruolo, String codFiscale, String nome, String cognome, LocalDate dataAssunzione,
            String figuraRiferimento, String specialita) {
        super(ruolo, codFiscale, nome, cognome, dataAssunzione);
        this.figuraRiferimento = figuraRiferimento;
        this.specialita = specialita;
        this.stipendio = calcolaStipendio();
    }

    public String getFiguraRiferimento() {
        return figuraRiferimento;
    }

    public void setFiguraRiferimento(String figuraRiferimento) {
        this.figuraRiferimento = figuraRiferimento;
    }

    public String getSpecialita() {
        return specialita;
    }

    public void setSpecialita(String specialita) {
        this.specialita = specialita;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tecnico other = (Tecnico) obj;
        if (figuraRiferimento == null) {
            if (other.figuraRiferimento != null)
                return false;
        } else if (!figuraRiferimento.equals(other.figuraRiferimento))
            return false;
        if (specialita == null) {
            if (other.specialita != null)
                return false;
        } else if (!specialita.equals(other.specialita))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " Codice Fiscale Riferimento" + figuraRiferimento + ", Specialità: " + specialita
                + "\n";
    }

    public int calcolaStipendio() {
        // Eseguo un controllo utilizzando la data di assunzione del tecnico e la data
        // di oggi e calcolo il periodo di tempo (in anni) trascorso tra le due date
        if (Period.between(this.getDataAssunzione(), LocalDate.now()).getYears() >= 10) {
            // Se il risultato è maggiore o uguale a 10, imposto uno stipendio di 1600
            return stipendio = 1600;
        } else {
            // In caso contrario, imposto uno stipendio di 1500
            return stipendio = 1500;
        }
    }

}
