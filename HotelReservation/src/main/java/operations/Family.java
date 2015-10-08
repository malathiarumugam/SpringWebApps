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
public class Family extends NewGuest{
    
    public Family (String name, String phone, double lengthStay){
        super (name,phone,lengthStay);
    }

    @Override
    public String complain() {
        return "Complaint Submitted";
    }
        

    @Override
    public double steal(String list) {
        String[] split = list.split(",");
        double cost = split.length;
        return cost;
    }
    
}
