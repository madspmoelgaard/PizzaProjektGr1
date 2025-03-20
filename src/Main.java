import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        Menu menu = new Menu();
        menu.addPizza(new Pizza(1, "Vesuvio", " tomatsauce, ost, skinke og oregano ", 57));
        menu.addPizza(new Pizza(2, "Amerikaner", " tomatsauce, ost, oksefars og oregano ", 53));
        menu.addPizza(new Pizza(3, "Cacciatore", " tomatsauce, ost, pepperoni og oregano ", 57));
        menu.addPizza(new Pizza(4, "Carbona", " tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano ", 63));
        menu.addPizza(new Pizza(5, "Dennis", " tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano ", 65));
        menu.addPizza(new Pizza(6, "Bertil", " tomatsauce, ost, bacon og oregano ", 57));
        menu.addPizza(new Pizza(7, "Silvia", " tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano ", 61));
        menu.addPizza(new Pizza(8, "Victoria", " tomatsauce, ost, skinke, ananas, champignon, løg og oregano ", 61));
        menu.addPizza(new Pizza(9, "Toronfo", " tomatsauce, ost, skinke, bacon, kebab, chili og oregano ", 61));
        menu.addPizza(new Pizza(10, "Capricciosa", " tomatsauce, ost, skinke, champignon og oregano  ", 61));
        menu.addPizza(new Pizza(11, "Hawaii", " tomatsauce, ost, skinke, ananas og oregano ", 61));
        menu.addPizza(new Pizza(12, "Le Blissola", "tomatsauce, ost, skinke, rejer og oregano  ", 61));
        menu.addPizza(new Pizza(13, "Venezia", " tomatsauce, ost, skinke, bacon og oregano ", 61));
        menu.addPizza(new Pizza(14, "Mafia", " tomatsauce, ost, pepperoni, bacon, løg og oregano ", 63));
        menu.addPizza(new Pizza(15, "Diavola", " tomatsauce, ost, pepperoni, chili og oregano ", 57));
        menu.addPizza(new Pizza(16, "Formaggi", " tomatsauce, mozzarella, gorgonzola, parmesan og oregano ", 65));
        menu.addPizza(new Pizza(17, "Romana", " tomatsauce, ost, skinke, ansjoser og oregano ", 61));
        menu.addPizza(new Pizza(18, "Quattro Stagioni", " tomatsauce, ost, skinke, champignon, artiskok og oliven", 65));
        menu.addPizza(new Pizza(19, "Marinara", " tomatsauce, hvidløg, oregano og basilikum ", 53));
        menu.addPizza(new Pizza(20, "Bolognese", "tomatsauce, ost, kødsauce og oregano", 63));
        menu.addPizza(new Pizza(21, "Napoli", " tomatsauce, ost, ansjoser, kapers og oregano ", 61));
        menu.addPizza(new Pizza(22, "Vesuvio", " tomatsauce, ost, bacon, rucola og parmesan ", 65));
        menu.addPizza(new Pizza(23, "Milano", " tomatsauce, ost, kylling, pesto og oregano ", 65));
        menu.addPizza(new Pizza(24, "Gorgonzola Speciale", " tomatsauce, ost, gorgonzola, valnødder og honning ", 67));
        menu.addPizza(new Pizza(25, "Calzone", " indbagt pizza med tomatsauce, ost, skinke og champignon ", 62));
        menu.addPizza(new Pizza(26, "Parma", " tomatsauce, ost, parmaskinke, rucola og parmesan ", 69));
        menu.addPizza(new Pizza(27, "Siciliana", " tomatsauce, ost, tun, løg, oliven og oregano ", 61));
        menu.addPizza(new Pizza(28, "Rustica", " tomatsauce, ost, kartofler, rosmarin og bacon ", 65));
        menu.addPizza(new Pizza(29, "Vegetariana", " tomatsauce, ost, peberfrugt, aubergine, squash, løg og oregano ", 61));
        menu.addPizza(new Pizza(30, "BBQ Kylling", " BBQ sauce, ost, kylling, bacon og rød peber ", 67));


        menu.showMenu();
        System.out.println("\nHvilken pizza kunne du tænke dig at bestille?");

        boolean newOrder = true;
        while(newOrder){

            int order = userInput.nextInt();
            menu.searchPizzaByNumber(order);
            System.out.println("Du har valgt nr. " + order);

            System.out.println("Ellers andet?");
            System.out.println("'n' = Nej Tak");

            String answer = userInput.nextLine();

            if(answer.equalsIgnoreCase("n")){
                newOrder = false;
                //tilføj til ordrehistorik her
            }
        }
        System.out.println("FARVEL");
    }
}

//3. Cacciatore: tomatsauce, ost, pepperoni og oregano .......... 57,-
//4. Carbona (NYHED): tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano .......... 63,-
//5. Dennis (NYHED): tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano .......... 65,-
//6. Bertil: tomatsauce, ost, bacon og oregano .......... 57,-
//7. Silvia: tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano .......... 61,-
//8. Victoria: tomatsauce, ost, skinke, ananas, champignon, løg og oregano .......... 61,-
//9. Toronfo (NYHED): tomatsauce, ost, skinke, bacon, kebab, chili og oregano .......... 61,-
//10. Capricciosa: tomatsauce, ost, skinke, champignon og oregano .......... 61,-
//11. Hawaii: tomatsauce, ost, skinke, ananas og oregano .......... 61,-
//12. Le Blissola: tomatsauce, ost, skinke, rejer og oregano .......... 61,-
//13. Venezia: tomatsauce, ost, skinke, bacon og oregano .......... 61,-
//14. Mafia (NYHED): tomatsauce, ost, pepperoni, bacon, løg og oregano .......... 61,-
//15. Diavola: tomatsauce, ost, pepperoni, chili og oregano .......... 63,-
//16. Formaggi: tomatsauce, mozzarella, gorgonzola, parmesan og oregano .......... 65,-
//17. Romana: tomatsauce, ost, skinke, ansjoser og oregano .......... 61,-
//18. Quattro Stagioni: tomatsauce, ost, skinke, champignon, artiskok og oliven .......... 65,-
//19. Marinara: tomatsauce, hvidløg, oregano og basilikum .......... 53,-
//20. Bolognese: tomatsauce, ost, kødsauce og oregano .......... 63,-
//21. Napoli: tomatsauce, ost, ansjoser, kapers og oregano .......... 61,-
//22. Toscana: tomatsauce, ost, bacon, rucola og parmesan .......... 65,-
//23. Milano: tomatsauce, ost, kylling, pesto og oregano .......... 65,-
//24. Gorgonzola Speciale: tomatsauce, ost, gorgonzola, valnødder og honning .......... 67,-
//25. Calzone: indbagt pizza med tomatsauce, ost, skinke og champignon .......... 63,-
//26. Parma: tomatsauce, ost, parmaskinke, rucola og parmesan .......... 69,-
//27. Siciliana: tomatsauce, ost, tun, løg, oliven og oregano .......... 61,-
//28. Rustica: tomatsauce, ost, kartofler, rosmarin og bacon .......... 65,-
//29. Vegetariana:tomatsauce, ost, peberfrugt, aubergine, squash, løg og oregano .......... 61,-
//30. BBQ Kylling: BBQ sauce, ost, kylling, bacon og rød peber .......... 67,-