


package UI;

import DTO.OrderBook;
import Operation.Customer;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> orderBook = new ArrayList();
        OrderBook book = new OrderBook(orderBook);
        //book.run();
        book.testRun();
    }
}
