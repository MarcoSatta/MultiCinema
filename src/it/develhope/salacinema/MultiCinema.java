package it.develhope.salacinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MultiCinema {
    private static MultiCinema multiCinema;
    public static List<Manager> managersLiberi = new ArrayList();
    public static List<Cinema> cinemas = new ArrayList();

    private MultiCinema() {
    }

    public static MultiCinema getInstance() {
        if (!Optional.ofNullable(multiCinema).isPresent()) {
            multiCinema = new MultiCinema();
        }

        return multiCinema;
    }

    public void inserisciCinema(Cinema cinema) {
        cinemas.add(cinema);
        if (cinema.manger == null) {
            cinema.manger = (Manager)managersLiberi.get(0);
            ((Manager)managersLiberi.get(0)).cinemaDiAppartenenza = cinema;
            managersLiberi.remove(0);
        }

    }

    public void inserisciManager(Manager manager) {
        if (manager.cinemaDiAppartenenza == null) {
            managersLiberi.add(manager);
        }

    }
}
