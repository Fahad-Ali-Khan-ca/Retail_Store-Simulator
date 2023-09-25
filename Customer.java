// class Customer
// Created By: Fahad Ali Khan
// Created On: 2023-09-19


public class Customer {
    private String name;
    private ShoppingCart cart;
    private double Cash;
    //reference to retail store
    private AbstractStoreFactory store;
    //cost for toolbox items and groceries
    private double toolboxCost;
    private double groceryCost;

    public Customer(String name, AbstractStoreFactory store, double Cash) {
        this.name = name;
        this.cart = new ShoppingCart();
        this.store = store;
        this.Cash = Cash;
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

    public double getCost() {
        return (cart.getCost() + getGst());
    }

    //buy items in cart and tax to toolbox
    public boolean buy() {
        System.out.printf("Customer %s is buying the following items in the shopping cart", name);
        double totalCost = cart.getCost() ;
        //get total cost of items
        System.out.printf("The total cost of these items is $%.2f%n%n", getCost());
        //buy items
        // if customer has enough cash buy items
        if (Cash >= totalCost) {
            //update cash
            Cash -= totalCost;
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
                toolboxCost += cost;
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
}
