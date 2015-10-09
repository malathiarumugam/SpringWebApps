/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import operations.Business;
import operations.Family;
import operations.Hotel;
import operations.Team;
import ui.UI;

/**
 *
 * @author apprentice
 */
public class Controller {

    UI console = new UI();
    Hotel hotel;

    public Controller(Hotel hotel) {

        this.hotel = hotel;
    }

    public int displayMenu() {

        console.writeln("\nWelcome to ASK Hotel"
        +"Would you like to "
        +"\n\t1) Book reservation "
        +"\n\t2) Cancel reservation "
        +"\n\t3) Checkout "
        +"\n\t4) Exit \n");
        return console.readInteger("Please make a choice", 1, 4);
    }

    public void book() {
        String name, date, group, number;
        double length;
        boolean smoke;
        boolean air;

        name = console.readString("What is your name? ");
        number = console.readString("What is your phone number? ");
        length = console.readDouble("How long will you be staying with us? ", 1, 14);
        date = console.readString("What day will you be checking in: YYYY, MM, DD");
        smoke = console.readBoolean("Would you like a smoking room? ");
        if (smoke) {
            air = false;
        } else {
            air = true;
        }
        group = console.readString("Are you here for business, family, or as a team? ");
        if (group.equalsIgnoreCase("business")) {
            hotel.bookReservation(length, new Business(name, number, length), smoke, air, date);
        } else if (group.equalsIgnoreCase("family")) {
            hotel.bookReservation(length, new Family(name, number, length), smoke, air, date);
        } else if (group.equalsIgnoreCase("team")) {
            hotel.bookReservation(length, new Team(name, number, length), smoke, air, date);
        } else {
            console.writeln("We dont take your type.");
        }

    }

    public void cancel() {
        String name, date;
        double length;

        name = console.readString("What is your name? ");
        length = console.readDouble("How long was your scheduled stay with us? ", 1, 14);
        date = console.readString("What day did you check in?  (YYYY, MM, DD)");

        hotel.cancelReservation(date, length, name);

    }

    public void out() {
        String name, date;
        double length;

        name = console.readString("What is your name? ");
        length = console.readDouble("How long was your stay with us? ", 1, 14);
        date = console.readString("What day did you check in? (YYYY, MM, DD)");
        
        console.writeln(hotel.checkOut(date, length, name));
        

    }

    public void runMenu() {
        int choice;
        boolean quit = false;
        hotel.fillRooms();

        while (!quit) {
            choice = displayMenu();
            if (choice == 1) {
                book();
            } else if (choice == 2) {
                cancel();
            } else if (choice == 3) {
                out();
            } else {
                quit = true;
            }

        }

    }

}
