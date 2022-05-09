package it.develhope.salacinema;

public class Persona {
    public String name;
    public String surname;
    public int age;

    public Persona() {
    }

    public String toString() {
        return this.name + " " + this.surname + " " + this.age;
    }
}