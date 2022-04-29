package it.develhope.salacinema;

import java.lang.invoke.StringConcatException;
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
4) Opzionale, nella classe principale bisogna dare la possibilità di assegnare in modalità automatica (tramite linea di comando), ogni Manager a gestire un particolare Cinema.
 */
public class Main {
    public static void main(String[] args) {

        Cinema cinema = new Cinema("Duel");
        Cinema cinema2 = new Cinema("UCICinema");
        Cinema cinema3 = new Cinema("Marconi");
        Cinema cinema4 = new Cinema("Grillo");
        Cinema cinema5 = new Cinema("Troisi");

        MultiCinema multiCinema = MultiCinema.getInstance();

        Manager manager01 = new Manager("Michele", "Carrillo");
        Manager manager02 = new Manager("Mario", "Rossi");
        Manager manager03 = new Manager("Tiziano", "Ferro");
        Manager manager04 = new Manager("Valentino", "Rossi");
        Manager manager05 = new Manager("Paolo", "Bonolis");

        multiCinema.inserisciManager(manager01);
        multiCinema.inserisciManager(manager02);
        multiCinema.inserisciManager(manager03);
        multiCinema.inserisciManager(manager04);
        multiCinema.inserisciManager(manager05);

        /** Inserimento cinema nella lista e assegnazione Manager */
        multiCinema.inserisciCinema(cinema);
        multiCinema.inserisciCinema(cinema2);
        multiCinema.inserisciCinema(cinema3);
        multiCinema.inserisciCinema(cinema4);
        multiCinema.inserisciCinema(cinema5);

        Scanner scanner = new Scanner(System.in);
        boolean condizioneManager = true;
        String a = null;
        /** managerScelto != 1 || managerScelto != 2 || managerScelto != 3 || managerScelto != 4 || managerScelto != 5*/
        while (condizioneManager){

            System.out.println("----------------------------------------------------------");
            System.out.println("Seleziona 1 per " + manager01.name + " " + manager01.surname);
            System.out.println("Seleziona 2 per " + manager02.name + " " +  manager02.surname);
            System.out.println("Seleziona 3 per " + manager03.name + " " +  manager03.surname);
            System.out.println("Seleziona 4 per " + manager04.name + " " +  manager04.surname);
            System.out.println("Seleziona 5 per " + manager05.name + " " +  manager05.surname);
            System.out.println("----------------------------------------------------------");
            switch (scanner.nextInt()) {
                case 1 : a = manager01.cinemaDiAppartenenza.nameCinema;
                condizioneManager = false;
                    break;
                case 2 : a = manager02.cinemaDiAppartenenza.nameCinema;
                    condizioneManager = false;
                    break;
                case 3 : a = manager03.cinemaDiAppartenenza.nameCinema;
                    condizioneManager = false;
                    break;
                case 4 : a = manager04.cinemaDiAppartenenza.nameCinema;
                    condizioneManager = false;
                    break;
                case 5 : a = manager05.cinemaDiAppartenenza.nameCinema;
                    condizioneManager = false;
                    break;
                default:
                    System.out.println("Inserisci un numero compreso tra 1 e 5");
            }
            System.out.println("Sei entrato nel cinema " + a);

        int i = 0;
        boolean condizione2 = true;
        while (condizione2) {
            for (i = 0; i < multiCinema.cinemas.size(); i++){
                if (a.equalsIgnoreCase(multiCinema.cinemas.get(i).nameCinema)) {
                boolean condizione = true;
                while (condizione) {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Seleziona 1 per Elenco lista dei posti disponibili");
                    System.out.println("Seleziona 2 per prenotare posto a sedere");
                    System.out.println("Seleziona 3 per cancellare prenotazione");
                    System.out.println("Seleziona 4 per selezionare un altro cinema");
                    System.out.println("Seleziona 5 per uscire dal programma");
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
                            condizione2 = true;
                            System.out.println("Inserisci il nome del cinema nel quale vuoi entrare : ");
                            a = scanner.next();
                            break;
                        case 5 : condizione = false;
                            condizione2 = false;
                        break;
                        default:
                            System.out.println("Inserisci un numero compreso tra 1 e 5");
                    }
                }
                System.out.println("Persone prenotate nel cinema " + multiCinema.cinemas.get(i).nameCinema + " : " +  multiCinema.cinemas.get(i).stampaArray(multiCinema.cinemas.get(i).sala));
            }
        }
        }
    }
}
}

