/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachinev2.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "Item cost must have a numeric value.")
    @Max(value = 99, message = "Item cost must be no more than $99.")
    private BigDecimal cost;

    @Min(value = 1, message = "Item count must have a value.")
    @Max(value = 99, message = "Item inventory cannot be greater than 99.")
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

    public Item(String nameIn, BigDecimal costIn, int countIn, String codeIn) {
        name = nameIn;
        cost = costIn;
        count = countIn;
        code = codeIn;
    }

    public String toString() {
        return "Item: " + name + " - Price: $" + df.format(cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String nameIn) {
        this.name = nameIn;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal costIn) {
        cost = costIn;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCountOne() {
        this.count -= 1;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.cost);
        hash = 37 * hash + Objects.hashCode(this.code);
        hash = 37 * hash + Objects.hashCode(this.count);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.cost, other.cost)) {
            return false;
        }
        if (!Objects.equals(this.count, other.count)) {
            return false;
        }
        return true;
    }

}
