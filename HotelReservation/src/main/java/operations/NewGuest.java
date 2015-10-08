/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

/**
 *
 * @author apprentice
 */
public abstract class NewGuest implements Guest {

    private String name;
    private String phone;
    private double lengthStay;

    public NewGuest(String name, String phone, double lengthStay) {
        this.name = name;
        this.phone = phone;
        this.lengthStay = lengthStay;
    }

}
