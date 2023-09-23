// class Customer
// Created By: Fahad Ali Khan
// Created On: 2020-10-25
public class Customer {
    private String name;
    private ShoppingCart cart;
    private double Cash;
    //referemce to retail store
    private RetailStoreFactory store;


    public Customer(String name, RetailStoreFactory store, double Cash) {
        this.name = name;
        this.cart = new ShoppingCart();
        this.store = store;
        this.Cash = Cash;
    }

    public boolean addItem(ItemIf item) {
        return cart.addItem(item);
    }

    public void display() {
        System.out.printf("Customer %s has the following items in their cart:%n", name);
        cart.display();
    }

    public double getCost() {
        return cart.getCost();
    }

    //buy items in cart
    public void buy() {
        System.out.printf("Customer %s is buying the following items:%n", name);
        cart.display();
        double totalCost = cart.getCost();
        //get total cost of items
        System.out.printf("The total cost of these items is $%.2f%n%n", getCost());
        //buy items
        // if customer has enough cash buy items
        if (Cash >= totalCost) {            
            //update cash
            Cash -= totalCost;
            //clear cart
            cart = new ShoppingCart();
        } else {
            System.out.printf("Customer %s does not have enough cash to buy these items%n%n", name);
        }
    }
}
