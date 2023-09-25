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
    //store percentage of total revenue in tools and groceries
    private double percentageToolbox;
    private double percentageGrocery;

    
    public RetailStoreFactory(String storeName) {
        this.Storename = storeName;
        this.customers = new ArrayList<>();
        avgSpend = 0.0;
        totalSpend = 0.0;
        percentageToolbox = 0.0;
        percentageGrocery = 0.0;
    }

    @Override
    public void display() {
        System.out.printf("Store %s has %d customers:%n", Storename, customers.size());
        System.out.printf("The average spend of customers at store %s is $%.2f%n", Storename, calculateAverage());
        System.out.printf("The total spend of customers at store %s is $%.2f%n", Storename, calculateTotal());
        System.out.printf("The total number of customers at store %s is %d%n", Storename, customers.size());
    }

    @Override
    public double calculateTotal() {
        double totalRevenue = 0.0;
        for (Customer customer : customers) {
            totalRevenue += customer.getTotalSpend();
        }
        totalSpend = totalRevenue;
        return totalRevenue;
    }

    @Override
    public double calculateAverage() {
        if (customers.isEmpty()) {
            return 0.0; // Avoid division by zero
        }
        avgSpend = calculateTotal() / customers.size();
        return avgSpend;
    }

    @Override
    public void calculatePercentage() {
        //calculate percentage of total revenue in tools and groceries
        double totalToolboxRevenue = 0.0;
        double totalGroceryRevenue = 0.0;
        for (Customer customer : customers) {
            totalToolboxRevenue += customer.getToolboxCost();
            totalGroceryRevenue += customer.getGroceryCost();
        }
        double percentageToolbox = totalToolboxRevenue / calculateTotal() * 100;
        double percentageGrocery = totalGroceryRevenue / calculateTotal() * 100;
       //store percentage of total revenue in tools and groceries
        this.percentageGrocery = percentageGrocery;
        this.percentageToolbox = percentageToolbox;
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    //getters
    public List<Customer> getCustomers() {
        return customers;
    }

    //get percentage of revenue from toolbox
    public double getPercentageToolbox() {
        return percentageToolbox;
    }
    //get percentage of revenue from groceries
    public double getPercentageGrocery() {
        return percentageGrocery;
    }
    
}
