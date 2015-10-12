/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import ui.UI;
import java.time.LocalDate;

/**
 *
 * @author apprentice
 */
public class ASKHotel implements Hotel {

    UI console = new UI();

    private String hotelName = "ASK Hotel";

    private Guest[][] calRooms;
    //365 days for the year, 20 rooms available each day. 
    //calRooms[1][0] = new Family(parameters);
    private Room[] roomInfo;

    //this is the parallel array associated with each second dimensional array

    public ASKHotel() {
        calRooms = new Guest[365][20];
        roomInfo = new Room[20];
    }

    public ASKHotel(Guest[][] rooms, Room[] info) {
        calRooms = rooms;
        roomInfo = info;
    }

    @Override
    public String checkOut(String dateIn, double length, String name) {
        String[] date = dateIn.split(", ");
        int one = Integer.parseInt(date[0]);
        int two = Integer.parseInt(date[1]);
        int three = Integer.parseInt(date[2]);
        LocalDate a = LocalDate.of(one, two, three);
        double roomCost = 0;
        int roomNum = -1;
        double theftCost = 0;

        Guest fred = null;

        for (int j = 0; j < calRooms[0].length; j++) {
            if (calRooms[a.getDayOfYear()][j].getName().equals(name)) {
                fred = calRooms[a.getDayOfYear()][j];
                roomNum = j;
                break;
            }
        }
        if (roomNum >= 0 && roomNum < 10) {
            roomCost = roomInfo[roomNum].getCost();
        } else if (roomNum >= 10) {
            roomCost = roomInfo[roomNum].getCost();
        } else {
            console.write("Room not found");
            return null;
        }
        theftCost = fred.steal("Lamp, Chair, Bible, sheets, towels, tinyLiquorBottle");
        String bill = "Thank you for staying with us!\n"
                + "Invoice:"
                + "\n\tItem 1: Room Cost: $" + roomCost
                + "\n\tItem 2: Additional Cost: $" + theftCost
                + "\nTotal: $" + (roomCost + theftCost) + "\n";
        return bill;
    }

    @Override
    public void cancelReservation(String dateIn, double length, String name) {
        String[] date = dateIn.split(", ");
        int one = Integer.parseInt(date[0]);
        int two = Integer.parseInt(date[1]);
        int three = Integer.parseInt(date[2]);
        LocalDate a = LocalDate.of(one, two, three);

        for (int j = 0; j < calRooms[0].length; j++) {
            if (calRooms[a.getDayOfYear()][j] != null) {
                if (calRooms[a.getDayOfYear()][j].getName().equalsIgnoreCase(name)) {
                    for (int i = 0; i < length; i++) {
                        calRooms[a.getDayOfYear() + i][j] = null;
                        console.write("Your room has been cancelled. :(" + "\n");
                        return;
                    }
                }
            }
        }
    }

    public void fillRooms() {
        for (int i = 0; i < roomInfo.length; i++) {
            if (i < 10) {
                roomInfo[i] = new Room(false, true);
                roomInfo[i].setCost(70);
            } else {
                roomInfo[i] = new Room(true, false);
                roomInfo[i].setCost(80);
            }
        }

    }

    @Override
    public void bookReservation(double length, Guest fred, boolean smoke, boolean aircond, String dateIn) {
        String[] date = dateIn.split(", ");
        int one = Integer.parseInt(date[0]);
        int two = Integer.parseInt(date[1]);
        int three = Integer.parseInt(date[2]);
        LocalDate a = LocalDate.of(one, two, three);
        int roomNum = -1, count = 0;

        if (smoke && !aircond) {
            OUTER:
            for (int i = 10; i < 20; i++) {
                if (calRooms[a.getDayOfYear()][i] == null) {
                    for (int j = 0; j <= length; j++) {
                        if (calRooms[a.getDayOfYear() + j][i] == null) {
                            count++;
                        }
                        if (count == length) {
                            roomNum = i;
                            break OUTER;
                        }
                    }
                }
            }
            if (roomNum == -1) {
                System.out.println("No rooms are available for that date. :(" + "\n");
            }
        } else if (!smoke && aircond) {
            OUTER:
            for (int i = 0; i < 10; i++) {
                if (calRooms[a.getDayOfYear()][i] == null) {
                    for (int j = 0; j <= length; j++) {
                        if (calRooms[a.getDayOfYear() + j][i] == null) {
                            count++;

                        }
                        if (count == length) {
                            roomNum = i;
                            break OUTER;
                        }
                    }
                }
            }
            if (roomNum == -1) {
                System.out.println("No rooms are available for that date. :(" + "\n");
            }
        } else {
            System.out.println("We dont offer that combination of smoking and air conditioning. :)" + "\n");
        }
        if (roomNum != -1) {
            for (int i = 0; i < length; i++) {
                calRooms[a.getDayOfYear()][roomNum] = fred;
            }
            System.out.println("You have been booked for " + length + " days at the " + hotelName + "");
        }
    }

}
