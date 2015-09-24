package DTO;

import DAO.Access;
import Operation.Carpet;
import Operation.Customer;
import Operation.Flooring;
import Operation.Laminate;
import Operation.Tile;
import Operation.Wood;
import UI.Console;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;

public class OrderBook {
    ArrayList<Customer> orderBook = new ArrayList();
    
    public OrderBook(ArrayList<Customer> book) {
       orderBook = book; 
    }

    public void run() {

        Console console = new Console();
        HashMap<String, Flooring> orderList = new HashMap();
        Customer customer = new Customer();
        Access access = new Access();
        String states = "states";
        String products = "products";

        OrderBook book = new OrderBook(orderBook);

        String orderNumber = "";
        double tax = 0.0;

        //load file into another array of doubles for taxes for each state
        HashMap<String, Double> stateTaxes = access.readTaxes(states);
        double OH = stateTaxes.get("OH");
        double PA = stateTaxes.get("PA");
        double MI = stateTaxes.get("MI");
        double IN = stateTaxes.get("IN");

        ArrayList<String> productCosts = access.readCost(products);
        //load in the file, return an array of doubles
        double woodCost = Double.parseDouble(productCosts.get(10));
        double woodLabor = Double.parseDouble(productCosts.get(11));
        double carpetCost = Double.parseDouble(productCosts.get(1));
        double carpetLabor = Double.parseDouble(productCosts.get(2));
        double laminateCost = Double.parseDouble(productCosts.get(4));
        double laminateLabor = Double.parseDouble(productCosts.get(5));
        double tileCost = Double.parseDouble(productCosts.get(7));
        double tileLabor = Double.parseDouble(productCosts.get(8));
        boolean yesNo = true;
        do {
            displayMenu();
            int input = console.readInteger("What would you like to do?", 1, 6);

            switch (input) {
                case 1:
                    String date = "";
                    boolean keepSearching = true;
                    
                    do {
                        date = console.readString("What date did you complete your order? (YYYYMMDD)");
                        if (date.length() == 8) {
                            try {
                                ArrayList<String> displayOrder = access.readOrder(date+".txt");
                                HashMap<String, Flooring> orderListTemp; 
                                Customer customerTemp;
                                Flooring floorTemp = null;
                                String[] splitLine;
                                if (displayOrder.isEmpty()) {
                                    System.out.println("That date has no orders.");
                                }
                                for (String k : displayOrder) {
                                    splitLine = k.split("::");
                                    if (splitLine[5].equalsIgnoreCase("wood")) {
                                        floorTemp = new Wood(splitLine[5], Double.parseDouble(splitLine[7]), Double.parseDouble(splitLine[8]), Double.parseDouble(splitLine[6]));
                                    } else if (splitLine[5].equalsIgnoreCase("tile")) {
                                        floorTemp = new Tile(splitLine[5], Double.parseDouble(splitLine[7]), Double.parseDouble(splitLine[8]), Double.parseDouble(splitLine[6]));
                                    } else if (splitLine[5].equalsIgnoreCase("carpet")) {
                                        floorTemp = new Carpet(splitLine[5], Double.parseDouble(splitLine[7]), Double.parseDouble(splitLine[8]), Double.parseDouble(splitLine[6]));
                                    } else if (splitLine[5].equalsIgnoreCase("laminate")) {
                                        floorTemp = new Laminate(splitLine[5], Double.parseDouble(splitLine[7]), Double.parseDouble(splitLine[8]), Double.parseDouble(splitLine[6]));
                                    }
                                    orderListTemp = new HashMap();
                                    orderListTemp.put(splitLine[4], floorTemp);
                                    customerTemp = new Customer(splitLine[0], splitLine[1], splitLine[2], Double.parseDouble(splitLine[3]), orderListTemp);
                                    System.out.println(customerTemp.toString());
                                    keepSearching = false;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("That date has no orders.");
                            }
                        }
                    } while (keepSearching);
                    break;
                case 2:
                    String firstName = console.readString("Please enter your first name.");
                    String lastName = console.readString("Please enter your last name.");

                    if (book.findCustomer(firstName, lastName, orderBook) != null) {
                        int material = console.readInteger("What flooring material are you ordering? \n\t 1. Wood\n\t 2. Laminate\n\t 3. Carpet\n\t 4. Tile", 1, 4);
                        double area = console.readDoubleMat("Please enter the area to be floored.\n", 1, 30000);
                        if (material == 1) {
                            Wood wood = new Wood("Wood", woodCost, woodLabor, area);
                            orderNumber = book.findCustomer(firstName, lastName, orderBook).addOrder(book.findCustomer(firstName, lastName, orderBook), wood);
                        }
                        if (material == 2) {
                            Laminate lamb = new Laminate("Laminate", laminateCost, laminateLabor, area);
                            orderNumber = book.findCustomer(firstName, lastName, orderBook).addOrder(book.findCustomer(firstName, lastName, orderBook), lamb);
                        }
                        if (material == 3) {
                            Carpet car = new Carpet("Carpet", carpetCost, carpetLabor, area);
                            orderNumber = book.findCustomer(firstName, lastName, orderBook).addOrder(book.findCustomer(firstName, lastName, orderBook), car);
                        }
                        if (material == 4) {
                            Tile tile = new Tile("Tile", tileCost, tileLabor, area);
                            orderNumber = book.findCustomer(firstName, lastName, orderBook).addOrder(book.findCustomer(firstName, lastName, orderBook), tile);
                        }
                        System.out.println();
                        System.out.println(book.findCustomer(firstName, lastName, orderBook).displayOrder(book.findCustomer(firstName, lastName, orderBook), orderList, orderNumber));
                        String decision = console.readString("Would you like place this order? (Y or N)");
                        if (decision.equalsIgnoreCase("n") || decision.equalsIgnoreCase("no")) {
                            
                            book.findCustomer(firstName, lastName, orderBook).removeOrder(orderNumber, orderList);
                            orderBook.remove(book.findCustomer(firstName, lastName, orderBook));
                            
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
                            orderBook.add(customer);
                        }
                        if (material == 2) {
                            Laminate lamb = new Laminate("Laminate", laminateCost, laminateLabor, area);
                            orderNumber = customer.addOrder(customer, lamb);
                            orderBook.add(customer);
                        }
                        if (material == 3) {
                            Carpet car = new Carpet("Carpet", carpetCost, carpetLabor, area);
                            orderNumber = customer.addOrder(customer, car);
                            orderBook.add(customer);
                        }
                        if (material == 4) {
                            Tile tile = new Tile("Tile", tileCost, tileLabor, area);
                            orderNumber = customer.addOrder(customer, tile);
                            orderBook.add(customer);
                        }
                        System.out.println(customer.displayOrder(customer, orderList, orderNumber));
                        String decision = console.readString("Would you like place this order? (Y or N)");
                        if (decision.equalsIgnoreCase("n") || decision.equalsIgnoreCase("no")) {
                            customer.removeOrder(orderNumber, orderList);
                            orderBook.remove(customer);
                        }
                    }
                    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                    Calendar cal = Calendar.getInstance();
                    access.writeOrder(dateFormat.format(cal.getTime()) + ".txt", orderBook);
                    break;
                case 3:
                    boolean playing = true;
                    ArrayList<Customer> tempBook = new ArrayList();
                    ArrayList<String> displayOrder3 = new ArrayList();
                    HashMap<String, Flooring> orderListTemp2 = new HashMap();
                     String datIn = "";
                    do {
                        datIn = console.readString("What date did you complete your order? (YYYYMMDD)");
                        displayOrder3 = access.readOrder(datIn+".txt");
                        Customer customerTemp2;
                        Flooring floorTemp2 = null;
                        String[] splitLine2;
                        for (String k : displayOrder3) {
                            splitLine2 = k.split("::");
                            if (splitLine2[5].equalsIgnoreCase("wood")) {
                                floorTemp2 = new Wood(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            } else if (splitLine2[5].equalsIgnoreCase("tile")) {
                                floorTemp2 = new Tile(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            } else if (splitLine2[5].equalsIgnoreCase("carpet")) {
                                floorTemp2 = new Carpet(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            } else if (splitLine2[5].equalsIgnoreCase("laminate")) {
                                floorTemp2 = new Laminate(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            }
                            orderListTemp2 = new HashMap();
                            orderListTemp2.put(splitLine2[4], floorTemp2);
                            customerTemp2 = new Customer(splitLine2[0], splitLine2[1], splitLine2[2], Double.parseDouble(splitLine2[3]), orderListTemp2);
                            tempBook.add(customerTemp2);
                        }
                        orderNumber = console.readString("Please enter the order number of the order you would like to edit? ");
                        String dateEntered = orderNumber.substring(0, 8);
                        if (!(datIn.equals(dateEntered))) {
                            System.out.println("That order was not on that date.");
                            String tryAgain = console.readString("Would you like to try again?");
                            if (tryAgain.equalsIgnoreCase("no") || tryAgain.equalsIgnoreCase("n")) {
                                playing = false;
                            }
                        } else {
                            playing = false;
                        }
                    } while (playing);
                    Customer cust = new Customer();
                    if (!displayOrder3.isEmpty()) {
                        for (Customer g : tempBook) {
                            //System.out.println(g);
                            Set<String> keys = orderListTemp2.keySet();
                            for (String k : keys) {
                                if (k.equals(orderNumber)) {
                                   cust = g;
                                }
                            }
                        }
                            
                        String first = console.readString("Edit customer first name (" + cust.getFirstName() + "):\n");
                        if (first.equals("")) {
                            cust.setFirstName(cust.getFirstName());
                        } else {
                            cust.setFirstName(first);
                        }
                        String last = console.readString("Edit customer last name (" + cust.getLastName() + "):\n");
                        if (last.equals("")) {
                            cust.setLastName(cust.getLastName());
                        } else {
                            cust.setLastName(last);
                        }
                        String state = console.readString("Edit state (" + cust.getState() + "):\n\t"
                                + "State choices (OH, PA, MI, IN)");
                        if (state.equals("")) {
                            cust.setState(cust.getState());
                        } else {
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
                        String material = console.readString("Edit flooring material (" + orderListTemp2.get(orderNumber).getProductType() + "):\t"
                                + "Material choices (Wood, Laminate, Carpet, Tile)");
                        double area = console.readDouble("Edit area (" + orderListTemp2.get(orderNumber).getArea() + "):");

                        if (material.equals("") && area == 0) {
                            break;
                        } else if (!material.equals("") && area != 0) {
                            if (material.equalsIgnoreCase("wood")) {
                                Wood temp = new Wood("Wood", woodCost, woodLabor, area);
                                orderListTemp2.put(orderNumber, temp);
                            } else if (material.equalsIgnoreCase("laminate")) {
                                Laminate temp = new Laminate("Laminate", laminateCost, laminateLabor, area);
                                orderListTemp2.put(orderNumber, temp);
                            } else if (material.equalsIgnoreCase("carpet")) {
                                Carpet temp = new Carpet("Carpet", carpetCost, carpetLabor, area);
                                orderListTemp2.put(orderNumber, temp);
                            } else if (material.equalsIgnoreCase("tile")) {
                                Tile temp = new Tile("Tile", tileCost, tileLabor, area);
                                orderListTemp2.put(orderNumber, temp);
                            }
                        } else if (!material.equals("") && area == 0) {
                            if (material.equalsIgnoreCase("wood")) {
                                Wood temp = new Wood("Wood", woodCost, woodLabor, orderListTemp2.get(orderNumber).getArea());
                                orderListTemp2.put(orderNumber, temp);
                            } else if (material.equalsIgnoreCase("laminate")) {
                                Laminate temp = new Laminate("Laminate", laminateCost, laminateLabor, orderListTemp2.get(orderNumber).getArea());
                                orderListTemp2.put(orderNumber, temp);
                            } else if (material.equalsIgnoreCase("carpet")) {
                                Carpet temp = new Carpet("Carpet", carpetCost, carpetLabor, orderListTemp2.get(orderNumber).getArea());
                                orderListTemp2.put(orderNumber, temp);
                            } else if (material.equalsIgnoreCase("tile")) {
                                Tile temp = new Tile("Tile", tileCost, tileLabor, orderListTemp2.get(orderNumber).getArea());
                                orderListTemp2.put(orderNumber, temp);
                            }
                        } else if (material.equals("") && area != 0) {
                            orderListTemp2.get(orderNumber).setArea(area);
                        }
                        access.writeOrder(datIn+".txt", tempBook);
                    }
                    break;
                case 4:
                    playing = true;
                    String dateIn  = "";
                    ArrayList<Customer> tempBook2 = new ArrayList();
                    ArrayList<String> displayOrderTwo = new ArrayList();
                    HashMap<String, Flooring> orderListTemp3 = new HashMap();
                    do {
                        dateIn = console.readString("What date did you complete your order? (YYYYMMDD)");
                        orderNumber = console.readString("Please enter the order number of the order you would like to edit? ");
                        
                        displayOrderTwo = access.readOrder(dateIn+".txt");
                        
                         
                        Customer customerTemp2;
                        Flooring floorTemp2 = null;
                        String[] splitLine2;
                        for (String k : displayOrderTwo) {
                            splitLine2 = k.split("::");
                            if (splitLine2[5].equalsIgnoreCase("wood")) {
                                floorTemp2 = new Wood(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            } else if (splitLine2[5].equalsIgnoreCase("tile")) {
                                floorTemp2 = new Tile(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            } else if (splitLine2[5].equalsIgnoreCase("carpet")) {
                                floorTemp2 = new Carpet(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            } else if (splitLine2[5].equalsIgnoreCase("laminate")) {
                                floorTemp2 = new Laminate(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            }
                            orderListTemp3 = new HashMap();
                            orderListTemp3.put(splitLine2[4], floorTemp2);
                            customerTemp2 = new Customer(splitLine2[0], splitLine2[1], splitLine2[2], Double.parseDouble(splitLine2[3]), orderListTemp3);
                            tempBook2.add(customerTemp2);
                        }
                        
                        
                        if (!(dateIn.equals(orderNumber.substring(0, 8)))) {
                            System.out.println("That order was not on that date.");
                            String tryAgain = console.readString("Would you like to try again?");
                            if (tryAgain.equalsIgnoreCase("no") || tryAgain.equalsIgnoreCase("n")) {
                               playing = false;
                            }
                        } else {
                            playing = false;
                        }
                    } while (playing);
                    if (!displayOrderTwo.isEmpty()) {
                        System.out.println(customer.displayOrder(orderNumber, tempBook2));
                        String sure = console.readString("Please confirm that this is the order you would like to remove. (Y or N)");
                        if (sure.equalsIgnoreCase("y") || sure.equalsIgnoreCase("yes")) {
                            for (String k : displayOrderTwo) {
                                CharSequence cs1 = orderNumber;
                                if (k.contains(cs1)) {
                                    displayOrderTwo.remove(k);
                                }
                            }
                        }
                        access.writeOrder(dateIn+".txt", tempBook2);
                    }
                    
                    break;
                case 5:
                    dateFormat = new SimpleDateFormat("yyyyMMdd");
                    Calendar cal2 = Calendar.getInstance();
                    access.writeOrder(dateFormat.format(cal2.getTime()) + ".txt", orderBook);
                    break;
                case 6:
                    yesNo = false;
                    return;
            }
        } while (yesNo);

    }

    public void testRun() {

                Console console = new Console();
        HashMap<String, Flooring> orderList = new HashMap();
        Customer customer = new Customer();
        Access access = new Access();
        String states = "states";
        String products = "products";

        OrderBook book = new OrderBook(orderBook);

        String orderNumber = "";
        double tax = 0.0;

        //load file into another array of doubles for taxes for each state
        HashMap<String, Double> stateTaxes = access.readTaxes(states);
        double OH = stateTaxes.get("OH");
        double PA = stateTaxes.get("PA");
        double MI = stateTaxes.get("MI");
        double IN = stateTaxes.get("IN");

        ArrayList<String> productCosts = access.readCost(products);
        //load in the file, return an array of doubles
        double woodCost = Double.parseDouble(productCosts.get(10));
        double woodLabor = Double.parseDouble(productCosts.get(11));
        double carpetCost = Double.parseDouble(productCosts.get(1));
        double carpetLabor = Double.parseDouble(productCosts.get(2));
        double laminateCost = Double.parseDouble(productCosts.get(4));
        double laminateLabor = Double.parseDouble(productCosts.get(5));
        double tileCost = Double.parseDouble(productCosts.get(7));
        double tileLabor = Double.parseDouble(productCosts.get(8));
        boolean yesNo = true;
        do {
            displayMenu();
            int input = console.readInteger("What would you like to do?", 1, 6);

            switch (input) {
                case 1:
                    String date = console.readString("What date did you complete your order? (YYYYMMDD)");
                    ArrayList<String> displayOrder = access.readOrder(date+".txt");
                    HashMap<String, Flooring> orderListTemp; 
                    Customer customerTemp;
                    Flooring floorTemp = null;
                    String[] splitLine;
                    for (String k : displayOrder) {
                        splitLine = k.split("::");
                        if (splitLine[5].equalsIgnoreCase("wood")) {
                            floorTemp = new Wood(splitLine[5], Double.parseDouble(splitLine[7]), Double.parseDouble(splitLine[8]), Double.parseDouble(splitLine[6]));
                        } else if (splitLine[5].equalsIgnoreCase("tile")) {
                            floorTemp = new Tile(splitLine[5], Double.parseDouble(splitLine[7]), Double.parseDouble(splitLine[8]), Double.parseDouble(splitLine[6]));
                        } else if (splitLine[5].equalsIgnoreCase("carpet")) {
                            floorTemp = new Carpet(splitLine[5], Double.parseDouble(splitLine[7]), Double.parseDouble(splitLine[8]), Double.parseDouble(splitLine[6]));
                        } else if (splitLine[5].equalsIgnoreCase("laminate")) {
                            floorTemp = new Laminate(splitLine[5], Double.parseDouble(splitLine[7]), Double.parseDouble(splitLine[8]), Double.parseDouble(splitLine[6]));
                        }
                        orderListTemp = new HashMap();
                        orderListTemp.put(splitLine[4], floorTemp);
                        customerTemp = new Customer(splitLine[0], splitLine[1], splitLine[2], Double.parseDouble(splitLine[3]), orderListTemp);
                        System.out.println(customerTemp.toString());
                    }
                    break;
                case 2:
                    String firstName = console.readString("Please enter your first name.");
                    String lastName = console.readString("Please enter your last name.");

                    if (book.findCustomer(firstName, lastName, orderBook) != null) {
                        int material = console.readInteger("What flooring material are you ordering? \n\t 1. Wood\n\t 2. Laminate\n\t 3. Carpet\n\t 4. Tile", 1, 4);
                        double area = console.readDoubleMat("Please enter the area to be floored.\n", 1, 30000);
                        if (material == 1) {
                            Wood wood = new Wood("Wood", woodCost, woodLabor, area);
                            orderNumber = book.findCustomer(firstName, lastName, orderBook).addOrder(book.findCustomer(firstName, lastName, orderBook), wood);
                        }
                        if (material == 2) {
                            Laminate lamb = new Laminate("Laminate", laminateCost, laminateLabor, area);
                            orderNumber = book.findCustomer(firstName, lastName, orderBook).addOrder(book.findCustomer(firstName, lastName, orderBook), lamb);
                        }
                        if (material == 3) {
                            Carpet car = new Carpet("Carpet", carpetCost, carpetLabor, area);
                            orderNumber = book.findCustomer(firstName, lastName, orderBook).addOrder(book.findCustomer(firstName, lastName, orderBook), car);
                        }
                        if (material == 4) {
                            Tile tile = new Tile("Tile", tileCost, tileLabor, area);
                            orderNumber = book.findCustomer(firstName, lastName, orderBook).addOrder(book.findCustomer(firstName, lastName, orderBook), tile);
                        }
                        System.out.println();
                        System.out.println(book.findCustomer(firstName, lastName, orderBook).displayOrder(book.findCustomer(firstName, lastName, orderBook), orderList, orderNumber));
                        String decision = console.readString("Would you like place this order? (Y or N)");
                        if (decision.equalsIgnoreCase("n") || decision.equalsIgnoreCase("no")) {
                            book.findCustomer(firstName, lastName, orderBook).removeOrder(orderNumber, orderList);
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
                            orderBook.add(customer);
                        }
                        if (material == 2) {
                            Laminate lamb = new Laminate("Laminate", laminateCost, laminateLabor, area);
                            orderNumber = customer.addOrder(customer, lamb);
                            orderBook.add(customer);
                        }
                        if (material == 3) {
                            Carpet car = new Carpet("Carpet", carpetCost, carpetLabor, area);
                            orderNumber = customer.addOrder(customer, car);
                            orderBook.add(customer);
                        }
                        if (material == 4) {
                            Tile tile = new Tile("Tile", tileCost, tileLabor, area);
                            orderNumber = customer.addOrder(customer, tile);
                            orderBook.add(customer);
                        }
                        System.out.println(customer.displayOrder(customer, orderList, orderNumber));
                        String decision = console.readString("Would you like place this order? (Y or N)");
                        if (decision.equalsIgnoreCase("n") || decision.equalsIgnoreCase("no")) {
                            customer.removeOrder(orderNumber, orderList);
                        }
                    }
                    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                    Calendar cal = Calendar.getInstance();
                    //access.writeOrder(dateFormat.format(cal.getTime()) + ".txt", orderBook);
                    break;
                case 3:
                    boolean playing = true;
                    ArrayList<Customer> tempBook = new ArrayList();
                    ArrayList<String> displayOrder3 = new ArrayList();
                    HashMap<String, Flooring> orderListTemp2 = new HashMap();
                     String datIn = "";
                    do {
                        datIn = console.readString("What date did you complete your order? (YYYYMMDD)");
                        displayOrder3 = access.readOrder(datIn+".txt");
                        Customer customerTemp2;
                        Flooring floorTemp2 = null;
                        String[] splitLine2;
                        for (String k : displayOrder3) {
                            splitLine2 = k.split("::");
                            if (splitLine2[5].equalsIgnoreCase("wood")) {
                                floorTemp2 = new Wood(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            } else if (splitLine2[5].equalsIgnoreCase("tile")) {
                                floorTemp2 = new Tile(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            } else if (splitLine2[5].equalsIgnoreCase("carpet")) {
                                floorTemp2 = new Carpet(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            } else if (splitLine2[5].equalsIgnoreCase("laminate")) {
                                floorTemp2 = new Laminate(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            }
                            orderListTemp2 = new HashMap();
                            orderListTemp2.put(splitLine2[4], floorTemp2);
                            customerTemp2 = new Customer(splitLine2[0], splitLine2[1], splitLine2[2], Double.parseDouble(splitLine2[3]), orderListTemp2);
                            tempBook.add(customerTemp2);
                        }
                        orderNumber = console.readString("Please enter the order number of the order you would like to edit? ");
                        String dateEntered = orderNumber.substring(0, 8);
                        if (!(datIn.equals(dateEntered))) {
                            System.out.println("That order was not on that date.");
                            String tryAgain = console.readString("Would you like to try again?");
                            if (tryAgain.equalsIgnoreCase("no") || tryAgain.equalsIgnoreCase("n")) {
                                playing = false;
                            }
                        } else {
                            playing = false;
                        }
                    } while (playing);
                    Customer cust = new Customer();
                    if (!displayOrder3.isEmpty()) {
                        for (Customer g : tempBook) {
                            //System.out.println(g);
                            Set<String> keys = orderListTemp2.keySet();
                            for (String k : keys) {
                                if (k.equals(orderNumber)) {
                                   cust = g;
                                }
                            }
                        }
                            
                                String first = console.readString("Edit customer first name (" + cust.getFirstName() + "):\n");
                                if (first.equals("")) {
                                    cust.setFirstName(cust.getFirstName());
                                } else {
                                    cust.setFirstName(first);
                                }
                                String last = console.readString("Edit customer last name (" + cust.getLastName() + "):\n");
                                if (last.equals("")) {
                                    cust.setLastName(cust.getLastName());
                                } else {
                                    cust.setLastName(last);
                                }
                                String state = console.readString("Edit state (" + cust.getState() + "):\n\t"
                                        + "State choices (OH, PA, MI, IN)");
                                if (state.equals("")) {
                                    cust.setState(cust.getState());
                                } else {
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
                                String material = console.readString("Edit flooring material (" + orderListTemp2.get(orderNumber).getProductType() + "):\t"
                                        + "Material choices (Wood, Laminate, Carpet, Tile)");
                                double area = console.readDouble("Edit area (" + orderListTemp2.get(orderNumber).getArea() + "):");

                                if (material.equals("") && area == 0) {
                                    break;
                                } else if (!material.equals("") && area != 0) {
                                    if (material.equalsIgnoreCase("wood")) {
                                        Wood temp = new Wood("Wood", woodCost, woodLabor, area);
                                        orderListTemp2.put(orderNumber, temp);
                                    } else if (material.equalsIgnoreCase("laminate")) {
                                        Laminate temp = new Laminate("Laminate", laminateCost, laminateLabor, area);
                                        orderListTemp2.put(orderNumber, temp);
                                    } else if (material.equalsIgnoreCase("carpet")) {
                                        Carpet temp = new Carpet("Carpet", carpetCost, carpetLabor, area);
                                        orderListTemp2.put(orderNumber, temp);
                                    } else if (material.equalsIgnoreCase("tile")) {
                                        Tile temp = new Tile("Tile", tileCost, tileLabor, area);
                                        orderListTemp2.put(orderNumber, temp);
                                    }
                                } else if (!material.equals("") && area == 0) {
                                    if (material.equalsIgnoreCase("wood")) {
                                        Wood temp = new Wood("Wood", woodCost, woodLabor, orderListTemp2.get(orderNumber).getArea());
                                        orderListTemp2.put(orderNumber, temp);
                                    } else if (material.equalsIgnoreCase("laminate")) {
                                        Laminate temp = new Laminate("Laminate", laminateCost, laminateLabor, orderListTemp2.get(orderNumber).getArea());
                                        orderListTemp2.put(orderNumber, temp);
                                    } else if (material.equalsIgnoreCase("carpet")) {
                                        Carpet temp = new Carpet("Carpet", carpetCost, carpetLabor, orderListTemp2.get(orderNumber).getArea());
                                        orderListTemp2.put(orderNumber, temp);
                                    } else if (material.equalsIgnoreCase("tile")) {
                                        Tile temp = new Tile("Tile", tileCost, tileLabor, orderListTemp2.get(orderNumber).getArea());
                                        orderListTemp2.put(orderNumber, temp);
                                    }
                                } else if (material.equals("") && area != 0) {
                                    orderListTemp2.get(orderNumber).setArea(area);
                                }
                        
                        //access.writeOrder(datIn+".txt", tempBook);
                    }
                    break;
                case 4:
                    playing = true;
                    String dateIn  = "";
                    ArrayList<Customer> tempBook2 = new ArrayList();
                    ArrayList<String> displayOrderTwo = new ArrayList();
                    HashMap<String, Flooring> orderListTemp3 = new HashMap();
                    do {
                        dateIn = console.readString("What date did you complete your order? (YYYYMMDD)");
                        orderNumber = console.readString("Please enter the order number of the order you would like to edit? ");
                        
                        displayOrderTwo = access.readOrder(dateIn+".txt");
                        
                         
                        Customer customerTemp2;
                        Flooring floorTemp2 = null;
                        String[] splitLine2;
                        for (String k : displayOrderTwo) {
                            splitLine2 = k.split("::");
                            if (splitLine2[5].equalsIgnoreCase("wood")) {
                                floorTemp2 = new Wood(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            } else if (splitLine2[5].equalsIgnoreCase("tile")) {
                                floorTemp2 = new Tile(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            } else if (splitLine2[5].equalsIgnoreCase("carpet")) {
                                floorTemp2 = new Carpet(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            } else if (splitLine2[5].equalsIgnoreCase("laminate")) {
                                floorTemp2 = new Laminate(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
                            }
                            orderListTemp3 = new HashMap();
                            orderListTemp3.put(splitLine2[4], floorTemp2);
                            customerTemp2 = new Customer(splitLine2[0], splitLine2[1], splitLine2[2], Double.parseDouble(splitLine2[3]), orderListTemp3);
                            tempBook2.add(customerTemp2);
                        }
                        
                        
                        if (!(dateIn.equals(orderNumber.substring(0, 8)))) {
                            System.out.println("That order was not on that date.");
                            String tryAgain = console.readString("Would you like to try again?");
                            if (tryAgain.equalsIgnoreCase("no") || tryAgain.equalsIgnoreCase("n")) {
                               playing = false;
                            }
                        } else {
                            playing = false;
                        }
                    } while (playing);
                    if (!displayOrderTwo.isEmpty()) {
                        System.out.println(customer.displayOrder(orderNumber, tempBook2));
                        String sure = console.readString("Please confirm that this is the order you would like to remove. (Y or N)");
                        if (sure.equalsIgnoreCase("y") || sure.equalsIgnoreCase("yes")) {
                            customer.removeOrder(orderNumber, orderListTemp3);
                        }
                        //access.writeOrder(dateIn+".txt", tempBook2);
                    }
                    
                    break;
                case 5:
                    dateFormat = new SimpleDateFormat("yyyyMMdd");
                    Calendar cal2 = Calendar.getInstance();
                    //access.writeOrder(dateFormat.format(cal2.getTime()) + ".txt", orderBook);
                    break;
                case 6:
                    yesNo = false;
                    return;
            }
        } while (yesNo);

    
}

public Customer findCustomer(String first, String last, ArrayList<Customer> orderBook) {
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
