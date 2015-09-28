package DTO;

import DAO.Access;
import Operation.Carpet;
import Operation.Customer;
import Operation.Customizable;
import Operation.Florable;
import Operation.Laminate;
import Operation.Tile;
import Operation.Wood;
import UI.Console;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class OrderBook {

    ArrayList<Customer> orderBook = new ArrayList();

    public OrderBook(ArrayList<Customer> book) {
        orderBook = book;
    }

    public void run() {

        Console console = new Console();
        HashMap<String, Florable> orderList = new HashMap();
        Customer customer = new Customer();
        Access access = new Access();
        String states = "states";
        String products = "products";

        OrderBook book = new OrderBook(orderBook);

        String orderNumber = "";
        double tax = 0.0;

        HashMap<String, Double> stateTaxes = access.readTaxes("Data/" + states);

        ArrayList<String> productCosts = access.readCost("Data/" + products);
        double woodCost = Double.parseDouble(productCosts.get(10));
        double woodLabor = Double.parseDouble(productCosts.get(11));
        double carpetCost = Double.parseDouble(productCosts.get(1));
        double carpetLabor = Double.parseDouble(productCosts.get(2));
        double laminateCost = Double.parseDouble(productCosts.get(4));
        double laminateLabor = Double.parseDouble(productCosts.get(5));
        double tileCost = Double.parseDouble(productCosts.get(7));
        double tileLabor = Double.parseDouble(productCosts.get(8));

        ArrayList<String> productTypes = new ArrayList();
        productTypes.add(productCosts.get(9));
        productTypes.add(productCosts.get(3));
        productTypes.add(productCosts.get(0));
        productTypes.add(productCosts.get(6));

        boolean yesNo = true;
        do {
            displayMenu();
            int input = console.readInteger("What would you like to do?", 1, 7);

            switch (input) {
                case 1:
                    String date = "";
                    boolean keepSearching = true;

                    do {
                        date = console.readString("What date did you complete your order? (YYYYMMDD)");
                        if (date.length() == 8) {
                            try {
                                ArrayList<String> displayOrder = access.readOrder("Data/" + date + ".txt");
                                HashMap<String, Florable> orderListTemp;
                                Customizable customerTemp;
                                Florable floorTemp = null;
                                String[] splitLine;
                                if (displayOrder.isEmpty()) {
                                    System.out.println("That date has no orders.");
                                }
                                for (String k : displayOrder) {
                                    splitLine = k.split("::");
                                    floorTemp = book.findFlooring(splitLine);
                                    orderListTemp = new HashMap();
                                    orderListTemp.put(splitLine[4], floorTemp);
                                    customerTemp = new Customer(splitLine[0], splitLine[1], splitLine[2], Double.parseDouble(splitLine[3]), orderListTemp);
                                    System.out.println(customerTemp.toString());
                                    keepSearching = false;

                                }
                                if (!keepSearching) {
                                    break;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("That date has no orders.");
                            }
                        } 
                        console.write("That was not a valid date.\n");
                        String tryAgain = console.readString("Would you like to enter another date?");
                        if (tryAgain.equalsIgnoreCase("no") || tryAgain.equalsIgnoreCase("n")) {
                            keepSearching = false;
                        }
                    } while (keepSearching);
                    break;
                case 2:
                    String firstName = console.readString("Please enter your first name.");
                    String lastName = console.readString("Please enter your last name.");
                    orderList = new HashMap();
                    String state = "";
                    boolean rightState = true;
                    do {
                        state = console.readString("Which state are you ordering in? (" + book.displayStates(stateTaxes) + ")");
                        Set<String> key = stateTaxes.keySet();
                        for (String k : key) {
                            if (state.equalsIgnoreCase(k)) {
                                rightState = false;
                            }
                        }
                        if (rightState) {
                            console.write("Did not recognize that state, please try again.");
                        }
                    } while (rightState);
                    tax = book.returnStateTax(state, stateTaxes);

                    customer = new Customer(firstName, lastName, state, tax, orderList);
                    int material = console.readInteger("What flooring material are you ordering? \n\t " + book.displayTypesNum(productTypes), 1, 4);
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

                    break;
                case 3:
                    boolean playing = true;
                    ArrayList<Customer> tempBook = new ArrayList();
                    ArrayList<String> displayOrder3 = new ArrayList();
                    HashMap<String, Florable> orderListTemp2 = new HashMap();
                    String datIn = "";
                    Customer customerTemp2 = new Customer();
                    do {
                        datIn = console.readString("What date did you complete your order? (YYYYMMDD)");
                        displayOrder3 = access.readOrder("Data/" + datIn + ".txt");

                        Florable floorTemp2 = null;
                        String[] splitLine2;
                        for (String k : displayOrder3) {
                            splitLine2 = k.split("::");
                            floorTemp2 = book.findFlooring(splitLine2);
                            orderListTemp2 = new HashMap();
                            orderListTemp2.put(splitLine2[4], floorTemp2);
                            customerTemp2 = new Customer(splitLine2[0], splitLine2[1], splitLine2[2], Double.parseDouble(splitLine2[3]), orderListTemp2);
                            tempBook.add(customerTemp2);
                        }
                        do {
                            orderNumber = console.readString("Please enter the order number of the order you would like to edit? ");
                            if (orderNumber.length() != 14) {
                                System.out.println("That is not a valid order number.");
                            }
                        } while (orderNumber.length() != 14);
                        String dateEntered = orderNumber.substring(0, 8);
                        if (!(datIn.equals(dateEntered))) {
                            System.out.println("That order was not on that date. Did you save your files before trying to edit?");
                            String tryAgain = console.readString("Would you like to try again?");
                            if (tryAgain.equalsIgnoreCase("no") || tryAgain.equalsIgnoreCase("n")) {
                                playing = false;
                            }
                        } else {
                            playing = false;
                        }
                    } while (playing);
                    Customizable cust = new Customer();
                    if (!displayOrder3.isEmpty()) {
                        for (Customizable g : tempBook) {
                            Set<String> keys = g.getOrderList().keySet();
                            for (String k : keys) {
                                if (k.equals(orderNumber)) {
                                    cust = g;
                                }
                            }
                        }
                        tempBook.remove(cust);
                        String first = console.readString("Edit customer first name (" + cust.getFirstName() + "):");
                        if (first.isEmpty()) {
                            first = cust.getFirstName();

                        } else {
                            //customerTemp2.setFirstName(first);
                        }
                        String last = console.readString("Edit customer last name (" + cust.getLastName() + "):");
                        if (last.isEmpty()) {
                            last = cust.getLastName();
                        } else {
                            //customerTemp2.setLastName(last);
                        }
                        String state1 = "";
                        rightState = true;
                        do {
                            state1 = console.readString("Which state are you ordering in? (" + book.displayStates(stateTaxes) + ")");
                            Set<String> key = stateTaxes.keySet();
                            for (String k : key) {
                                if (state1.equalsIgnoreCase(k)) {
                                    rightState = false;
                                }
                            }
                            if (rightState) {
                                console.write("Did not recognize that state, please try again.");
                            }
                        } while (rightState);
                        tax = book.returnStateTax(state1, stateTaxes);
                        String material1 = console.readString("Edit flooring material (" + cust.getOrderList().get(orderNumber).getProductType() + "):\t"
                                + "Material choices" + book.displayTypes(productTypes));
                        double area1 = console.readDouble("Edit area (" + cust.getOrderList().get(orderNumber).getArea() + "):");

                        if (material1.isEmpty() && area1 == 0) {

                        } else if (!material1.isEmpty() && area1 != 0) {
                            if (material1.equalsIgnoreCase("wood")) {
                                Wood temp = new Wood("Wood", woodCost, woodLabor, area1);
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            } else if (material1.equalsIgnoreCase("laminate")) {
                                Laminate temp = new Laminate("Laminate", laminateCost, laminateLabor, area1);
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            } else if (material1.equalsIgnoreCase("carpet")) {
                                Carpet temp = new Carpet("Carpet", carpetCost, carpetLabor, area1);
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            } else if (material1.equalsIgnoreCase("tile")) {
                                Tile temp = new Tile("Tile", tileCost, tileLabor, area1);
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            }
                        } else if (!material1.isEmpty() && area1 == 0) {
                            if (material1.equalsIgnoreCase("wood")) {
                                Wood temp = new Wood("Wood", woodCost, woodLabor, cust.getOrderList().get(orderNumber).getArea());
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            } else if (material1.equalsIgnoreCase("laminate")) {
                                Laminate temp = new Laminate("Laminate", laminateCost, laminateLabor, cust.getOrderList().get(orderNumber).getArea());
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            } else if (material1.equalsIgnoreCase("carpet")) {
                                Carpet temp = new Carpet("Carpet", carpetCost, carpetLabor, cust.getOrderList().get(orderNumber).getArea());
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            } else if (material1.equalsIgnoreCase("tile")) {
                                Tile temp = new Tile("Tile", tileCost, tileLabor, cust.getOrderList().get(orderNumber).getArea());
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            }
                        } else if (material1.isEmpty() && area1 != 0) {
                            cust.getOrderList().get(orderNumber).setArea(area1);
                            HashMap<String, Florable> update = cust.getOrderList();
                            update.get(orderNumber).getTax(tax);
                            update.get(orderNumber).getTotal(tax);
                        }
                        Customer customerT = new Customer(first, last, state1, tax, cust.getOrderList());
                        tempBook.add(customerT);
                        access.writeOrderString("Data/" + datIn + ".txt", book.makeObjectString(tempBook));
                    } else {
                        System.out.println("No file was found.");
                    }
                    break;
                case 4:
                    playing = true;
                    String dateIn = "";
                    ArrayList<Customer> tempBook2 = new ArrayList();
                    ArrayList<String> displayOrderTwo = new ArrayList();
                    HashMap<String, Florable> orderListTemp3 = new HashMap();
                    do {
                        dateIn = console.readString("What date did you complete your order? (YYYYMMDD)");
                        orderNumber = console.readString("Please enter the order number of the order you would like to remove? ");

                        displayOrderTwo = access.readOrder("Data/" + dateIn + ".txt");

                        Customer customerTemp3;
                        Florable floorTemp2 = null;
                        String[] splitLine2;
                        for (String k : displayOrderTwo) {
                            splitLine2 = k.split("::");
                            floorTemp2 = book.findFlooring(splitLine2);
                            orderListTemp3 = new HashMap();
                            orderListTemp3.put(splitLine2[4], floorTemp2);
                            customerTemp3 = new Customer(splitLine2[0], splitLine2[1], splitLine2[2], Double.parseDouble(splitLine2[3]), orderListTemp3);
                            tempBook2.add(customerTemp3);
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
                    Customer custo = new Customer();
                    if (!displayOrderTwo.isEmpty()) {
                        System.out.println(customer.displayOrder(orderNumber, tempBook2));
                        String sure = console.readString("Please confirm that this is the order you would like to remove. (Y or N)");
                        if (sure.equalsIgnoreCase("y") || sure.equalsIgnoreCase("yes")) {

                            for (Customer g : tempBook2) {
                                Set<String> keys = orderListTemp3.keySet();
                                for (String k : keys) {
                                    if (k.equals(orderNumber)) {
                                        custo = g;
                                    }
                                }
                            }
                            customer.removeOrder(orderNumber, orderListTemp3);
                            tempBook2.remove(custo);
                        }
                        access.writeOrderString("Data/" + dateIn + ".txt", book.makeObjectString(tempBook2));
                    }

                    break;
                case 5:

                    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                    Calendar cal2 = Calendar.getInstance();
                    Customer customerTemp4 = null;
                    Florable floorTemp2 = null;
                    HashMap<String, Florable> saveHashMap = new HashMap();
                    try {
                        ArrayList<String> tempToday = access.readOrder("Data/" + dateFormat.format(cal2.getTime()) + ".txt");

                        String[] splitLine2;
                        for (String k : tempToday) {
                            splitLine2 = k.split("::");
                            floorTemp2 = book.findFlooring(splitLine2);

                            saveHashMap.put(splitLine2[4], floorTemp2);
                            customerTemp4 = new Customer(splitLine2[0], splitLine2[1], splitLine2[2], Double.parseDouble(splitLine2[3]), saveHashMap);
                            orderBook.add(customerTemp4);
                        }
                    } catch (NullPointerException e) {

                    }
                    access.writeOrderString("Data/" + dateFormat.format(cal2.getTime()) + ".txt", book.makeObjectString(orderBook));
                    console.write("Your work has been saved!\n");
                    orderBook.clear();

                    break;
                case 6:
                    yesNo = false;
                    return;

                case 7:
                    String stateInput = "";
                    rightState = true;
                    boolean wrongState = true;
                    ArrayList<String> USA = access.readUSA("Data/USA");
                    Set<String> key = stateTaxes.keySet();
                    stateInput = console.readString("Enter the state you would like to include.");
                    for (String k : key) {
                        if (stateInput.equalsIgnoreCase(k)) {
                            console.write("That state is already in the system.\n");
                            wrongState = false;
                            break;
                        }
                    }
                    if (!wrongState) {
                        break;
                    }
                    while (rightState) {
                        for (String current : USA) {
                            if (stateInput.equalsIgnoreCase(current)) {
                                rightState = false;
                            }
                        }    
                        if (rightState) {
                            console.write("Did not recognize that state, please try again.\n");
                            stateInput = console.readString("Enter the state you would like to include.");
                        }
                    } 
                     
                    double taxInput = console.readDouble("Enter the tax rate for that state.");
                    stateTaxes.put(stateInput, taxInput);
                    access.writeOrderString("Data/" + states, book.makeStateString(stateTaxes));

            }
        } while (yesNo);

    }

    public void testRun() {

        Console console = new Console();
        HashMap<String, Florable> orderList = new HashMap();
        Customer customer = new Customer();
        Access access = new Access();
        String states = "states";
        String products = "products";

        OrderBook book = new OrderBook(orderBook);

        String orderNumber = "";
        double tax = 0.0;

        HashMap<String, Double> stateTaxes = access.readTaxes("Data/" + states);

        ArrayList<String> productCosts = access.readCost("Data/" + products);
        double woodCost = Double.parseDouble(productCosts.get(10));
        double woodLabor = Double.parseDouble(productCosts.get(11));
        double carpetCost = Double.parseDouble(productCosts.get(1));
        double carpetLabor = Double.parseDouble(productCosts.get(2));
        double laminateCost = Double.parseDouble(productCosts.get(4));
        double laminateLabor = Double.parseDouble(productCosts.get(5));
        double tileCost = Double.parseDouble(productCosts.get(7));
        double tileLabor = Double.parseDouble(productCosts.get(8));

        ArrayList<String> productTypes = new ArrayList();
        productTypes.add(productCosts.get(9));
        productTypes.add(productCosts.get(3));
        productTypes.add(productCosts.get(0));
        productTypes.add(productCosts.get(6));

        boolean yesNo = true;
        do {
            displayMenu();
            int input = console.readInteger("What would you like to do?", 1, 7);

            switch (input) {
                case 1:
                    String date = "";
                    boolean keepSearching = true;

                    do {
                        date = console.readString("What date did you complete your order? (YYYYMMDD)");
                        if (date.length() == 8) {
                            try {
                                ArrayList<String> displayOrder = access.readOrder("Data/" + date + ".txt");
                                HashMap<String, Florable> orderListTemp;
                                Customizable customerTemp;
                                Florable floorTemp = null;
                                String[] splitLine;
                                if (displayOrder.isEmpty()) {
                                    System.out.println("That date has no orders.");
                                }
                                for (String k : displayOrder) {
                                    splitLine = k.split("::");
                                    floorTemp = book.findFlooring(splitLine);
                                    orderListTemp = new HashMap();
                                    orderListTemp.put(splitLine[4], floorTemp);
                                    customerTemp = new Customer(splitLine[0], splitLine[1], splitLine[2], Double.parseDouble(splitLine[3]), orderListTemp);
                                    System.out.println(customerTemp.toString());
                                    keepSearching = false;

                                }
                                if (!keepSearching) {
                                    break;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("That date has no orders.");
                            }
                        }
                        String tryAgain = console.readString("Would you like to enter another date?");
                        if (tryAgain.equalsIgnoreCase("no") || tryAgain.equalsIgnoreCase("n")) {
                            keepSearching = false;
                        }
                    } while (keepSearching);
                    break;
                case 2:
                    String firstName = console.readString("Please enter your first name.");
                    String lastName = console.readString("Please enter your last name.");
                    orderList = new HashMap();
                    String state = console.readString("Which state are you ordering in? (" + book.displayStates(stateTaxes) + ")");
                    tax = book.returnStateTax(state, stateTaxes);

                    customer = new Customer(firstName, lastName, state, tax, orderList);
                    int material = console.readInteger("What flooring material are you ordering? \n\t " + book.displayTypesNum(productTypes), 1, 4);
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

                    break;
                case 3:
                    boolean playing = true;
                    ArrayList<Customer> tempBook = new ArrayList();
                    ArrayList<String> displayOrder3 = new ArrayList();
                    HashMap<String, Florable> orderListTemp2 = new HashMap();
                    String datIn = "";
                    Customer customerTemp2 = new Customer();
                    do {
                        datIn = console.readString("What date did you complete your order? (YYYYMMDD)");
                        displayOrder3 = access.readOrder("Data/" + datIn + ".txt");

                        Florable floorTemp2 = null;
                        String[] splitLine2;
                        for (String k : displayOrder3) {
                            splitLine2 = k.split("::");
                            floorTemp2 = book.findFlooring(splitLine2);
                            orderListTemp2 = new HashMap();
                            orderListTemp2.put(splitLine2[4], floorTemp2);
                            customerTemp2 = new Customer(splitLine2[0], splitLine2[1], splitLine2[2], Double.parseDouble(splitLine2[3]), orderListTemp2);
                            tempBook.add(customerTemp2);
                        }
                        do {
                            orderNumber = console.readString("Please enter the order number of the order you would like to edit? ");
                            if (orderNumber.length() != 14) {
                                System.out.println("That is not a valid order number.");
                            }
                        } while (orderNumber.length() != 14);
                        String dateEntered = orderNumber.substring(0, 8);
                        if (!(datIn.equals(dateEntered))) {
                            System.out.println("That order was not on that date. Did you save your files before trying to edit?");
                            String tryAgain = console.readString("Would you like to try again?");
                            if (tryAgain.equalsIgnoreCase("no") || tryAgain.equalsIgnoreCase("n")) {
                                playing = false;
                            }
                        } else {
                            playing = false;
                        }
                    } while (playing);
                    Customizable cust = new Customer();
                    if (!displayOrder3.isEmpty()) {
                        for (Customizable g : tempBook) {
                            Set<String> keys = g.getOrderList().keySet();
                            for (String k : keys) {
                                if (k.equals(orderNumber)) {
                                    cust = g;
                                }
                            }
                        }
                        tempBook.remove(cust);
                        String first = console.readString("Edit customer first name (" + cust.getFirstName() + "):");
                        if (first.isEmpty()) {
                            first = cust.getFirstName();

                        } else {
                            //customerTemp2.setFirstName(first);
                        }
                        String last = console.readString("Edit customer last name (" + cust.getLastName() + "):");
                        if (last.isEmpty()) {
                            last = cust.getLastName();
                        } else {
                            //customerTemp2.setLastName(last);
                        }
                        String state1 = console.readString("Edit state (" + cust.getState() + "):\t");
                        tax = book.returnStateTax(state1, stateTaxes);
                        String material1 = console.readString("Edit flooring material (" + cust.getOrderList().get(orderNumber).getProductType() + "):\t"
                                + "Material choices" + book.displayTypes(productTypes));
                        double area1 = console.readDouble("Edit area (" + cust.getOrderList().get(orderNumber).getArea() + "):");

                        if (material1.isEmpty() && area1 == 0) {

                        } else if (!material1.isEmpty() && area1 != 0) {
                            if (material1.equalsIgnoreCase("wood")) {
                                Wood temp = new Wood("Wood", woodCost, woodLabor, area1);
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            } else if (material1.equalsIgnoreCase("laminate")) {
                                Laminate temp = new Laminate("Laminate", laminateCost, laminateLabor, area1);
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            } else if (material1.equalsIgnoreCase("carpet")) {
                                Carpet temp = new Carpet("Carpet", carpetCost, carpetLabor, area1);
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            } else if (material1.equalsIgnoreCase("tile")) {
                                Tile temp = new Tile("Tile", tileCost, tileLabor, area1);
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            }
                        } else if (!material1.isEmpty() && area1 == 0) {
                            if (material1.equalsIgnoreCase("wood")) {
                                Wood temp = new Wood("Wood", woodCost, woodLabor, cust.getOrderList().get(orderNumber).getArea());
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            } else if (material1.equalsIgnoreCase("laminate")) {
                                Laminate temp = new Laminate("Laminate", laminateCost, laminateLabor, cust.getOrderList().get(orderNumber).getArea());
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            } else if (material1.equalsIgnoreCase("carpet")) {
                                Carpet temp = new Carpet("Carpet", carpetCost, carpetLabor, cust.getOrderList().get(orderNumber).getArea());
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            } else if (material1.equalsIgnoreCase("tile")) {
                                Tile temp = new Tile("Tile", tileCost, tileLabor, cust.getOrderList().get(orderNumber).getArea());
                                temp.getTax(tax);
                                temp.getTotal(tax);
                                cust.getOrderList().put(orderNumber, temp);
                            }
                        } else if (material1.isEmpty() && area1 != 0) {
                            cust.getOrderList().get(orderNumber).setArea(area1);
                            HashMap<String, Florable> update = cust.getOrderList();
                            update.get(orderNumber).getTax(tax);
                            update.get(orderNumber).getTotal(tax);
                        }
                        Customer customerT = new Customer(first, last, state1, tax, cust.getOrderList());
                        tempBook.add(customerT);
                        //  access.writeOrderString("Data/" + datIn + ".txt", book.makeObjectString(tempBook));
                    } else {
                        System.out.println("No file was found.");
                    }
                    break;
                case 4:
                    playing = true;
                    String dateIn = "";
                    ArrayList<Customer> tempBook2 = new ArrayList();
                    ArrayList<String> displayOrderTwo = new ArrayList();
                    HashMap<String, Florable> orderListTemp3 = new HashMap();
                    do {
                        dateIn = console.readString("What date did you complete your order? (YYYYMMDD)");
                        orderNumber = console.readString("Please enter the order number of the order you would like to remove? ");

                        displayOrderTwo = access.readOrder("Data/" + dateIn + ".txt");

                        Customer customerTemp3;
                        Florable floorTemp2 = null;
                        String[] splitLine2;
                        for (String k : displayOrderTwo) {
                            splitLine2 = k.split("::");
                            floorTemp2 = book.findFlooring(splitLine2);
                            orderListTemp3 = new HashMap();
                            orderListTemp3.put(splitLine2[4], floorTemp2);
                            customerTemp3 = new Customer(splitLine2[0], splitLine2[1], splitLine2[2], Double.parseDouble(splitLine2[3]), orderListTemp3);
                            tempBook2.add(customerTemp3);
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
                    Customer custo = new Customer();
                    if (!displayOrderTwo.isEmpty()) {
                        System.out.println(customer.displayOrder(orderNumber, tempBook2));
                        String sure = console.readString("Please confirm that this is the order you would like to remove. (Y or N)");
                        if (sure.equalsIgnoreCase("y") || sure.equalsIgnoreCase("yes")) {

                            for (Customer g : tempBook2) {
                                Set<String> keys = orderListTemp3.keySet();
                                for (String k : keys) {
                                    if (k.equals(orderNumber)) {
                                        custo = g;
                                    }
                                }
                            }
                            customer.removeOrder(orderNumber, orderListTemp3);
                            tempBook2.remove(custo);
                        }
                        //   access.writeOrderString("Data/" + dateIn + ".txt", book.makeObjectString(tempBook2));
                    }

                    break;
                case 5:

                    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                    Calendar cal2 = Calendar.getInstance();
                    Customer customerTemp4 = null;
                    Florable floorTemp2 = null;
                    HashMap<String, Florable> saveHashMap = new HashMap();
                    try {
                        ArrayList<String> tempToday = access.readOrder("Data/" + dateFormat.format(cal2.getTime()) + ".txt");

                        String[] splitLine2;
                        for (String k : tempToday) {
                            splitLine2 = k.split("::");
                            floorTemp2 = book.findFlooring(splitLine2);

                            saveHashMap.put(splitLine2[4], floorTemp2);
                            customerTemp4 = new Customer(splitLine2[0], splitLine2[1], splitLine2[2], Double.parseDouble(splitLine2[3]), saveHashMap);
                            orderBook.add(customerTemp4);
                        }
                    } catch (NullPointerException e) {

                    }
                    // access.writeOrderString("Data/" + dateFormat.format(cal2.getTime()) + ".txt", book.makeObjectString(orderBook));
                    // console.write("Your work has been saved!\n");
                    // orderBook.clear();

                    break;
                case 6:
                    yesNo = false;
                    return;

                case 7:
                    String stateInput = console.readString("Enter the state you would like to include.");
                    double taxInput = console.readDouble("Enter the tax rate for that state.");
                    stateTaxes.put(stateInput, taxInput);
                // access.writeOrderString("Data/" + states, book.makeStateString(stateTaxes));

            }
        } while (yesNo);

    }

    public ArrayList<String> makeObjectString(ArrayList<Customer> tempBook2) {
        Customizable customerT;
        Iterator<Customer> iter = tempBook2.iterator();
        String outString = "";
        ArrayList<String> stringList = new ArrayList();
        while (iter.hasNext()) {
            customerT = iter.next();
            outString = customerT.getFirstName() + "::"
                    + customerT.getLastName() + "::"
                    + customerT.getState() + "::"
                    + customerT.getTaxRate() + "::";
            Set<String> keys = customerT.getOrderList().keySet();
            for (String k : keys) {
                outString += k + "::" + customerT.getOrderList().get(k).getProductType() + "::" + customerT.getOrderList().get(k).getArea() + "::"
                        + customerT.getOrderList().get(k).getCostPerSqFt() + "::" + customerT.getOrderList().get(k).getLaborPerSqFt() + "::"
                        + customerT.getOrderList().get(k).getMaterialCost() + "::" + customerT.getOrderList().get(k).getLaborCost() + "::"
                        + customerT.getOrderList().get(k).getTax(customerT.getTaxRate()) + "::"
                        + customerT.getOrderList().get(k).getTotal(customerT.getTaxRate());
            }
            stringList.add(outString);
        }
        return stringList;
    }

    public ArrayList<String> makeStateString(HashMap<String, Double> states) {
        ArrayList<String> stringList = new ArrayList();
        String outString = "";
        Set<String> keys = states.keySet();
        for (String k : keys) {
            outString = k + "," + states.get(k);
            stringList.add(outString);
        }

        return stringList;
    }

    public Customer findCustomer(String first, String last, ArrayList<Customer> orderBook) {
        for (Customer cust : orderBook) {
            if (cust.getFirstName().equalsIgnoreCase(first) && cust.getLastName().equalsIgnoreCase(last)) {
                return cust;
            }
        }
        return null;
    }

    public Florable findFlooring(String[] splitLine2) {
        Florable floorTemp2 = null;
        if (splitLine2[5].equalsIgnoreCase("wood")) {
            floorTemp2 = new Wood(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
        } else if (splitLine2[5].equalsIgnoreCase("tile")) {
            floorTemp2 = new Tile(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
        } else if (splitLine2[5].equalsIgnoreCase("carpet")) {
            floorTemp2 = new Carpet(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
        } else if (splitLine2[5].equalsIgnoreCase("laminate")) {
            floorTemp2 = new Laminate(splitLine2[5], Double.parseDouble(splitLine2[7]), Double.parseDouble(splitLine2[8]), Double.parseDouble(splitLine2[6]));
        }

        return floorTemp2;
    }

    public String displayTypesNum(ArrayList<String> types) {
        String list = "";
        int count = 1;
        for (String k : types) {
            list += count + ". " + k + "  ";
            count++;
        }
        return list;
    }

    public String displayTypes(ArrayList<String> types) {
        String list = "";

        for (String k : types) {
            list += " " + k + ". ";

        }
        return list;
    }

    public String displayStates(HashMap<String, Double> states) {
        Set<String> keys = states.keySet();
        String list = "";
        for (String k : keys) {
            list += " " + k + " ";
        }
        return list;
    }

    public double returnStateTax(String state, HashMap<String, Double> states) {
        double tax = 0;
        Set<String> keysState = states.keySet();
        for (String k : keysState) {
            if (state.equalsIgnoreCase(k)) {
                tax = states.get(k);
            }
        }
        return tax;
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
        System.out.println("\n*                Settings Menu");
        System.out.println("\n*");
        System.out.println("\n* 7. Add a state and coinciding tax rate");
        System.out.println("\n* ");
        System.out.println("*************************************************************");
    }

}
