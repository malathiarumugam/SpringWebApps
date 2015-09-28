/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public interface Customizable {

    public String addOrder(Customer customer, Florable flooring);

    public void removeOrder(String orderNum, HashMap<String, Florable> orderList);

    @Override
    public String toString();

    public String displayOrder(Customer customer, HashMap<String, Florable> list, String orderNum);

    public String displayOrder(String orderNum, ArrayList<Customer> orderBook);

    public HashMap<String, Florable> getOrderList();

    public void setOrderList(HashMap<String, Florable> orderList);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public String getState();

    public void setState(String state);

    public double getTaxRate();

    public void setTaxRate(double taxRate);
}
