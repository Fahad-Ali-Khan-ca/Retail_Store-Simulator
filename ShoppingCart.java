import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {

    // Shopping cart contains tools and groceries
    private List<ToolIf> tools;
    private List<GroceryIf> groceries;
    private double totalCost;
    private int numItems;

    public ShoppingCart() {
        this.tools = new ArrayList<>();
        this.groceries = new ArrayList<>();
        this.totalCost = 0.0;
        this.numItems = 0;
    }

    public boolean addTool(ToolIf tool) {
        if (numItems < 4) {
            tools.add(tool);
            numItems++;
            totalCost += tool.getCost();
            return true;
        }
        return false;
    }

    public boolean addGrocery(GroceryIf grocery) {
        if (numItems < 4) {
            groceries.add(grocery);
            numItems++;
            totalCost += grocery.getCost();
            return true;
        }
        return false;
    }

    public void display() {
        System.out.println();
        System.out.println("Shopping cart contains the following items:");
        for (ToolIf item : tools) {
            item.display();
        }
        for (GroceryIf item : groceries) {
            item.display();
        }
        System.out.printf("The total cost of these items is $%.2f%n%n", totalCost);
    }

     


    

}
