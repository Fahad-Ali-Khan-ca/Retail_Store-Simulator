// Concrete Factory for RetailStore
// Created By: Fahad Ali Khan
// Created On: 2023-09-19

import java.util.ArrayList;
import java.util.List;

public class RetailStoreFactory extends AbstractStoreFactory {
    private String Storename;
    private List<Customer> customers;
    private double avgSpend;
    private double totalSpend;
    private int  totalCustomers;
    
    public RetailStoreFactory(String storeName) {
        this.Storename = storeName;
        this.customers = new ArrayList<>();
    }

    @Override
    public void display() {
        System.out.println("Retail Store: " + Storename);
        System.out.println("Customers:");
        for (Customer customer : customers) {
            customer.display();
        }
    }

    @Override
    public double calculateTotal() {
        double totalRevenue = 0.0;
        for (Customer customer : customers) {
            totalRevenue += customer.getCost();
        }
        return totalRevenue;
    }

    @Override
    public double calculateAverage() {
        if (customers.isEmpty()) {
            return 0.0; // Avoid division by zero
        }

        double totalRevenue = calculateTotal();
        return totalRevenue / customers.size();
    }

    @Override
    public double calculatePercentage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculatePercentage'");
    }

}
