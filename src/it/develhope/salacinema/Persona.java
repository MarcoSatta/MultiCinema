package it.develhope.salacinema;

public class Persona {
    public String name;
    public String surname;
    public int age;

    @Override
    public String toString() {
        return name + ' ' + surname + " " + age;
    }
}
