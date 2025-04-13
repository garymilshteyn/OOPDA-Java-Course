/**
 * This is the Commissioned Worker subclass, where the worker makes money based of the amount of sales made.
 *
 * @author Gary Milshteyn
 * @version 2/15/2025
 */
public class CommissionedWorker extends Person
{
    private double sales;
    private double rate;
    
    public CommissionedWorker(int id, String lastName, double sales, double rate){
        super.id = id;
        super.lastName = lastName;
        this.sales = sales;
        this.rate = rate;
    }
    
    /**
     * Method that returns the Salary based of the amount of sales made
     */
    public double ComputeSalary(){
        return sales * rate;
    }
    
    @Override
    public String toString()
    {
        return (super.toString() + " " + this.ComputeSalary());
    }
}