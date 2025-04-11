/**
 * This is the intern subclass, where the worker makes money from a certain weekly pay
 *
 * @author Gary Milshteyn
 * @version 2/3/2025
 */
public class Intern extends Person
{
    private double pay;
    
    public Intern(int id, String lastName, double pay){
        super.id = id;
        super.lastName = lastName;
        this.pay = pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
    /**
     * Returns the weekly pay
     */
    @Override
    public double ComputeSalary(){
        return pay;
    }
    
    @Override
    public String toString()
    {
        return (super.toString() + " " + this.ComputeSalary());
    }

    
}