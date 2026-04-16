import java.util.ArrayList;
/**
 * Keeps track of the bills being paid
 * 
 * @author Sean Powers & Isaiah Santamaria
 * @version Spring 2026
 * 
 */

public class BillTransaction implements ExpenseTransaction{
    private String source;
    private String transactionId;
    private String reason;
    private int amount;

    //* unique list speficialy for this object */
    private ArrayList<String> list; 

    public BillTransaction(int amount, String reason){
        this.reason = reason;
        this.amount = amount;

        list = new ArrayList<String>();

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
    public int getAmount(){
        return amount;
    }

    @Override
    public String getTransactionId(){
        return transactionId;
    }


    /**
     * 
     */
    @Override
    public String toString(){
        return "";
    }

    /**
     * adds food list into list
     * @param food
     */
    public void addList(String food){
        if(........){ //validates if string is a food <<<<<< Maybe we can use an API to validate if a string is a food>>>>>>>>>>>
            list.add(food);
        }else{
            System.out.println("This is not a food");
        }

    }





}