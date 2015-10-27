/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachinev2.model;

import java.text.DecimalFormat;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class Item {
    
    @NotEmpty(message = "You must supply a value for item name.")
    @Length(max = 50, message = "Name must be no more than 50 characters in length.")
    private String name;
    
    @NotEmpty(message = "You must supply a value for item code.")
    @Length(max = 2, message = "Item code must be no more than 2 characters in length.")
    private String code;
    
    @NotEmpty(message = "You must supply a value for item cost.")
    @Length(max = 4, message = "Item cost must be no more than $99.")
    private double cost;
    
    @NotEmpty(message = "You must supply a value for item inventory.")
    @Length(max = 2, message = "Item inventory cannot be greater than 99.")
    private int count;
    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    DecimalFormat df = new DecimalFormat("#0.00");
    
    public Item() {
        
    }
    
    public Item(String nameIn, double costIn, int countIn, String codeIn) {
        name = nameIn;
        cost = costIn;
        count = countIn;
        code = codeIn;
    }
    
    public String toString(){
        return "Item: " + name + " - Price: $" + df.format(cost) ;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String nameIn) {
        this.name = nameIn;
    }

    public double getCost() {
        return cost;
    }
    
    public void setCost(double costIn) {
        cost = costIn;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count -= 1;
    }
    
    
}
