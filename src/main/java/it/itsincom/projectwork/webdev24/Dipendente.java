package it.itsincom.projectwork.webdev24;

import java.time.LocalDate;

public class Dipendente {
    private String ruolo;
    private String codFiscale;
    private String nome;
    private String cognome;
    private LocalDate dataAssunzione;
    protected int stipendio;

    public String getCodFiscale() {
        return codFiscale;
    }
    public void setCodFiscale(String codFiscale) {
        this.codFiscale = codFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(LocalDate dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public int getStipendio() {
        return stipendio;
    }

    public void setStipendio(int stipendio) {
        this.stipendio = stipendio;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public Dipendente(String ruolo, String codFiscale, String nome, String cognome, LocalDate dataAssunzione) {
        this.ruolo = ruolo;
        this.codFiscale = codFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataAssunzione = dataAssunzione;
    }

    @Override
    public String toString() {
        return "Dipendente [ruolo=" + ruolo + ", codFiscale=" + codFiscale + ", nome=" + nome + ", cognome=" + cognome
                + ", dataAssunzione=" + dataAssunzione + "]";
    }










}
