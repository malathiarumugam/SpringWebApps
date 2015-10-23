/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachinev2.model;

import java.text.DecimalFormat;

/**
 *
 * @author apprentice
 */
public class Item {
    private String name;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    private double cost;
    private int count;
    
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
