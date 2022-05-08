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
    /*
    public void postiLiberi(){
        cinemaDiAppartenenza.postiLiberi(cinemaDiAppartenenza.sala);
    }

    public void prenotaPosto(){
        cinemaDiAppartenenza.prenotaPosto(cinemaDiAppartenenza.sala);
    }

    public void cancellaPrenotazione(){
        cinemaDiAppartenenza.cancellaPrenotazione(cinemaDiAppartenenza.sala);
    }
    */
    @Override
    public String toString() {
        return name + " " + surname;
}
}
