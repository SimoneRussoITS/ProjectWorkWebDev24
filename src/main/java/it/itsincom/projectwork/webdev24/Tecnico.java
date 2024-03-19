package it.itsincom.projectwork.webdev24;

import java.time.LocalDate;

public class Tecnico extends Dipendente{
    private String figuraRiferimento;
    private String specialita;

    public Tecnico(String codFiscale, String nome, String cognome, LocalDate dataAssunzione, String figuraRiferimento,
            String specialita) {
        super(codFiscale, nome, cognome, dataAssunzione);
        this.figuraRiferimento = figuraRiferimento;
        this.specialita = specialita;
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








}
