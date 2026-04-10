import java.util.Scanner;
/**
 * Keeps track of the bills being paid
 * 
 * @author Sean Powers
 * @version Spring 2026
 * 
 */

public class Shopping extends ExpenseTransaction{
    Scanner scanner = new Scanner(System.in);
    @Override
    public String askReason(){
        System.out.println("Why did you make this purchase?");
        return scanner.next();
    }
}