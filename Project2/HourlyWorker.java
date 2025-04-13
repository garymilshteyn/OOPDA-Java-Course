
/**
 * This is the HourlyWorker subclass, where the worker makes money from a certain hourly salary
 *
 * @author Gary Milshteyn
 * @version 2/15/2025
 */
public class HourlyWorker extends Person
{
    private int hours;
    private double rate;
    
    public HourlyWorker(int id, String lastName, int hours, double rate){
        super.id = id;
        super.lastName = lastName;
        this.hours = hours;
        this.rate = rate;
    }
    
    /**
     * Method that calculates the salary based on hourly rate
     * @return
     *  If worker worked 40 hours or lower, then pay is calculated by rate * hours. If worker worked overtime, then the overtime pay is multiplied by 1.5
     */
    public double ComputeSalary(){
        if(hours > 40){
            double regularPay = 40 * rate;
            double overtimePay = (hours - 40) * (rate * 1.5);
            return regularPay + overtimePay;
        }
        else
            return hours * rate;
    }
    
    @Override
    public String toString()
    {
        return (super.toString() + " " + this.ComputeSalary());
    }
}
