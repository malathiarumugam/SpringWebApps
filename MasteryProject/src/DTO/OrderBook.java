package DTO;

import Operation.Carpet;
import Operation.Customer;
import Operation.Flooring;
import Operation.Laminate;
import Operation.Tile;
import Operation.Wood;
import UI.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class OrderBook {

    Console console = new Console();
    HashMap<String, Flooring> orderList;
    Customer customer;
    ArrayList<Customer> orderBook = new ArrayList();

    OrderBook book = new OrderBook();

    String orderNumber = "";
    double tax = 0.0;

    //load file into another array of doubles for taxes for each state
    double OH;
    double PA;
    double MI;
    double IN;

    //load in the file, return an array of doubles
    double woodCost; //= arry[0];
    double woodLabor;
    double carpetCost;
    double carpetLabor;
    double laminateCost;
    double laminateLabor;
    double tileCost;
    double tileLabor;

    public void run() {

        displayMenu();
        int input = console.readInteger("What would you like to do?", 1, 6);

        switch (input) {
            case 1:
                String date = console.readString("What date did you complete your order? (YYYYMMDD)");
                for (Customer cust : orderBook) {
                    System.out.println(cust.findOrder(date).toString());
                }
                break;
            case 2:
                String firstName = console.readString("Please enter your first name.");
                String lastName = console.readString("Please enter your last name.");

                if (book.findCustomer(firstName, lastName) != null) {
                    int material = console.readInteger("What flooring material are you ordering? \n\t 1. Wood\n\t 2. Laminate\n\t 3. Carpet\n\t 4. Tile", 1, 4);
                    double area = console.readDoubleMat("Please enter the area to be floored.\n", 1, 30000);
                    if (material == 1) {
                        Wood wood = new Wood("Wood", woodCost, woodLabor, area);
                        orderNumber = book.findCustomer(firstName, lastName).addOrder(book.findCustomer(firstName, lastName), wood);
                    }
                    if (material == 2) {
                        Laminate lamb = new Laminate("Laminate", laminateCost, laminateLabor, area);
                        orderNumber = book.findCustomer(firstName, lastName).addOrder(book.findCustomer(firstName, lastName), lamb);
                    }
                    if (material == 3) {
                        Carpet car = new Carpet("Carpet", carpetCost, carpetLabor, area);
                        orderNumber = book.findCustomer(firstName, lastName).addOrder(book.findCustomer(firstName, lastName), car);
                    }
                    if (material == 4) {
                        Tile tile = new Tile("Tile", tileCost, tileLabor, area);
                        orderNumber = book.findCustomer(firstName, lastName).addOrder(book.findCustomer(firstName, lastName), tile);
                    }
                    System.out.println();
                    book.findCustomer(firstName, lastName).displayOrder(book.findCustomer(firstName, lastName), orderList, orderNumber);
                    String decision = console.readString("Would you like place this order? (Y or N)");
                    if (decision.equalsIgnoreCase("n") || decision.equalsIgnoreCase("no")) {
                        book.findCustomer(firstName, lastName).removeOrder(orderNumber);
                    }

                } else {
                    
                    orderList = new HashMap();
                    String state = console.readString("Which state are you ordering in? (OH, PA, IN, MI)");
                    if (state.equalsIgnoreCase("OH")) {
                        tax = OH;
                    } else if (state.equalsIgnoreCase("PA")) {
                        tax = PA;
                    } else if (state.equalsIgnoreCase("IN")) {
                        tax = IN;
                    } else if (state.equalsIgnoreCase("MI")) {
                        tax = MI;
                    }
                    customer = new Customer(firstName, lastName, state, tax, orderList);
                    int material = console.readInteger("What flooring material are you ordering? \n\t 1. Wood\n\t 2. Laminate\n\t 3. Carpet\n\t 4. Tile", 1, 4);
                    double area = console.readDoubleMat("Please enter the area to be floored.\n", 1, 30000);
                    if (material == 1) {
                        Wood wood = new Wood("Wood", woodCost, woodLabor, area);

                        orderNumber = customer.addOrder(customer, wood);
                    }
                    if (material == 2) {
                        Laminate lamb = new Laminate("Laminate", laminateCost, laminateLabor, area);
                        orderNumber = customer.addOrder(customer, lamb);
                    }
                    if (material == 3) {
                        Carpet car = new Carpet("Carpet", carpetCost, carpetLabor, area);
                        orderNumber = customer.addOrder(customer, car);
                    }
                    if (material == 4) {
                        Tile tile = new Tile("Tile", tileCost, tileLabor, area);
                        orderNumber = customer.addOrder(customer, tile);
                    }
                    customer.displayOrder(customer, orderList, orderNumber);
                    String decision = console.readString("Would you like place this order? (Y or N)");
                    if (decision.equalsIgnoreCase("n") || decision.equalsIgnoreCase("no")) {
                        customer.removeOrder(orderNumber);
                    }
                }

                break;
            case 3:
                String orderNumber = console.readString("Please enter the order number of the order you would like to edit? ");
                Flooring order = customer.findOrder(orderNumber);
                for (Customer cust : orderBook) {
                    Set<String> keys = orderList.keySet();
                    for (String k : keys) {
                        if (k == orderNumber) {
                            String first = console.readString("Edit cutsomer first name (" + cust.getFirstName() + "):\n");
                            if (first != null) {
                                cust.setFirstName(first);
                            }
                            String last = console.readString("Edit customer last name (" + cust.getFirstName() + "):\n");
                            if (first != null) {
                                cust.setLastName(last);
                            }
                            String state = console.readString("Edit state (" + cust.getState() + "):\n\t"
                                    + "State choices (OH, PA, MI, IN)");
                            if (state != null) {
                                cust.setState(state);
                                if (state.equalsIgnoreCase("OH")) {
                                    tax = OH;
                                } else if (state.equalsIgnoreCase("PA")) {
                                    tax = PA;
                                } else if (state.equalsIgnoreCase("IN")) {
                                    tax = IN;
                                } else if (state.equalsIgnoreCase("MI")) {
                                    tax = MI;
                                }
                            }
                            String material = console.readString("Edit flooring material (" + orderList.get(k).getProductType() + "):\n\t"
                                    + "Material choices (Wood, Laminate, Carpet, Tile)");
                            double area = console.readDouble("Edit area (" + orderList.get(k).getArea() + "):\n");
                            
                            if (material == null && area == 0) {
                                break;
                            }
                            if (material != null && area != 0) {
                                if (material.equalsIgnoreCase("wood")) {
                                    Wood temp = new Wood("Wood", woodCost, woodLabor, area);
                                    orderList.put(k, temp);
                                } else if (material.equalsIgnoreCase("laminate")) {
                                   Laminate temp = new Laminate("Laminate", laminateCost, laminateLabor, area);
                                    orderList.put(k, temp);
                                } else if (material.equalsIgnoreCase("carpet")) {
                                    Carpet temp = new Carpet("Carpet", carpetCost, carpetLabor, area);
                                    orderList.put(k, temp);
                                } else if (material.equalsIgnoreCase("tile")) {
                                    Tile temp = new Tile("Tile", tileCost, tileLabor, area);
                                    orderList.put(k, temp);
                                }
                            }
                            if (material != null && area == 0) {
                                if (material.equalsIgnoreCase("wood")) {
                                    Wood temp = new Wood("Wood", woodCost, woodLabor, orderList.get(k).getArea());
                                    orderList.put(k, temp);
                                } else if (material.equalsIgnoreCase("laminate")) {
                                   Laminate temp = new Laminate("Laminate", laminateCost, laminateLabor, orderList.get(k).getArea());
                                    orderList.put(k, temp);
                                } else if (material.equalsIgnoreCase("carpet")) {
                                    Carpet temp = new Carpet("Carpet", carpetCost, carpetLabor, orderList.get(k).getArea());
                                    orderList.put(k, temp);
                                } else if (material.equalsIgnoreCase("tile")) {
                                    Tile temp = new Tile("Tile", tileCost, tileLabor, orderList.get(k).getArea());
                                    orderList.put(k, temp);
                                }
                            }
                            if (material == null && area !=0) {
                                orderList.get(k).setArea(area);
                            }

                        }
                    }
                }

                break;

            case 4:

                break;
            case 5:

                break;
            case 6:
                return;
        }

    }

    public Customer findCustomer(String first, String last) {
        for (Customer cust : orderBook) {
            if (cust.getFirstName().equalsIgnoreCase(first) && cust.getLastName().equalsIgnoreCase(last)) {
                return cust;
            }
        }
        return null;
    }

    public static void displayMenu() {
        System.out.println("*************************************************************");
        System.out.println("\n*                 Flooring Program");
        System.out.println("\n*");
        System.out.println("\n* 1. Display Orders");
        System.out.println("\n* 2. Add an Order");
        System.out.println("\n* 3. Edit an Order");
        System.out.println("\n* 4. Remove an Order");
        System.out.println("\n* 5. Save Current Work");
        System.out.println("\n* 6. Quit");
        System.out.println("\n*");
        System.out.println("*************************************************************");
    }

}
