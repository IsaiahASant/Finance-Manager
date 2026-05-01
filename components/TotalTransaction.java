package components;
/**
 * this class keeps total income and expenses that will
 * be used to display on the graph
 * @Author Isaiah Santamaria
 */
public class TotalTransaction {
    private double expense;
    private double income; 
    /**
     * 
     */
    public TotalTransaction(){
        expense = 0;
        income = 0;
    }
    
    /**
     * 
     * @param value
     */
    public void addIncome(double value){
        income = income + value;

    }

    /**
     * 
     * @param value
     */
    public void addExpense(double value){
        expense = expense + value;

    }

    /**
     * total expense(int value)
     * @return total expense(int value)
     */
    public int getExpense(){
        return (int) expense;
    }
    
    /**
     * total income(int value)
     * @return total income(int value)
     */
    public int getIncome(){
        return (int) income;
    }
}
