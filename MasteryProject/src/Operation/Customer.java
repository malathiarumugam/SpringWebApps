


package Operation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;


public class Customer {
    
        private HashMap<String, Flooring> orderList;
        private String firstName;
        private String lastName;
        private String state;
        private double taxRate;
        
    public Customer(HashMap<String, Flooring> list) {
        orderList = list;
    }
        
    public Customer(String first, String last, String stat, double tax, HashMap<String, Flooring> list) {
        firstName = first;
        lastName = last;
        state = stat;
        taxRate = tax;
        orderList = list;
    }
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar cal = Calendar.getInstance();
        // System.out.println(dateFormat2.format(cal.getTime()));
        //System.out.println(dateFormat.format(cal.getTime())); //2014/08/06 16:00:22
       
        
    public Flooring findOrdersByDate(String date) {
        Set<String> keys = orderList.keySet();
        for (String k : keys) {
            if (k.substring(0, 8) == date) {
                return orderList.get(k);
            }
        }
        System.out.println("Error: orders not found for specified date.");
        return null;
    }
    
    public Flooring findOrder(String orderNum) {
        Set<String> keys = orderList.keySet();
        for (String k : keys) {
            if (k == orderNum) {
                return orderList.get(k);
            }
        }
        System.out.println("Error: orders not found for specified date.");
        return null;
    }
    
    public String addOrder(Customer customer, Flooring flooring) {
        String orderNumber = dateFormat2.format(cal.getTime());
        customer.orderList.put(orderNumber, flooring);
        return orderNumber;
    }
    
    public void removeOrder(String orderNum) {
        Set<String> keys = orderList.keySet();
        for (String k : keys) {
            if (k == orderNum) {
                orderList.remove(k);
            }
        }
    }
    
    public String toString() {
        String out = "";
        Set<String> keys = orderList.keySet();
        for (String k : keys) {
            out = firstName + " " + lastName + " Order Number: " + k + " Date: " + k.substring(0, 4)+"/"+k.substring(4,6)+"/"+k.substring(6, 8) + 
                    "\n   Flooring: "+orderList.get(k).getProductType() + "  area: "+ orderList.get(k).getArea() + "  total cost: " + orderList.get(k).getTotal(taxRate)+"\n";
        }
        return out;
    }
    
    public String displayOrder(Customer customer, HashMap<String, Flooring> list, String orderNum) {
        String out = "";
        Set<String> keys = list.keySet();
        for (String k : keys) {
            if (k == orderNum) {
            out = customer.getFirstName() + " " + customer.getLastName() + " Order Number: " + k + " Date: " + k.substring(0, 4)+"/"+k.substring(4,6)+"/"+k.substring(6, 8) + 
                    "\n   Flooring: "+list.get(k).getProductType() + "  area: "+ list.get(k).getArea() + "  total cost: " + list.get(k).getTotal(customer.getTaxRate())+"\n";
            return out;
            }
        }
        return out;
    }
    
    public String iterate() {
        String out = "";
        Set<String> keys = orderList.keySet();
        for (String k : keys) {
            out = k+"::"+firstName+"::"+lastName+"::"+state+"::"+orderList.get(k).getArea()+"::"+orderList.get(k).getProductType();
        }
        return out;
    }

    public HashMap<String, Flooring> getOrderList() {
        return orderList;
    }

    public void setOrderList(HashMap<String, Flooring> orderList) {
        this.orderList = orderList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
        
        
        
    
    
}
