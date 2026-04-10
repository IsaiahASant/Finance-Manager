import java.util.Scanner;
/**
 * Keeps track of the bills being paid
 * 
 * @author Sean Powers
 * @version Spring 2026
 * 
 */

public class GroceryTransaction extends ExpenseTransaction{
    Scanner scanner = new Scanner(System.in);
    @Override
    public String askReason(){
        return scanner.next();
    }
}