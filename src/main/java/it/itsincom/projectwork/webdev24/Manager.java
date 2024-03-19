package it.itsincom.projectwork.webdev24;

import java.time.LocalDate;

public class Manager extends Dipendente{
    private String figuraRiferimento;
    private String settoreComp;

    public Manager(String codFiscale, String nome, String cognome, LocalDate dataAssunzione, String figuraRiferimento,
            String settoreComp) {
        super(codFiscale, nome, cognome, dataAssunzione);
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


}
