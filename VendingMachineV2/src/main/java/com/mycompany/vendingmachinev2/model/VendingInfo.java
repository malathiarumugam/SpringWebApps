


package com.mycompany.vendingmachinev2.model;

import java.math.BigDecimal;


public class VendingInfo {
    private BigDecimal money;
    private String code;
    private double leftover;

    public double getLeftover() {
        return leftover;
    }

    public void setLeftover(double leftover) {
        this.leftover = leftover;
    }
    
    public VendingInfo() {
        
    }
    
    public VendingInfo(BigDecimal money, String code, double left) {
        this.code = code;
        this.money = money;
        leftover = left;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
}
