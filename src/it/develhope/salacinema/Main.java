package it.develhope.salacinema;

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
        Menu x = new Menu();
        x.menu();
    }
}

