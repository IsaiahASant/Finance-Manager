package backend;
import java.util.ArrayList;
/**
 * 
 * This transaction class tracks list of items that have been bought(can include food item)
 * @author Sean Powers & Isaiah Santamaria
 * @version Spring 2026
 * 
 */

public class ShoppingTransaction extends ExpenseTransaction implements Transaction{
    private ArrayList<String> items;
    private String ID;
    private String reason;
    private double amount;

    //* unique list speficialy for this object */
    private String shoppingList; 

    public ShoppingTransaction(double amount, String reason, String items){
      super(amount, reason);
      this.shoppingList = items;
      this.ID = TransactionID.generateId();

    }

    /**
     * @return reason
     */
    @Override
    public String getReason(){
      return reason;
    }

    /**
     * @return amount
     */
    @Override
    public double getAmount(){
        return amount;
    }

    /**
     * 
     */
    @Override
    public String toString(){
        return super.toString();
    }

    /**
     * 
     * @return shopping type of obect
     */
    public String getType(){
        return "Shopping";
    }

    
    /**
     * 
     */
    @Override
    public String getTransactionId(){
        return ID;
    }

    

}