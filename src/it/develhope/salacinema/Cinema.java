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

    private Persona createPersona(boolean prenota){
        String nome, cognome;
        int age;
        System.out.println("Inserisci il nome della persona:");
        nome = scanner.next();
        System.out.println("Inserisci il cognome della persona:");
        cognome = scanner.next();
        if(prenota){
            System.out.println("Inserisci l'età della persona:");
            age = scanner.nextInt();
            return new Persona(nome,cognome,age);
        }
        return new Persona(nome,cognome);
    }

    private void pagamento(int par){
        if (par < 14){
            System.out.println("Paga il prezzo ridotto di 7 euro al manager " + manager.name);
            manager.quotaRiscossa += 7;
        }else {
            System.out.println("Paga il prezzo pieno di 10 euro al manager " + manager.name);
            manager.quotaRiscossa += 10;
        }
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
                        System.out.println("Persona n° "+(i+1));
                        System.out.println("Effettuare la prenotazione di:");
                        Persona persona = createPersona(false);
                        pagamento(persona.age);
                        sala[i] = persona;
                        System.out.println("Hai correttamente prenotato per il cinema "+nameCinema+" un posto per " + persona.name + " " + persona.surname);
                    }
                }
            } else {
                System.out.println("devi inserire un numero compreso tra 1 e " + postiLiberiStatic);
            }
        }catch (Exception e){
            System.out.println("DEVI INSERIRE UN NUMERO!!");
            scanner.nextLine();
        }
    }

    public void cancellaPrenotazione(Persona[] sala){
        this.sala = sala;
        System.out.println("Cancellare la prenotazione di:");
        Persona check = createPersona(true);
        boolean found = false;
        for (int i = 0; i < sala.length; i++){
            if (sala[i]!= null && check.toStringSel().equalsIgnoreCase(sala[i].toStringSel())){
                sala[i] = null;
                System.out.println("hai correttamente cancellato la prenotazione di: " + check.name + " "+ check.surname+" al cinema  "+ nameCinema);
                found=true;
            }
        }
        if(!found){
            System.out.println("Non ho trovato nessuna persona con questo nome");
        }
    }

    public int stampaArray(Persona[] sala){
        for (Persona persona: sala) {
            if (persona == null) {
                System.out.println("posto vuoto");
            } else System.out.println(persona);
            }
        return numeroPostiLiberi;
    }

    @Override
    public String toString() {
        return nameCinema;
    }
}
