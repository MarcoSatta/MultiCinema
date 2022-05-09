package it.develhope.salacinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MultiCinema {
    private static MultiCinema multiCinema;
    public static List<Manager> managersLiberi;
    public static List<Cinema> cinemas;


    private MultiCinema(){
        managersLiberi = new ArrayList<>();
        cinemas = new ArrayList<>();
    }

    public static MultiCinema getInstance(){
        if (Optional.ofNullable(multiCinema).isEmpty()){
            multiCinema = new MultiCinema();
        }
        return multiCinema;
    }

    public void inserisciCinema(Cinema cinema){
        cinemas.add(cinema);
        if (cinema.manager == null){
            cinema.manager = managersLiberi.get(0);
            managersLiberi.get(0).cinemaDiAppartenenza = cinema;
            managersLiberi.remove(0);
        }
    }

    public void inserisciManager(Manager manager) {
        if (manager.cinemaDiAppartenenza == null) {
            MultiCinema.managersLiberi.add(manager);
        }
    }
}
