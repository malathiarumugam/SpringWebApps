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
public class Room {
    private boolean smoking;
    private boolean aircon;
    private double cost;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public Room(boolean smoke, boolean air) {
        this.aircon = air;
        this.smoking = smoke;
    }
}
