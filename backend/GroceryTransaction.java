package backend;
import java.util.ArrayList;
import java.util.Date;
/**
 * Keeps track of the bills being paid
 * 
 * @author Sean Powers & Isaiah Santamaria
 * @version Spring 2026
 * 
 */

public class GroceryTransaction extends ExpenseTransaction implements Transaction {
    private String ID;
    private String reason;
    private double amount;
    private String date;
    ArrayList<String> GroceryList;
    




    public GroceryTransaction(double amount, String reason,Date date){
        super(amount, reason);
        GroceryList = new ArrayList<>();
        this.ID = TransactionID.generateId();

    }


    /**
     * @return date
     */
    public String getDate(){
        return "date";
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
     */
    @Override
    public String getTransactionId(){
        return ID;
    }

}

