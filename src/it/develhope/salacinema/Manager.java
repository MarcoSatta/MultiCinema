package it.develhope.salacinema;

public class Manager {
    public String name;
    public String surname;
    public Cinema cinemaDiAppartenenza;
    public int quotaRiscossa;

    public Manager(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void postiLiberi() {
        this.cinemaDiAppartenenza.postiLiberi(this.cinemaDiAppartenenza.sala);
    }

    public void prenotaPosto() {
        this.cinemaDiAppartenenza.prenotaPosto(this.cinemaDiAppartenenza.sala);
    }

    public void cancellaPrenotazione() {
        this.cinemaDiAppartenenza.cancellaPrenotazione(this.cinemaDiAppartenenza.sala);
    }

    public String toString() {
        return this.name + " " + this.surname;
    }
}
