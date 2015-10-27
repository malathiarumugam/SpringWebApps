


package com.mycompany.vendingmachinev2.model;


public class Vend {
    private double money;
    private String code;
    
    public Vend() {
        
    }
    
    public Vend(double money, String code) {
        this.code = code;
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
}
