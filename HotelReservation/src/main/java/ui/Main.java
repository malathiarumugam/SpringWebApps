package ui;


import operations.Guest;
import operations.Hotel;
import operations.Room;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Main {
    public static void main(String[] args) {
        Guest [][] calRooms = new Guest [365][20];
        Room[] roomInfo = new Room[20];
        Hotel hotel = new Hotel(calRooms, roomInfo);
        hotel.fillRooms();
        
        

        
        
        System.out.println("Please enter the date of your stay. (YYYY,MM,DD)");
    }
}
