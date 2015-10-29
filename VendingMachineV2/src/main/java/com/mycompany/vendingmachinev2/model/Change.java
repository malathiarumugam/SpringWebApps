


package com.mycompany.vendingmachinev2.model;

import java.math.BigDecimal;


public class Change {

    private BigDecimal total;
    
    public Change() {
        
    }
    
    public Change(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    
}
