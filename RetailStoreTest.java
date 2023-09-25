public class RetailStoreTest {

//    Test Program
    public static void main(String[] args) {
        // Create a new retail store  // can ask customer which store they want to go to
        AbstractStoreFactory store = new RetailStoreFactory("Walmart");

        // Create three customers
        Customer customer1 = new Customer("Alice", store,100.0);
        Customer customer2 = new Customer("Bob",store, 50.0);
        Customer customer3 = new Customer("Charlie", store,200.0);

        // Add the customers to the retail store
        store.addCustomer(customer1);
        store.addCustomer(customer2);
        store.addCustomer(customer3);
        //Have each user  add items to their cart untill they want to stop
        for (Customer customer : store.getCustomers()) {
            String name = customer.getName();
            System.out.printf("Customer %s is adding items to their cart:%n", name);
            boolean retval=customer.addItem();
            if(retval==true)
            {
                System.out.printf("Customer %s has added the following items to their cart:%n", name);
                customer.display();
            }
            else
            {
                System.out.printf("Customer %s has not added the following items to their cart because of lack of cash", name);
            }
        }
        
        // Have each customer buy items and display their order
        for (Customer customer : store.getCustomers()) {
            String name = customer.getName();
            System.out.printf("Customer %s is buying the following items:%n", name);
            boolean retval=customer.buy();
            if(retval==true)
            {
                System.out.printf("Customer %s has bought the following items:%n", name);
                customer.display();
            }
            else
            {
                System.out.printf("Customer %s has not bought the following items because of lack of cash", name);
            }
        }

        // Calculate and display statistics for the retail store
        store.calculatePercentage();

        System.out.printf("Average customer spend: $%.2f%n",((RetailStoreFactory)store).calculateAverage());
        System.out.printf("Percentage of revenue from tools: %.2f%%%n", ((RetailStoreFactory)store).getPercentageToolbox());
        System.out.printf("Percentage of revenue from groceries: %.2f%%%n",((RetailStoreFactory)store).getPercentageGrocery());
    }
}

