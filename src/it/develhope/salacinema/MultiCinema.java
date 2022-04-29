package it.develhope.salacinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MultiCinema {
    private static MultiCinema multiCinema;

    private MultiCinema(){}

    public static MultiCinema getInstance(){
        if (!Optional.ofNullable(multiCinema).isPresent()){
            multiCinema = new MultiCinema();
        }
        return multiCinema;
    }

    public static List<Manager> managersLiberi = new ArrayList<>();
    public static List<Cinema> cinemas = new ArrayList<>();

    public void inserisciCinema(Cinema cinema){
        cinemas.add(cinema);
        if (cinema.manger == null){
            cinema.manger = managersLiberi.get(0);
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
