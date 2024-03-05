package com.creational.builderPattern.builderPatternDemo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderBuilder {
    public OrderedItems preparePizza() throws IOException {

        OrderedItems orderedItems = new OrderedItems();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(" Enter the choice of Pizza ");
        System.out.println("============================");
        System.out.println("        1. Veg-Pizza       ");
        System.out.println("        2. Non-Veg Pizza   ");
        System.out.println("        3. Exit            ");
        System.out.println("============================");

        int pizzaChoice = Integer.parseInt(br.readLine());

        switch (pizzaChoice) {
            case 1: {
                System.out.println("You ordered Veg Pizza");
                System.out.println("\n\n");
                System.out.println(" Enter the types of Veg-Pizza ");
                System.out.println("------------------------------");
                System.out.println("        1.Cheese Pizza        ");
                System.out.println("        2.Onion Pizza        ");
                System.out.println("        3.Masala Pizza        ");
                System.out.println("        4.Exit            ");
                System.out.println("------------------------------");
                int vegPizzaChoice = Integer.parseInt(br.readLine());
                switch (vegPizzaChoice) {
                    case 1: {
                        System.out.println("You ordered Cheese Pizza");

                        System.out.println("Enter the cheese pizza size");
                        System.out.println("------------------------------------");
                        System.out.println("    1. Small Cheese Pizza ");
                        System.out.println("    2. Medium Cheese Pizza ");
                        System.out.println("    3. Large Cheese Pizza ");
                        System.out.println("    4. Extra-Large Cheese Pizza ");
                        System.out.println("------------------------------------");
                        int cheesePizzaSize = Integer.parseInt(br.readLine());
                        switch (cheesePizzaSize) {
                            case 1:
                                orderedItems.addItems(new SmallCheesePizza());
                                break;
                            case 2:
                                orderedItems.addItems(new MediumCheesePizza());
                                break;
                            case 3:
                                orderedItems.addItems(new LargeCheesePizza());
                                break;
                            case 4:
                                orderedItems.addItems(new ExtraLargeCheesePizza());
                                break;
                        }
                        break;
                    }

                    case 2: {
                        System.out.println("You ordered Onion Pizza");
                        System.out.println("Enter the Onion pizza size");
                        System.out.println("----------------------------------");
                        System.out.println("    1. Small Onion Pizza ");
                        System.out.println("    2. Medium Onion Pizza ");
                        System.out.println("    3. Large Onion Pizza ");
                        System.out.println("    4. Extra-Large Onion Pizza ");
                        System.out.println("----------------------------------");
                        int onionPizzaSize = Integer.parseInt(br.readLine());
                        switch (onionPizzaSize) {
                            case 1:
                                orderedItems.addItems(new SmallOnionPizza());
                                break;
                            case 2:
                                orderedItems.addItems(new MediumOnionPizza());
                                break;
                            case 3:
                                orderedItems.addItems(new LargeOnionPizza());
                                break;
                            case 4:
                                orderedItems.addItems(new ExtraLargeOnionPizza());
                                break;
                        }
                        break;
                    }

                    case 3: {
                        System.out.println("You ordered Masala Pizza");
                        System.out.println("Enter the Masala pizza size");
                        System.out.println("------------------------------------");
                        System.out.println("    1. Small Masala Pizza ");
                        System.out.println("    2. Medium Masala Pizza ");
                        System.out.println("    3. Large Masala Pizza ");
                        System.out.println("    4. Extra-Large Masala Pizza ");
                        System.out.println("------------------------------------");
                        int masalaPizzaSize = Integer.parseInt(br.readLine());
                        switch (masalaPizzaSize) {
                            case 1:
                                orderedItems.addItems(new SmallMasalaPizza());
                                break;

                            case 2:
                                orderedItems.addItems(new MediumMasalaPizza());
                                break;

                            case 3:
                                orderedItems.addItems(new LargeMasalaPizza());
                                break;

                            case 4:
                                orderedItems.addItems(new ExtraLargeMasalaPizza());
                                break;
                        }
                        break;
                    }

                    case 4: {
                        break;
                    }
                }
                break;
            }

            case 2: {
                System.out.println("You ordered Non-Veg Pizza");
                System.out.println("\n\n");

                System.out.println("Enter the Non-Veg pizza size");
                System.out.println("------------------------------------");
                System.out.println("    1. Small Non-Veg  Pizza ");
                System.out.println("    2. Medium Non-Veg  Pizza ");
                System.out.println("    3. Large Non-Veg  Pizza ");
                System.out.println("    4. Extra-Large Non-Veg  Pizza ");
                System.out.println("------------------------------------");
                int nonVegPizzaSize = Integer.parseInt(br.readLine());

                switch (nonVegPizzaSize) {

                    case 1:
                        orderedItems.addItems(new SmallNonVegPizza());
                        break;

                    case 2:
                        orderedItems.addItems(new MediumNonVegPizza());
                        break;

                    case 3:
                        orderedItems.addItems(new LargeNonVegPizza());
                        break;

                    case 4:
                        orderedItems.addItems(new ExtraLargeNonVegPizza());
                        break;
                }
                break;
            }

            case 3: {
                break;
            }
        } // End of the Pizza switch


        //continued?..
        System.out.println(" Enter the choice of ColdDrink ");
        System.out.println("============================");
        System.out.println("        1. Pepsi            ");
        System.out.println("        2. Coke             ");
        System.out.println("        3. Exit             ");
        System.out.println("============================");
        int coldDrink = Integer.parseInt(br.readLine());

        switch (coldDrink) {
            case 1: {
                System.out.println("You ordered Pepsi ");
                System.out.println("Enter the  Pepsi Size ");
                System.out.println("------------------------");
                System.out.println("    1. Small Pepsi ");
                System.out.println("    2. Medium Pepsi ");
                System.out.println("    3. Large Pepsi ");
                System.out.println("------------------------");
                int pepsiSize = Integer.parseInt(br.readLine());
                switch (pepsiSize) {
                    case 1:
                        orderedItems.addItems(new SmallPepsi());
                        break;

                    case 2:
                        orderedItems.addItems(new MediumPepsi());
                        break;

                    case 3:
                        orderedItems.addItems(new LargePepsi());
                        break;
                }
                break;
            }
            case 2: {
                System.out.println("You ordered Coke");
                System.out.println("Enter the Coke Size");
                System.out.println("------------------------");
                System.out.println("    1. Small Coke ");
                System.out.println("    2. Medium Coke  ");
                System.out.println("    3. Large Coke  ");
                System.out.println("    4. Extra-Large Coke ");
                System.out.println("------------------------");
                int cokeSize = Integer.parseInt(br.readLine());
                switch (cokeSize) {
                    case 1:
                        orderedItems.addItems(new SmallCoke());
                        break;
                    case 2:
                        orderedItems.addItems(new MediumCoke());
                        break;
                    case 3:
                        orderedItems.addItems(new LargeCoke());
                        break;
                }
                break;
            }
            case 3: {
                break;
            }
        }//End of the Cold-Drink switch

        return orderedItems;
    } //End of the preparePizza() method
}