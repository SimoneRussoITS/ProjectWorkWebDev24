package it.itsincom.projectwork.webdev24;

import java.time.LocalDate;

public class Dirigente extends Dipendente{
    private String divisione;

    public Dirigente(String codFiscale, String nome, String cognome, LocalDate dataAssunzione, String divisione) {
        super(codFiscale, nome, cognome, dataAssunzione);
        this.divisione = divisione;
    }

    public String getDivisione() {
        return divisione;
    }

    public void setDivisione(String divisione) {
        this.divisione = divisione;
    }


}
