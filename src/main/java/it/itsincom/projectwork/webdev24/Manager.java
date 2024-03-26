package it.itsincom.projectwork.webdev24;

import java.time.LocalDate;

public class Manager extends Dipendente {
    private String figuraRiferimento;
    private String settoreComp;

    public Manager(String ruolo, String codFiscale, String nome, String cognome, LocalDate dataAssunzione,
            String figuraRiferimento, String settoreComp) {
        super(ruolo, codFiscale, nome, cognome, dataAssunzione);
        this.figuraRiferimento = figuraRiferimento;
        this.settoreComp = settoreComp;
    }

    public String getFiguraRiferimento() {
        return figuraRiferimento;
    }

    public void setFiguraRiferimento(String figuraRiferimento) {
        this.figuraRiferimento = figuraRiferimento;
    }

    public String getSettoreComp() {
        return settoreComp;
    }

    public void setSettoreComp(String settoreComp) {
        this.settoreComp = settoreComp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Manager other = (Manager) obj;
        if (figuraRiferimento == null) {
            if (other.figuraRiferimento != null)
                return false;
        } else if (!figuraRiferimento.equals(other.figuraRiferimento))
            return false;
        if (settoreComp == null) {
            if (other.settoreComp != null)
                return false;
        } else if (!settoreComp.equals(other.settoreComp))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " Codice Fiscale Riferimento: " + figuraRiferimento + ", Settore:" + settoreComp
                + "\n";
    }
}
