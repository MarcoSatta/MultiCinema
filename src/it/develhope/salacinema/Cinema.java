package it.develhope.salacinema;
import java.util.Scanner;

public class Cinema {
    public Manager manger;
    public String nameCinema;
    public Persona[] sala = new Persona[10];
    public Scanner scanner;
    public int postiLiberiStatic;
    public int numeroPostiLiberi;

    public Cinema(String nameCinema) {
        this.scanner = new Scanner(System.in);
        this.numeroPostiLiberi = 0;
        this.nameCinema = nameCinema;
    }

    public void postiLiberi(Persona[] sala) {
        this.sala = sala;

        for(int i = 0; i < sala.length; ++i) {
            if (sala[i] == null) {
                ++this.numeroPostiLiberi;
            }
        }

        System.out.println("I posti disponibili nel cinema " + this.nameCinema + " sono: " + this.numeroPostiLiberi);
        System.out.println("L'incasso totale ammonta a " + this.manger.quotaRiscossa + "€");
        this.postiLiberiStatic = this.numeroPostiLiberi;
        this.numeroPostiLiberi = 0;
    }

    public void prenotaPosto(Persona[] sala) {
        this.postiLiberi(sala);
        this.sala = sala;
        System.out.println("Inserisci il numero di posti che desideri prenotare : ");

        try {
            int numeroPostiDaPrenotare = this.scanner.nextInt();
            if (numeroPostiDaPrenotare >= 1 && numeroPostiDaPrenotare <= this.postiLiberiStatic) {
                for(int i = 0; i < numeroPostiDaPrenotare; ++i) {
                    if (sala[i] == null) {
                        Persona persona = new Persona();
                        System.out.println("Inserisci il nome della persona numero : " + i + " che desideri prenotare : ");
                        persona.name = this.scanner.next();
                        System.out.println("Inserisci il cognome della persona numero : " + i + " che desideri prenotare : ");
                        persona.surname = this.scanner.next();
                        System.out.println("Inserisci l'età della persona numero : " + i + " che desideri prenotare : ");
                        persona.age = this.scanner.nextInt();
                        Manager var10000;
                        if (persona.age < 14) {
                            System.out.println("Paga il prezzo ridotto di 7 euro al manager " + this.manger.name);
                            var10000 = this.manger;
                            var10000.quotaRiscossa += 7;
                        } else {
                            System.out.println("Paga il prezzo pieno di 10 euro al manager " + this.manger.name);
                            var10000 = this.manger;
                            var10000.quotaRiscossa += 10;
                        }

                        sala[i] = persona;
                        System.out.println("Hai correttamente prenotato per il cinema " + this.nameCinema + " un posto per " + persona.name + " " + persona.surname);
                    }
                }
            } else {
                System.out.println("devi inserire un numero compreso tra 1 e " + this.postiLiberiStatic);
            }
        } catch (Exception var5) {
            System.out.println("DEVI INSERIRE UN NUMERO!!");
        }

    }

    public void cancellaPrenotazione(Persona[] sala) {
        this.sala = sala;
        System.out.println("Inserisci il nome della persona che desideri cancellare : ");
        String nomePersonaDaCancellare = this.scanner.next();
        System.out.println("Inserisci il cognome della persona che desideri cancellare : ");
        String cognomePersonaDaCancellare = this.scanner.next();

        for(int i = 0; i < sala.length; ++i) {
            if (sala[i] != null && nomePersonaDaCancellare.equalsIgnoreCase(sala[i].name) && cognomePersonaDaCancellare.equalsIgnoreCase(sala[i].surname)) {
                sala[i] = null;
                System.out.println("hai correttamente cancellato la prenotazione di: " + nomePersonaDaCancellare + " " + cognomePersonaDaCancellare + " al cinema  " + this.nameCinema);
            }
        }

    }

    public String stampaArray(Persona[] sala) {
        Persona[] var2 = sala;
        int var3 = sala.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Persona persona = var2[var4];
            if (persona == null) {
                System.out.println("posto vuoto");
            } else {
                System.out.println(persona);
            }
        }

        return this.toString();
    }

    public String toString() {
        return this.nameCinema;
    }
}
