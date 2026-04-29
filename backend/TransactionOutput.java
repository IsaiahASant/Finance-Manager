package backend;
import java.util.ArrayList;
import 	java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * This class is responsible for taking the list of 
 * ExpenseTransaction, IncomeTransaction, GroceryTransaction,
 * BillTransaction, & ShoppingTransaction then display it
 * in an organized CSV file format
 * @author Hayden
 * @version 4/16/2026
 */
public class TransactionOutput {
    ArrayList<ExpenseTransaction> expense;
    ArrayList<IncomeTransaction> income;
    ArrayList<GroceryTransaction> grocery;
    ArrayList<BillTransaction> bills;
    ArrayList<ShoppingTransaction> shopping;

    /**This initializes the instance variables
     * 
     * @param expenses takes the expense input and initializes it 
     * @param incomes takes the income input and initializes it 
     * @param grocery takes the grocery input and initializes it 
     * @param bills takes the bill input and initializes it 
     * @param shopping takes the shopping input and initializes it 
    */
    public TransactionOuput(ArrayList<ExpenseTransaction> expenses, ArrayList<IncomeTransaction> incomes,
         ArrayList<GroceryTransaction> grocery, ArrayList<BillTransaction> bills, ArrayList<ShoppingTransaction> shopping){
        this.expense = expenses;
        this.income = incomes;
        this.grocery = grocery;
        this.bills = bills;
        this.shopping = shopping;
    }
    /**
     * prints the five ArrayLists into a csv file 
     * 
     * @param args
    */
    public static void main(String[] args) {

        csvTranslation translator = new csvTranslation(expenses, incomes, grocery, bills, shopping);

        try (FileWriter fw = new FileWriter("EveryTransaction.csv")) {

        fw.println("Expenses, Income, Shopping, Grocery, Bills, Shopping");

        int size = math.min(translator.expense.size(), translator.incomes.size());
        for(int i = 0; i < size; i++) {
            fw.println(translator.expenses.get(i) + (", ") + translator.incomes.get(i) + (", ") + translator.grocery.get(i)
             + (", ") + translator.bills.get(i) + (", ") + translator.shopping.get(i));
        }
        } catch (FileNotFoundException e){
            System.err.println("Error creating file " + e.getMessage());
        }
    }
    
}