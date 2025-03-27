import java.time.LocalTime;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PizzaOrdre {

    // Klasse til at repræsentere en pizzaordre.
    class pizzaOrdre implements Comparable<pizzaOrdre> {
        private String pizzaNavn;
        private LocalTime afhentningstid;

        // Constructor til pizzaordren.
        public pizzaOrdre(String pizzaNavn, LocalTime afhentningstid) {
            this.pizzaNavn = pizzaNavn;
            this.afhentningstid = afhentningstid;
        }

        // Hent afhentningstidspunktet
        public LocalTime getAfhentningstid() {
            return afhentningstid;
        }

        // Sammenligner pizzaordrerne ud fra afhentningstidspunkt
        @Override
        public int compareTo(pizzaOrdre anden) {
            return this.afhentningstid.compareTo(anden.afhentningstid);
        }

        // Viser pizza ordren
        @Override
        public String toString() {
            return pizzaNavn + " - Afhentning: " + afhentningstid;
        }
    }

    // Klasse til at håndtere en kø af pizzaordrer
    static class PizzaKo {
        private PriorityQueue<pizzaOrdre> ordreKo = new PriorityQueue<>();  // Kø til at holde ordrer

        // Tilføj en pizzaordre til køen
        public void tilfoejOrdre(pizzaOrdre ordre) {
            ordreKo.add(ordre);
            visOrdrer();  // Opdater og vis ordrerne hver gang en ny ordre tilføjes
        }

        // Vis alle ordrer i rækkefølge baseret på afhentningstidspunkt
        public void visOrdrer() {
            System.out.println("\nOrdrer sorteret efter afhentningstid:");
            for (pizzaOrdre ordre : ordreKo) {
                System.out.println(ordre);
            }
        }
    }

    // Klasse til at håndtere pizzaordrer og få input.
    static class OrdreManager {
        private PizzaKo pizzaKo;

        // Constructor for at forbinde med Pizza køen.
        public OrdreManager(PizzaKo pizzaKo) {
            this.pizzaKo = pizzaKo;
        }

        // Metode til at oprette pizzaordrer og tilføje dem til pizza køen
        public void opretOrdre(String pizzaNavn, LocalTime afhentningstid) {
            pizzaOrdre nyOrdre = new pizzaOrdre(pizzaNavn, afhentningstid);
            pizzaKo.tilfoejOrdre(nyOrdre);  // Tilføj ordre og opdater rækkefølge.
        }
    }


    // Klasse til at håndtere scanner-input og oprette ordrer.
    static class OrdreInput {
        private OrdreManager ordreManager;

        // Konstruktør til at forbinde med OrdreManager
        public OrdreInput(OrdreManager ordreManager) {
            this.ordreManager = ordreManager;
        }

        // Metode til at læse input fra brugeren og oprette ordrer
        public void tagInput() {
            Scanner scanner = new Scanner(System.in);  // Scanner til input fra bruger

            while (true) {
                System.out.println("Indtast pizzanavn for den nye ordre:");
                String pizzaNavn = scanner.nextLine();
                if (pizzaNavn.equalsIgnoreCase("exit")) {
                    break;  // Stop input, hvis brugeren skriver 'exit'
                }

                System.out.println("Indtast afhentningstidspunkt (f.eks: 18:30):");
                String tidInput = scanner.nextLine();
                LocalTime afhentningstid = LocalTime.parse(tidInput);

                // Opret en ny ordre og send den til OrdreManager
                ordreManager.opretOrdre(pizzaNavn, afhentningstid);
            }
            scanner.close();  // Lukker scanner
        }
    }
}
