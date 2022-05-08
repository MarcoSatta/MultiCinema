package it.develhope.salacinema;
import java.util.Scanner;

public class Cinema {

    public Manager manager;
    public String nameCinema;
    public Persona[] sala;
    public Scanner scanner;
    public int postiLiberiStatic;
    public int numeroPostiLiberi;

    public Cinema(String nameCinema) {
        this.nameCinema = nameCinema;
        this.sala = new Persona[10];
        scanner = new Scanner(System.in);
        numeroPostiLiberi = 0;
    }
    public void postiLiberi(Persona[] sala){
        this.sala = sala;
        for (Persona persona : sala) {

            if (persona == null) {
                numeroPostiLiberi++;

            }
        }
        System.out.println("I posti disponibili nel cinema "+nameCinema+" sono: " + numeroPostiLiberi);
        System.out.println("L'incasso totale ammonta a " + manager.quotaRiscossa + "€");
        postiLiberiStatic = numeroPostiLiberi;
        numeroPostiLiberi = 0;
    }

    public void prenotaPosto(Persona[] sala){
        postiLiberi(sala);
        this.sala = sala;
        System.out.println("Inserisci il numero di posti che desideri prenotare : ");
        try {
            int numeroPostiDaPrenotare = scanner.nextInt();

        if (numeroPostiDaPrenotare >= 1 && numeroPostiDaPrenotare <= postiLiberiStatic) {

            for (int i = 0; i < numeroPostiDaPrenotare; i++) {

                if (sala[i] == null) {
                    Persona persona = new Persona();
                    System.out.println("Inserisci il nome della persona numero : " + i + " che desideri prenotare : ");
                    persona.name = scanner.next();
                    System.out.println("Inserisci il cognome della persona numero : " + i + " che desideri prenotare : ");
                    persona.surname = scanner.next();
                    System.out.println("Inserisci l'età della persona numero : " + i + " che desideri prenotare : ");
                    persona.age = scanner.nextInt();
                    if (persona.age < 14){
                        System.out.println("Paga il prezzo ridotto di 7 euro al manager " + manager.name);
                        manager.quotaRiscossa += 7;
                    }else {
                        System.out.println("Paga il prezzo pieno di 10 euro al manager " + manager.name);
                        manager.quotaRiscossa += 10;
                    }
                    sala[i] = persona;
                    System.out.println("Hai correttamente prenotato per il cinema "+nameCinema+" un posto per " + persona.name + " " + persona.surname);

                }
            }
        }else {
            System.out.println("devi inserire un numero compreso tra 1 e " + postiLiberiStatic);
        }
        }catch (Exception e){
            System.out.println("DEVI INSERIRE UN NUMERO!!");
        }
    }
    public void cancellaPrenotazione(Persona[] sala){
        this.sala = sala;
        System.out.println("Inserisci il nome della persona che desideri cancellare : ");
        String nomePersonaDaCancellare;
        nomePersonaDaCancellare = scanner.next();
        System.out.println("Inserisci il cognome della persona che desideri cancellare : ");
        String cognomePersonaDaCancellare;
        cognomePersonaDaCancellare = scanner.next();

        for (int i = 0; i < sala.length; i++){
            if (sala[i] != null && nomePersonaDaCancellare.equalsIgnoreCase(sala[i].name)
                    && cognomePersonaDaCancellare.equalsIgnoreCase(sala[i].surname)){
                sala[i] = null;
                System.out.println("hai correttamente cancellato la prenotazione di: " + nomePersonaDaCancellare + " "+ cognomePersonaDaCancellare+" al cinema  "+ nameCinema);
            } else i = sala.length;
            System.out.println("Non ho trovato nessuna persona con questo nome");
        }
        }
        public int stampaArray(Persona[] sala){
            for (Persona persona: sala
                 ) { if (persona == null){
                System.out.println("posto vuoto");
            }else System.out.println(persona);
            } return numeroPostiLiberi;
        }

    @Override
    public String toString() {
        return nameCinema;
    }
}
