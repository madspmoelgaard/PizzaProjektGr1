import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class PizzaOrdre {

    // Denne klasse repræsenterer en individuel pizzaordre
    static class PizzaOrdreEntry implements Comparable<PizzaOrdreEntry> {
        private int kundeId; // ID for kunden, der laver ordren
        private List<String> pizzaNavne; // Liste over pizzaer, der er bestilt
        private LocalTime afhentningstid; // Tidspunktet, ordren skal afhentes
        private LocalTime bestillingstid; // Tidspunktet, ordren blev lavet

        // Konstruktoren bruges til at oprette en ny ordre
        public PizzaOrdreEntry(int kundeId, List<String> pizzaNavne, LocalTime afhentningstid, LocalTime bestillingstid) {
            this.kundeId = kundeId;
            this.pizzaNavne = pizzaNavne;
            this.afhentningstid = afhentningstid;
            this.bestillingstid = bestillingstid;
        }

        // Får afhentningstiden
        public LocalTime getAfhentningstid() {
            return afhentningstid;
        }

        // Denne metode gør, at vi kan sammenligne ordrer efter afhentningstid (sortere dem)
        @Override
        public int compareTo(PizzaOrdreEntry anden) {
            return this.afhentningstid.compareTo(anden.afhentningstid);
        }

        // Formaterer ordren som en læselig streng, så vi kan udskrive den på skærmen
        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            return "Kunde ID: " + kundeId + " | Pizzaer: " + pizzaNavne + " - Bestilt: " + bestillingstid.format(formatter) + " - Afhentning: " + afhentningstid.format(formatter);
        }
    }

    // Denne klasse styrer køen af ordrer
    static class PizzaKo {
        private PriorityQueue<PizzaOrdreEntry> ordreKo = new PriorityQueue<>(); // Prioriteret kø, så vi kan sortere ordrer efter afhentningstid

        // Tilføjer en ordre til køen
        public void tilfoejOrdre(PizzaOrdreEntry ordre) {
            ordreKo.add(ordre);
        }

        // Vist alle ordrer i køen, sorteret efter afhentningstid
        public void visOrdrer() {
            System.out.println("\nOrdrer sorteret efter afhentningstid:");
            for (PizzaOrdreEntry ordre : ordreKo) {
                System.out.println(ordre);
            }
        }
    }

    // Denne klasse håndterer alt vedrørende ordrer og kunder
    static class OrdreManager {
        private PizzaKo pizzaKo; // Refererer til pizza-koen
        private Map<Integer, List<String>> kunder = new HashMap<>(); // Gemmer kundens ordrehistorik, hvor key er kundeId

        // Konstruktor, som initialiserer ordre-manageren med en pizza-ko
        public OrdreManager(PizzaKo pizzaKo) {
            this.pizzaKo = pizzaKo;
        }

        // Tilføjer en ordre til systemet og opdaterer kundens ordrehistorik
        public void tilfoejOrdre(int kundeId, List<String> pizzaNavne, LocalTime afhentningstid) {
            LocalTime bestillingstid = LocalTime.now(); // Får det aktuelle tidspunkt som bestillingstid

            // Hvis kunden ikke findes, opretter vi en ny post for dem i ordrehistorikken
            if (!kunder.containsKey(kundeId)) {
                kunder.put(kundeId, new ArrayList<>());
            }

            // Opretter en ny ordre og tilføjer den til køen
            pizzaKo.tilfoejOrdre(new PizzaOrdreEntry(kundeId, pizzaNavne, afhentningstid, bestillingstid));
            kunder.get(kundeId).addAll(pizzaNavne);  // Tilføjer alle pizzaerne til kundens ordrehistorik
        }

        // Vist alle ordrer i køen
        public void visOrdrer() {
            pizzaKo.visOrdrer();
        }

        // Vist alle kunder og deres ordrehistorik
        public void visKunder() {
            System.out.println("Ordrehistorik:");
            for (Map.Entry<Integer, List<String>> entry : kunder.entrySet()) {
                System.out.println("Kunde ID: " + entry.getKey() + ", Pizzaer: " + entry.getValue());
            }
        }
    }

    // Denne klasse håndterer brugerens input, f.eks. når de laver en ny ordre
    static class OrdreInput {
        private OrdreManager ordreManager; // OrdreManager til at tilføje ordrer og vise ordrer
        private Scanner scanner = new Scanner(System.in); // Scanner til at læse brugerinput fra konsollen
        private int kundeId = 1;  // Startende med kundeID 1 for den første kunde

        // Konstruktor til at initialisere OrdreInput med en OrdreManager
        public OrdreInput(OrdreManager ordreManager) {
            this.ordreManager = ordreManager;
        }

        // Denne metode håndterer indtastningen af en ny ordre fra brugeren
        public void tagInput() {
            boolean nyBestilling = true;
            while (nyBestilling) {
                System.out.println("\nNy bestilling til kunde ID: " + kundeId);
                List<String> pizzaNavne = new ArrayList<>(); // Liste til at holde de pizzaer, kunden bestiller
                LocalTime afhentningstid = null; // Afhentningstid er indtil videre null

                // Læs og valider afhentningstiden
                while (afhentningstid == null) {
                    System.out.print("Indtast afhentningstid (hh:mm): ");
                    String tidStr = scanner.nextLine(); // Læs brugerens indtastning
                    try {
                        afhentningstid = LocalTime.parse(tidStr, DateTimeFormatter.ofPattern("HH:mm")); // Prøv at parse tidstrengen til LocalTime
                    } catch (DateTimeParseException e) {
                        System.out.println("Ugyldigt format! Prøv igen."); // Fejlmeddelelse ved forkert format
                    }
                }

                boolean flerePizzaer = true;
                while (flerePizzaer) {
                    System.out.print("Indtast pizza (nummer): ");
                    String pizzaValg = scanner.nextLine().trim();

                    // Hvis der er indtastet en pizza, tilføjes den til ordren
                    if (!pizzaValg.isEmpty()) {
                        pizzaNavne.add(pizzaValg);
                    } else {
                        System.out.println("Du skal indtaste en pizza!"); // Hvis ingenting er indtastet
                        continue;
                    }

                    // Spørger om kunden vil tilføje flere pizzaer
                    System.out.print("Vil du tilføje en pizza mere til denne ordre? (ja/nej): ");
                    String svar = scanner.nextLine();
                    if (!svar.equalsIgnoreCase("ja")) {
                        flerePizzaer = false; // Stopper hvis kunden ikke vil have flere pizzaer
                    }
                }

                // Tilføjer ordren til systemet
                ordreManager.tilfoejOrdre(kundeId, pizzaNavne, afhentningstid);
                ordreManager.visOrdrer(); // Vis alle ordrer i køen
                ordreManager.visKunder(); // Vis ordrehistorikken for kunderne

                // Spørg om en ny bestilling skal oprettes
                System.out.print("Vil du lave en ny bestilling til en ny kunde? (ja/nej): ");
                String nyBestillingStr = scanner.nextLine();
                if (!nyBestillingStr.equalsIgnoreCase("ja")) {
                    System.out.println("Programmet afsluttes...");
                    break; // Afslut programmet, hvis brugeren ikke vil lave en ny bestilling
                }

                kundeId++; // Øger kundeId, så den næste kunde får et nyt ID
            }
        }
    }

    // Hovedmetoden, hvor programmet starter
    public static void main(String[] args) {
        PizzaKo pizzaKo = new PizzaKo(); // Opretter pizza-koen til at holde ordrer
        OrdreManager ordreManager = new OrdreManager(pizzaKo); // Opretter ordre-manageren
        OrdreInput ordreInput = new OrdreInput(ordreManager); // Opretter input-håndtereren til at tage brugerinput
        ordreInput.tagInput(); // Starter processen med at tage input og oprette ordrer
    }
}
