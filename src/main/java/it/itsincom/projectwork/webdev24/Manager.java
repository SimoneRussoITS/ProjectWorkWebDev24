package it.itsincom.projectwork.webdev24;

import java.time.LocalDate;
import java.util.ArrayList;

public class Manager extends Dipendente {
    private String figuraRiferimento;
    private String settoreComp;

    public Manager(String ruolo, String codFiscale, String nome, String cognome, LocalDate dataAssunzione,
            String figuraRiferimento, String settoreComp) {
        super(ruolo, codFiscale, nome, cognome, dataAssunzione);
        this.figuraRiferimento = figuraRiferimento;
        this.settoreComp = settoreComp;
    }

    public Manager() {
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

    public void calcolaStipendio(ArrayList<Dipendente> d) {
        for (Dipendente dipendente : d) {
            // Verifico se il dipendente che sto ciclando è di tipo Manager
            if (dipendente instanceof Manager) {
                // Eseguo un cast per convertire un dipendente in un oggetto di tipo Manager e
                // per poter accedere ai suoi metodi specifici
                Manager manager = (Manager) dipendente;
                // Imposto un stipendio base di 2000
                manager.stipendio = 2000;
                // Eseguo un'altra iterazione per trovare i tecnici associati al manager che sto
                // prendendo in considerazione
                for (Dipendente dipendente2 : d) {
                    // Verifico se il dipendente che sto ciclando è di tipo Tecnico
                    if (dipendente2 instanceof Tecnico) {
                        // Eseguo un cast per convertire un dipendente2 in un oggetto di tipo Tecnico e
                        // per poter accedere ai suoi metodi specifici
                        Tecnico tecnico = (Tecnico) dipendente2;
                        // Verifico se il codice fiscale associato al tecnico corrisponde a quello del
                        // manager che sto prendendo in considerazione
                        if (tecnico.getFiguraRiferimento().equalsIgnoreCase(manager.getCodFiscale())) {
                            // Se true, sovrascrivo lo stipendio del manager aggiungendo il 10% dello
                            // stipendio del tecnico
                            manager.stipendio += tecnico.getStipendio() * 0.1;
                        }
                    }
                }
            }
        }
    }
}
