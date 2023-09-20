// Purpose: Class for shopping cart
// Created By: Fahad Ali Khan
// Created On: 2020-10-25

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ItemIf> items;
    private double totalCostofCart;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.totalCostofCart = 0.0;
    }
    //add item to cart
    public boolean addItem(ItemIf item) {
        items.add(item);
        totalCostofCart += item.getCost();
        return true;
    }
    //show items in cart
    public void display() {
        System.out.printf("Shopping cart has the following items:%n");
        for (ItemIf item : items) {
            item.display();
        }
        System.out.printf("The total cost of these items is $%.2f%n%n", totalCostofCart);
    }
    //get cost of cart
    public double getCost() {
        return totalCostofCart;
    }

}
