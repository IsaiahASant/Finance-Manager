import java.util.ArrayList;
/**
 * 
 * This transaction class tracks list of items that have been bought(can include food item)
 * @author Sean Powers & Isaiah Santamaria
 * @version Spring 2026
 * 
 */

public class ShoppingTransaction implements ExpenseTransaction{
    private ArrayList<String> items;
    private String ID;
    private String reason;
    private int amount;

    //* unique list speficialy for this object */
    private ArrayList<String> list; 

    public ShoppingTransaction(int amount, String reason){
      

    }

    /**
     * @return reason
     */
    @Override
    public String getReason(){
      
    }

    /**
     * @return amount
     */
    @Override
    public int getAmount(){
        
    }


    /**
     * 
     */
    @Override
    public String toString(){
        return "";
    }

    /**
     * 
     */
    @Override
    public String getTransactionId(){
        return "";
    }

    /**
     * adds food list into list
     * @param food
     */
    

    
    /**
     * 
     * @param list
     */
    public void addItems(ArrayList<String> list){

    }





}