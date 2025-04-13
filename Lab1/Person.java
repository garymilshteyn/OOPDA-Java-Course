
/**
 * Person super-class that takes the ID and last name of a person
 *
 * @author Gary Milshteyn
 * @version 2/3/2025
 */
public abstract class Person implements Comparable<Person>{
    public int id;
    public String lastName;

    /**
     * A method that returns the ID of the person
     * @return
     *  The ID of the person
     */
    public int GetId(){
        return this.id;
    }

    /**
     * A method that returns the last name of the person
     * @return
     *  The last name of the person
     */
    public String GetLastName(){
        return this.lastName;
    }

    /**
     * An abstract method that computes the salary, depending on the worker
     * @return
     *  Returns the salary of the worker
     */
    public abstract double ComputeSalary();
    
    @Override
    public String toString(){
        return (this.id + " " + this.lastName);
    }
    
    @Override
    public int compareTo(Person other){
        return this.GetLastName().compareTo(other.GetLastName());
    }

}