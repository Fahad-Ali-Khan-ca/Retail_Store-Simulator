// class Customer
// Created By: Fahad Ali Khan
// Created On: 2023-09-19

import java.util.List;

public class Customer {
    private String name;
    private ShoppingCart cart;
    private double Cash;
    //reference to retail store
    private AbstractStoreFactory store;
    //cost for toolbox items and groceries
    private double toolboxCost;
    private double groceryCost;
    private double totalSpend;

    public Customer(String name, AbstractStoreFactory store, double Cash) {
        this.name = name;
        this.cart = new ShoppingCart();
        this.store = store;
        this.Cash = Cash;
        this.toolboxCost = 0.0;
        this.groceryCost = 0.0;
        this.totalSpend = 0.0;
    }

    public  boolean addItem() {
       //call shopping cart add function
       boolean retval =false; 
       retval=cart.addItem();
       return retval;
    };
       
    public void display() {
        System.out.printf("Customer %s has the following items in their cart:", name);
        cart.display();
    }

    //add cash to customer
    public void addCash(double cash) {
        Cash += cash;
        //print statement 
        System.out.printf("Customer %s has added $%.2f to their wallet%n%n", name, cash);
    }

    public double getCost() {
        return (cart.getCost() + getGst());
    }

    //buy items in cart and tax to toolbox
    public boolean buy() {
        //customer displays
        display();
        double totalCost = getCost() ;
        System.out.printf("The total GST on these items is $%.2f%n", getGst());
        System.out.printf("The total cost + GST of these items is $%.2f%n", totalCost);
        //buy items
        // if customer has enough cash buy items
        if (Cash >= totalCost) {
            //update cash
            totalSpend += totalCost;
            Cash -= totalCost;
            toolboxCost=cart.getToolboxCost();
            groceryCost=cart.getGroceryCost();
            System.out.printf("Customer %s has bought the items in their cart%n%n", name);
            //clear cart
            cart = new ShoppingCart();
           return true;
        } else {
            System.out.printf("Customer %s does not have enough cash to buy these items%n%n", name);
            return false;
        }
    }

    //calculate Gst on toolbox
    public double getGst() {
        double cost = 0.0;
        double tax = 0.0;
        for (ItemIf item : cart.getItems()) {
            cost= item.getCost();
            if (item instanceof Toolbox) {
                tax += cost * 0.14;
            } else if (item instanceof GroceryBag) {
                groceryCost += cost;
            }
        }
        return tax;
    }

	public double getToolboxCost() {

		return toolboxCost;
	}

    public double getGroceryCost() {
        return groceryCost;
    }
    //get name of customer
    public String getName() {
        return name;
    }
    //get totalspend 
    public double getTotalSpend() {
        return totalSpend;
    }
  

}
