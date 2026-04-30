package backend;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class TransactionHistory {
    //instance variables for incomes and expenses
    private ArrayList<IncomeTransaction> income;
    private ArrayList<ExpenseTransaction> expenses;

    public TransactionHistory(){
        this.income = new ArrayList<IncomeTransaction>();
        this.expenses = new ArrayList<>();
    }

    public String getIncomeTransactions(){
        return income.toString();
    }

    public String getExpenseTransactions(){
        return expenses.toString();
    }

    public void addIncome(IncomeTransaction newIncome){
        income.add(newIncome);
    }
    
    public void addExpense(Object newExpense){
        if(newExpense instanceof BillTransaction){
            expenses.add((BillTransaction)newExpense);

        }else if(newExpense instanceof GroceryTransaction){
            expenses.add((GroceryTransaction)newExpense);

        }else if(newExpense instanceof ShoppingTransaction){
            expenses.add((ShoppingTransaction)newExpense);


        }else{
            expenses.add((ShoppingTransaction)newExpense); 
        }

        try {
            Files.writeString(Path.of("db/database.csv"), newExpense.toString() + "\n", StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }


    @Override 
    public String toString(){
        return "Income: " + getIncomeTransactions() + "\nExpenses: " + getExpenseTransactions();
    }


}
