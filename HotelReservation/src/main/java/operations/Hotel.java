/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import java.time.LocalDate;

/**
 *
 * @author apprentice
 */
public class Hotel {
    
    private String hotelName = "ASK Hotel";
    
    private Guest [][] calRooms = new Guest [365][20];
    //365 days for the year, 20 rooms available each day. 
    //calRooms[1][0] = new Family(parameters);
    private Room[] roomInfo = new Room[20];
    //this is the parallel array associated with each second dimensional array

    
    public Hotel (Guest [][] rooms, Room[] info ){
       calRooms = rooms;
       roomInfo = info;
    }
    
    public void fillRooms() {
        for (int i = 0; i < roomInfo.length; i++) {
            if (i < 10) {
                roomInfo[i] = new Room(false, true);
            } else {
                roomInfo[i] = new Room(true, false);
            }
        }

    }
    
    private void bookReservation(double length, Guest fred, boolean smoke, boolean aircond, String dateIn){
        String[] date = dateIn.split(",");
        int one = Integer.parseInt(date[0]);
        int two = Integer.parseInt(date[1]);
        int three = Integer.parseInt(date[2]);
        LocalDate a = LocalDate.of(one, two, three);
        int roomNum = 0, count = 0; 
       

        if (smoke && !aircond) {
            OUTER: for (int i = 10; i < 20; i++) {
                if (calRooms[a.getDayOfYear()][i] == null) {
                    for (int j = a.getDayOfYear(); j <= length; j++) {
                        if (calRooms[j][i] == null) {
                            count++;
                        }
                        if (count == length) {
                            roomNum = i;
                            break OUTER;
                        }
                    }
                }
            }
            if (roomNum == 0) {
                System.out.println("No rooms are available for that date. :(");
            }
        } else if(!smoke && aircond) {
            OUTER: for (int i = 0; i < 10; i++) {
                if (calRooms[a.getDayOfYear()][i] == null) {
                    for (int j = a.getDayOfYear(); j <= length; j++) {
                        if (calRooms[j][i] == null) {
                            count++;
                        }
                        if (count == length) {
                            roomNum = i;
                            break OUTER;
                        }
                    }
                }
            }
            if (roomNum == 0) {
                System.out.println("No rooms are available for that date. :(");
            }
        } else {
            System.out.println("We dont offer that combination of smoking and air conditioning. :)");
        }
        if (roomNum != 0) {
            for (int i = a.getDayOfYear(); i <= length; i++) {
                calRooms[i][roomNum] = fred;
            }
            System.out.println("You have been booked for "+length+" days at the "+hotelName);
        }
    }
    
    
}
 