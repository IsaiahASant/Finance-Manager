package backend;
import java.util.ArrayList;
import 	java.io.PrintWriter;
import java.io.IOException;
/**
 * This class is responsible for taking the list of list of 
 * ExpenseTransaction, & Income Transaction then display it
 * in a Organize CSV file format
 * @author Isaiah and Hayden
 * @version 4/16/2026
 */
public class csvTranslation extends IncomeTransaction implements ExpenseTransaction{
    ArrayList<ExpenseTransaction> expense;
    ArrayList<IncomeTransaction> income;

    public csvTranslation(ArrayList<ExpenseTransaction> expenses, ArrayList<IncomeTransaction> incomes){
        this.expense = expenses;
        this.income = incomes;
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter("Output.csv");

        fw.println("Expenses  |  Income");

        for(int i = 0; i < expense.size(); i++) {
            pw.println("---------|---------");
            pw.println(expense.get(i) + ("  |  ") + income.get(i));
        }
    }
    
}
