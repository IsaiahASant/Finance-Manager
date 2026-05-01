package backend;

import java.util.Date;

public class GroceryTransaction extends ExpenseTransaction {

    private String groceryList;

    public GroceryTransaction(double amount, String reason, Date date, String grocery) {
        super(amount, reason, date);
        this.groceryList = grocery;
    }


    public String getGroceryList(){
        return groceryList;
    }

    @Override
    public String getType(){
        return "Grocery";
    }



    @Override
    public String toString(){
        return super.toString() + " ExpenseType:Grocery";
    }

    public void addItem(String item) {
        groceryList = groceryList + " " + item;
    }
}