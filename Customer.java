// class Customer
// Created By: Fahad Ali Khan
// Created On: 2020-10-25
public class Customer {
    private String name;
    private ShoppingCart cart;
    private double Cash;
    private RetailStoreFactory factory;

    public Customer(String name) {
        this.name = name;
        this.cart = new ShoppingCart();
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

}
