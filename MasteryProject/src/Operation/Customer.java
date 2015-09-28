


package Operation;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;


public class Customer implements Customizable {
    
        private HashMap<String, Florable> orderList;
        private String firstName;
        private String lastName;
        private String state;
        private double taxRate;
        
    public Customer() {
        
    }
        
    public Customer(HashMap<String, Florable> list) {
        orderList = list;
    }
        
    public Customer(String first, String last, String stat, double tax, HashMap<String, Florable> list) {
        firstName = first;
        lastName = last;
        state = stat;
        taxRate = tax;
        orderList = list;
    }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar cal = Calendar.getInstance();
        
     public String addOrder(Customer customer, Florable flooring) {
        String orderNumber = dateFormat2.format(cal.getTime());
        customer.orderList.put(orderNumber, flooring);
        return orderNumber;
    }
    
    public void removeOrder(String orderNum, HashMap<String, Florable> orderList) {
        Set<String> keys = orderList.keySet();
        for (String k : keys) {
            if (k.equals(orderNum)) {
                orderList.remove(k);
            }
        }
    }
    DecimalFormat df = new DecimalFormat("#0.00");
    
    @Override
    public String toString() {
        String out = "";
        Set<String> keys = orderList.keySet();
        for (String k : keys) {
            out = firstName + " " + lastName + "  Order Number: " + k + "  Date: " + k.substring(0, 4)+"/"+k.substring(4,6)+"/"+k.substring(6, 8) + 
                    "\n   Flooring: "+orderList.get(k).getProductType() + "   Area: "+ orderList.get(k).getArea() + "   Total Cost: $" + df.format(orderList.get(k).getTotal(taxRate))+"\n";
        }
        return out;
    }
    
    public String displayOrder(Customer customer, HashMap<String, Florable> list, String orderNum) {
        String out = "";
        Set<String> keys = list.keySet();
        for (String k : keys) {
            if (k.equals(orderNum)) {
            out = customer.getFirstName() + " " + customer.getLastName() + "  Order Number: " + k + "  Date: " + k.substring(0, 4)+"/"+k.substring(4,6)+"/"+k.substring(6, 8) + 
                    "\n   Flooring: "+list.get(k).getProductType() + "   Area: "+ list.get(k).getArea() + "   Total Cost: $" + df.format(list.get(k).getTotal(customer.getTaxRate()))+"\n";
            return out;
            }
        }
        return out;
    }
    
    public String displayOrder(String orderNum, ArrayList<Customer> orderBook) {
        Customer cust = new Customer();
        String out = "";
        for (Customer c : orderBook) {
            Set<String> keys = c.getOrderList().keySet();
            for (String k : keys) {
                if (k.equals(orderNum)) {
                    cust = c;
                }
            }
        }
        Set<String> keys = cust.getOrderList().keySet();
        for (String k : keys) {
            if (k.equals(orderNum)) {
            out = cust.getFirstName() + " " + cust.getLastName() + "  Order Number: " + k + "  Date: " + k.substring(0, 4)+"/"+k.substring(4,6)+"/"+k.substring(6, 8) + 
                    "\n   Flooring: "+cust.getOrderList().get(k).getProductType() + "   Area: "+ cust.getOrderList().get(k).getArea() + "   Total Cost: $" + df.format(cust.getOrderList().get(k).getTotal(cust.getTaxRate()))+"\n";
            return out;
            }
        }
        return out;
    }
    
       

    public HashMap<String, Florable> getOrderList() {
        return orderList;
    }

    public void setOrderList(HashMap<String, Florable
              > orderList) {
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
