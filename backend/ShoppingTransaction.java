package backend;
import java.util.ArrayList;
import java.util.Date;
/**
 * 
 * This transaction class tracks list of items that have been bought(can include food item)
 * @author Sean Powers & Isaiah Santamaria
 * @version Spring 2026
 * 
 */

public class ShoppingTransaction extends ExpenseTransaction {
    private ArrayList<String> items;

    private String reason;
    private double amount;

    //* unique list speficialy for this object */
    private String shoppingList; 

    public ShoppingTransaction(double amount, String reason, Date date, String items){
      super(amount, reason,date);
      this.shoppingList = items;
    }


    /**
     * 
     */
    @Override
    public String toString(){
        return super.toString() + " ExpenseType:Shopping";
    }


    /**
     * 
     * @return shopping type of obect
     */
    public String getType(){
        return "Shopping";
    }

}