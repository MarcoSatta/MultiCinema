package it.develhope.salacinema;

public class Persona {
    public String name;
    public String surname;
    public int age;

    public Persona(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Persona(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    public String toStringSel(){
        return name + ' ' + surname;
    }

}
