/**
 * The PersonP3 class represents a bank customer with an ID, name, and a list of transactions.
 * This class provides methods to manage the customer's transactions and implements case-insensitive comparison for equality
 * 
 * @Gary Milshteyn
 * @2.24.25
 */
import java.util.*;
public class PersonP3 {
    private int id;
    private String name;
    private List<String> transactions;
    
    /**
     * Constructs a new PersonP3 object
     * 
     * @param id           The customer's ID number
     * @param name         The customer's name
     * @param transaction  The customer's initial transaction. 
     */
    public PersonP3(int id, String name, String transaction){
        this.id = id;
        this.name = name;
        this.transactions = new ArrayList<>();
        this.transactions.add(transaction);
    }
    
    /**
     * Returns the customer's ID.
     * 
     * @return The customer's ID
     */
    public int getId(){
        return id;
    }
    
    
    /**
     * Returns the customer's name
     * 
     * @return The customer's name.
     */
    public String getName(){
        return name;
    }
    
    
    /**
     * Returns the list of the customer's transactions.
     * 
     * @return A list of transactions
     */
    public List<String> getTransactions(){
        return transactions;
    }
    
    /**
     * Adds a transaction to the customer's transaction list
     * 
     * @param transaction       The transaction to add
     */
    public void addTransaction(String transaction){
        transactions.add(transaction);
    }
    
    /**
     * Compares this object to another object for equality, which is determined by comparing ID and name (not case-sensitive)
     * 
     * @param o     The object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o){
        if(this == o) 
            return true;
        if(!(o instanceof PersonP3))
            return false;
        PersonP3 personP3 = (PersonP3) o;
        return id == personP3.id && name.equalsIgnoreCase(personP3.name);
    }
    
    /**
     * Retursn a hash code for this object
     * 
     * @return hash code for this object
     */
    @Override
    public int hashCode(){
        return Objects.hash(id, name.toLowerCase());
    }
    
    
    /**
     * Returns a string representation of this object. The string includes the ID, name, number of transactions, and a list of all transactions
     * 
     * 
     */
    @Override
    public String toString(){
        return "id = " + id + " name = " + name + "\nThere were " + transactions.size() + " transactions.\n" + String.join("\n", transactions);
    }
}
