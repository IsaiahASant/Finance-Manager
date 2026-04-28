package backend;
import backend.ExpenseTransaction;
import java.util.ArrayList;


public class TransactionHistory {
    //instance variables for incomes and expenses
    private ArrayList<IncomeTransaction> incomes;
    private ArrayList<BillTransaction> expenses;

    public TransactionHistory(){
        this.incomes = new ArrayList<IncomeTransaction>();
        this.expenses = new ArrayList<BillTransaction>();
    }

    public String getIncomeTransactions(){
        String output = "";
        for(IncomeTransaction income : incomes){
            output = income + " ";
        }
        return output;
    }

    public String getExpenseTransactions(){
        return expenses.toString();
    }

    public void addIncome(IncomeTransaction newIncome){
        incomes.add(newIncome);
    }
    
    public void addExpense(BillTransaction newExpense){
        expenses.add(newExpense);
        
    }

   
    @Override 
    public String toString(){
        return "Income: " + getIncomeTransactions() + "\nExpenses: " + getExpenseTransactions();
    }


}
