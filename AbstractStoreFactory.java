// Abstract that should help us extend when adding new stores
// to the system.
// ----------------------------------------------------------------
// Created By: Fahad Ali Khan
// Created On: 2023-09-19

import java.util.List;

public abstract class AbstractStoreFactory {
    // display 
    public abstract void display();
    // calculate total
    public abstract double calculateTotal();
    // calculate average amount a customer spends
    public abstract double calculateAverage();
    //calculate percentage 
    public abstract void calculatePercentage();
    public abstract void addCustomer(Customer customer1);
    public abstract List<Customer> getCustomers();
}