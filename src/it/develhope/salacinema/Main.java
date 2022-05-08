package it.develhope.salacinema;
import java.util.InputMismatchException;
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

        MultiCinema multiCinema = MultiCinema.getInstance();

        Manager manager01 = new Manager("Michele", "Carrillo");
        Manager manager02 = new Manager("Mario", "Rossi");
        Manager manager03 = new Manager("Tiziano", "Ferro");
        Manager manager04 = new Manager("Valentino", "Rossi");

        multiCinema.inserisciManager(manager01);
        multiCinema.inserisciManager(manager02);
        multiCinema.inserisciManager(manager03);
        multiCinema.inserisciManager(manager04);

        // Inserimento cinema nella lista e assegnazione Manager
        multiCinema.inserisciCinema(cinema);
        multiCinema.inserisciCinema(cinema2);
        multiCinema.inserisciCinema(cinema3);
        multiCinema.inserisciCinema(cinema4);

        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------------------------------");
        System.out.println("Inserisci il nome del cinema nel quale vuoi entrare:");
        String cinemaSelezionato = scanner.next();
        boolean condizione2 = true;
        while (condizione2) {
            for (int i = 0; i < MultiCinema.cinemas.size(); i++){
                if (cinemaSelezionato.equalsIgnoreCase(MultiCinema.cinemas.get(i).nameCinema)) {
                System.out.println("Il manager di questo cinema è " + MultiCinema.cinemas.get(i).manager);
                boolean condizione = true;
                while (condizione) {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Seleziona 1 per Elenco lista dei posti disponibili");
                    System.out.println("Seleziona 2 per prenotare posto a sedere");
                    System.out.println("Seleziona 3 per cancellare prenotazione");
                    System.out.println("Seleziona 4 per selezionare un altro cinema");
                    System.out.println("Seleziona 5 per uscire dal programma");
                    System.out.println("----------------------------------------------------------");

                    try{
                        int x = scanner.nextInt();
                        switch (x) {
                            case 1 -> MultiCinema.cinemas.get(i).postiLiberi(MultiCinema.cinemas.get(i).sala);
                            case 2 -> MultiCinema.cinemas.get(i).prenotaPosto(MultiCinema.cinemas.get(i).sala);
                            case 3 -> MultiCinema.cinemas.get(i).cancellaPrenotazione(MultiCinema.cinemas.get(i).sala);
                            case 4 -> {
                                condizione = false;
                                condizione2 = true;
                                System.out.println("Inserisci il nome del cinema nel quale vuoi entrare : ");
                                cinemaSelezionato = scanner.next();
                            }
                            case 5 -> {
                                condizione = false;
                                condizione2 = false;
                            }
                            default -> System.out.println("Inserisci un numero compreso tra 1 e 5");
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Comando non idoneo!");
                        scanner.nextLine();
                    }
                }
                System.out.println("Persone prenotate nel cinema " + MultiCinema.cinemas.get(i).nameCinema + " : " +  MultiCinema.cinemas.get(i).stampaArray(MultiCinema.cinemas.get(i).sala));
            }
        }
        }
    }
}

