package backend;
import java.util.Date;
/**
 * Keeps track of the bills being paid
 * 
 * @author Sean Powers & Isaiah Santamaria
 * @version Spring 2026
 * 
 */

public class BillTransaction extends ExpenseTransaction{
 
    /**
     * 
     * @param amount
     * @param reason
     * @param date
     */
    public BillTransaction(double amount, String reason, Date date){
        super(amount, reason, date );
    }

     /**
     * return bill which is object name
     * @return bill which is object name
     */
    @Override
    public String getType(){
        return "Bill";
    }
    /**
     * 
     * @return toString()
     */
    @Override
    public String toString(){
        return super.toString()+  " ExpenseType:Bill";
    }

  

}





