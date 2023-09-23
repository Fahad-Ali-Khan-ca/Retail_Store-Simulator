// Concrete Factory for RetailStore
// Created By: Fahad Ali Khan
// Created On: 2023-09-19

import java.util.List;

public class RetailStoreFactory extends AbstractStoreFactory {
    private String Storename;
    private List<Customer> customers;
    private double avgSpend;
    private double totalSpend;
    private int  totalCustomers;

    @Override
    public void display() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    @Override
    public double calculateTotal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateTotal'");
    }

    @Override
    public double calculateAverage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateAverage'");
    }

}
