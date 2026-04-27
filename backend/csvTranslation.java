package backend;
import java.util.ArrayList;
import 	java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * This class is responsible for taking the list of list of 
 * ExpenseTransaction, & Income Transaction then display it
 * in a Organize CSV file format
 * @author Isaiah and Hayden
 * @version 4/16/2026
 */
public class csvTranslation{
    ArrayList<ExpenseTransaction> expense;
    ArrayList<IncomeTransaction> income;

    //This
    public csvTranslation(ArrayList<ExpenseTransaction> expenses, ArrayList<IncomeTransaction> incomes){
        this.expense = expenses;
        this.income = incomes;
    }

    public static void main(String[] args) {

        csvTranslation translator = new csvTranslation(expenses, incomes);

        try (PrintWriter pw = new PrintWriter("Output.csv")) {

        fw.println("Expenses,Income");

        int size = math.min(translator.expense.size(), translator.incomes.size());
        for(int i = 0; i < size; i++) {
            pw.println(translator.expenses.get(i) + (", ") + translator.incomes.get(i));
        }
        } catch (FileNotFoundException e){
            System.err.println("Error creating file " + e.getMessage());
        }
    }
    
}
