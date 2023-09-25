// Purpose: Class for shopping cart
// Created By: Fahad Ali Khan
// Created On: 2020-09-19

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    private List<ItemIf> items;
    private double totalCostofCart;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.totalCostofCart = 0.0;
    }

    //add item to cart
    public boolean addItem() {
        ItemIf item = null;
        int select;
        Scanner scanner = new Scanner(System.in);
            // Display options to the user
            System.out.println("What would you like to add to your cart?");
            System.out.println("1. Toolbox");
            System.out.println("2. Grocery Bag");
            System.out.print("Selection: ");
        
            select = scanner.nextInt(); // Read user's selection
            scanner.nextLine(); // Consume the newline character
           
            //wanted to call the main funcitons of the classes (Toolbox and GroceryBag) but I would have to make them non static.
            switch (select) {
                case 1: // User selected Toolbox
                    item = new Toolbox("Data Processing Support");
                    for (int i = 0; i < 2; i++) { // Assuming you want to add 2 tools to the toolbox
                        ToolIf tool = Toolbox.createTool(scanner); // Call the createTool method to create a tool
                        ((Toolbox) item).addTool(tool); // Add the created tool to the toolbox
                        
                    }
                    break;
                case 2: // User selected Grocery Bag
                    item = new GroceryBag("Reusable Grocery Bag");
                    for (int i = 0; i < 2; i++) { // Assuming you want to add 2 groceries to the grocery bag
                        GroceryIf grocery = GroceryBagMain.createGrocery(scanner); // Call the createGrocery method to create a grocery
                        ((GroceryBag) item).addGrocery(grocery); // Add the created grocery to the grocery bag
                    }
                    break;
                default:
                    System.out.println("Invalid selection!");
                    return false; // Return false as the selection was invalid
            }
            totalCostofCart += item.getCost(); // Update the total cost of the cart
            items.add(item); // Add the created item to the items list
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

    //to know if an item is a toolbox or not
    public boolean isToolbox(ItemIf item) {
        return item instanceof Toolbox;
    }

    // getitems
    public List<ItemIf> getItems() {
        return items;
    }
}
