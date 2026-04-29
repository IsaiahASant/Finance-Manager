package backend;
import java.util.ArrayList;
/**
 * Keeps track of the bills being paid
 * 
 * @author Sean Powers & Isaiah Santamaria
 * @version Spring 2026
 * 
 */

public class GroceryTransaction implements ExpenseTransaction{
    private String ID;
    private String reason;
    private double amount;
    ArrayList<String> GroceryList;




    public GroceryTransaction(double amount, String reason){
        this.reason = reason;
        this.amount = amount;
        GroceryList = new ArrayList<>();
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
        return "Paid the " + reason + "bill totaling " + amount + " dollars." ;
    }

    /**
     * 
     */
    @Override
    public String getTransactionId(){
        return ID;
    }

    /**
     * adds food list into list
     * @param food
     */
    public void addList(String food){
        if(true){ //validates if string is a food <<<<<< Maybe we can use an API to validate if a string is a food>>>>>>>>>>>

            
            System.out.println("IDK");
        }else{
            System.out.println("This is not a food");
        }

    }





}