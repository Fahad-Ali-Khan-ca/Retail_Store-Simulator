public class RetailStoreTest {

//    Test Program
// This could be changed be built like a kiosk where the user can select which store they want to go to 
// and then the program will run for that store and display the results
    public static void main(String[] args) {
        // Create a new retail store  // can ask customer which store they want to go to
        AbstractStoreFactory store = new RetailStoreFactory("Walmart");


        // Simulating for three customer for now
        // Create three customers
        Customer customer1 = new Customer("Alice", store,100.0);
        Customer customer2 = new Customer("Bob",store, 50.0);
        Customer customer3 = new Customer("Charlie", store,200.0);

        // Add the customers to the retail store
        store.addCustomer(customer1);
        store.addCustomer(customer2);
        store.addCustomer(customer3);
        //Have each user  add items to their cart SIMULATING INPUT FOR TESTING
        for (Customer customer : store.getCustomers()) {
            String name = customer.getName();
            // customer wants to add items to their cart and buy them
            System.out.printf("Customer %s wants to adds items to their cart and buys them%n%n", name);
            boolean retval=customer.addItem();
            System.out.printf("%n%n");
            if(retval==true)
            {   
                retval=customer.buy();
        
                
            } else {
                System.out.printf("System Error: Unable to add items to cart%n%n");
            }
        
            //store displays the 
        }
        //add cash to customer
        customer1.addCash(100.0);
        customer2.addCash(50.0);
        customer3.addCash(200.0);


        // Calculate and display statistics for the retail store
        store.calculatePercentage();
        System.out.printf("Total revenue: $%.2f%n",((RetailStoreFactory)store).calculateTotal());
        System.out.printf("Average customer spend: $%.2f%n",((RetailStoreFactory)store).calculateAverage());
        System.out.printf("Percentage of revenue from tools: %.2f%%%n", ((RetailStoreFactory)store).getPercentageToolbox());
        System.out.printf("Percentage of revenue from groceries: %.2f%%%n",((RetailStoreFactory)store).getPercentageGrocery());
    }
}


