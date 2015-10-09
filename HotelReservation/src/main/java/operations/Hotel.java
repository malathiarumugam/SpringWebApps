package operations;


import operations.Guest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public interface Hotel {
    
    public void fillRooms();
    public void bookReservation(double length, Guest fred, boolean smoke, boolean aircond, String dateIn);
    public String checkOut(String dateIn, double length, String name);
    public void cancelReservation(String dateIn, double length,String name);
    
}
