package it.itsincom.projectwork.webdev24;

import java.util.ArrayList;
import java.util.Collections;

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

    public void aggiungiDipendente(Dipendente d) throws Exception {
        // Eseguo un'iterazione sull'arraylist di dipendenti
        for (Dipendente dipendente : dipendenti) {
            // Eseguo un controllo con il dipendente passato come parametro
            if (dipendente.getCodFiscale().equals(d.getCodFiscale())) {
                // Se il dipendente è già presente nell'arraylist, viene sollevata un'eccezione
                throw new Exception("Dipendente " + d + " già presente");
            }
        }
        // Se il dipendente non è presente nell'arraylist, viene aggiunto tenendo
        // presente la classe a cui appartiene
        if (d instanceof Tecnico) {
            dipendenti.add(d);
        } else if (d instanceof Manager) {
            dipendenti.add(d);
        } else if (d instanceof Dirigente) {
            dipendenti.add(d);
        }
    }

    @Override
    public String toString() {
        String s = "Azienda " + nomeAzienda + "\nLista Dipendenti\n";
        for (Dipendente d : dipendenti) {
            s += d.toString();
        }
        return s;
    }

    public void calcolaStipendiManager(ArrayList<Dipendente> dipendenti) {
        for (Dipendente dipendente : dipendenti) {
            // Verifico se il dipendente che sto ciclando è di tipo Manager
            if (dipendente instanceof Manager) {
                // Eseguo un cast per convertire un dipendente in un oggetto di tipo Manager e
                // per poter accedere ai suoi metodi specifici
                Manager manager = (Manager) dipendente;
                // Imposto un stipendio base di 2000
                manager.stipendio = 2000;
                // Eseguo un'altra iterazione per trovare i tecnici associati al manager che sto
                // prendendo in considerazione
                for (Dipendente dipendente2 : dipendenti) {
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

    public void calcolaStipendioDirigenti(ArrayList<Dipendente> dipendenti) {
        for (Dipendente dipendente : dipendenti) {
            // Verifico se il dipendente che sto ciclando è di tipo Dirigente
            if (dipendente instanceof Dirigente) {
                // Eseguo un cast per convertire un dipendente in un oggetto di tipo Dirigente e
                // per poter accedere ai suoi metodi specifici
                Dirigente dirigente = (Dirigente) dipendente;
                // Imposto un stipendio base di 2000
                dirigente.stipendio = 2500;
                // Eseguo un'altra iterazione per aggiungere allo stipendio dei Dirigenti il 10%
                // dello stipendio di tutti i dipendenti
                for (Dipendente dipendente2 : dipendenti) {
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

    public String visualizzaStipendi() {
        String s = "Elenco dei dipendenti con relativi stipendi mensili\n";
        Collections.sort(dipendenti);
        for (Dipendente d : dipendenti) {
            s += "Codice Fiscale: " + d.getCodFiscale() + ", Nome: " + d.getNome() + ", Cognome: " + d.getCognome()
                    + ", Stipendio: " + String.valueOf(d.getStipendio()) + "\n";
        }
        return s;
    }
}
