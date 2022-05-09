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
    @Override
    public String toString() {
        return name + " " + surname;
}
}
