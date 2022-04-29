package it.develhope.salacinema;

import java.util.Arrays;
import java.util.Scanner;

/*Esercizio 1.0
Realizzare un programma in Java che gestisca le prenotazioni di un cinema monosala.
La sala può contenere massimo 10 posti per ogni evento.
Realizzare quattro funzionalità mostrando un menù all'avvio del programma che mostrerà:

1) Elenco lista dei posti disponibili;
2) Prenota posto a sedere:
3) Cancella prenotazione:
4) Uscire dal programma

Esercizio 2.0
1) Creare una classe MultiCinema che permette la possibilità di gestire un insieme di più Cinema.
2) Creare una classe Manager che rappresenterà la persona incaricata di gestire ogni cinema con le funzionalità descritte nell'esercizio 1.0
3) Ogni Manager può gestire le prenotazioni solo di un cinema alla volta.
4) Opzionale, nella classe principale bisogna dare la possibilità di assegnare in modalità automatica (tramite linea di comando) , ogni Manager a gestire un particolare Cinema.
 */
public class Main {
    public static void main(String[] args) {

        Cinema cinema = new Cinema("Duel");
        Cinema cinema2 = new Cinema("UCI Cinema");

        MultiCinema multiCinema = MultiCinema.getInstance();

        Manager manager01 = new Manager("Michele", "Carrillo");
        Manager manager02 = new Manager("Mario", "Rossi");

        multiCinema.inserisciManager(manager01);
        multiCinema.inserisciManager(manager02);

        multiCinema.inserisciCinema(cinema);
        multiCinema.inserisciCinema(cinema2);

        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------------------------------");
        System.out.println("Inserisci il nome del cinema nel quale vuoi entrare:");
        String cinemaSelezionato = scanner.next();
        for (int i = 0; i < multiCinema.cinemas.size(); i++) {
            if (cinemaSelezionato.equalsIgnoreCase(multiCinema.cinemas.get(i).nameCinema)) {
                System.out.println("Il manager di questo cinema è " + multiCinema.cinemas.get(i).manger);

                boolean condizione = true;
                while (condizione) {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Seleziona 1 per Elenco lista dei posti disponibili");
                    System.out.println("Seleziona 2 per prenotare posto a sedere");
                    System.out.println("Seleziona 3 per cancellare prenotazione");
                    System.out.println("Seleziona 4 per uscire dal programma");
                    System.out.println("----------------------------------------------------------");

                    switch (scanner.nextInt()) {
                        case 1:
                            multiCinema.cinemas.get(i).postiLiberi(multiCinema.cinemas.get(i).sala);
                            break;
                        case 2:
                            multiCinema.cinemas.get(i).prenotaPosto(multiCinema.cinemas.get(i).sala);
                            break;
                        case 3:
                            multiCinema.cinemas.get(i).cancellaPrenotazione(multiCinema.cinemas.get(i).sala);
                            break;
                        case 4:
                            condizione = false;
                            break;
                        default:
                            System.out.println("Inserisci un numero compreso tra 1 e 4");
                    }
                }
                System.out.println("Persone prenotate: " + Arrays.toString(multiCinema.cinemas.get(i).sala));
            }
        }
    }
}
