import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * The PersonL2 class represents a bank customer with an Id, name, and a list of transactions.
 *
 * @Gary Milshteyn
 * @3.3.25
 */
public class PersonL2
{
    private int id;
    private String name;
    private List<String> transActionList;
    
    /**
     * Constructs a new Person L2 object with a given ID and name.
     * Initializes an empty transaction list with an initial capacity of 100.
     * 
     * @param id        The customer's ID number.
     * @param name      The customer's name.
     */
    public PersonL2(int id, String name){
        this.id = id;
        this.name = name;
        this.transActionList = new ArrayList<>(100);
    }
    
    /**
     * Returns the customer's ID
     * 
     * @return The customer's ID
     */
    public int getId(){
        return id;
    }
    
    /**
     * Returns the customer's name
     * 
     * @return The customer's name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Adds a transaction to the customer's transaction list
     * 
     * @param transaction       The transaction to add
     */
    public void addTransaction(String transaction){
        transActionList.add(transaction);
    }
    
    /**
     * Prints the customer's transaction details to console and writes the transaction details to an output file
     * 
     * @param writer        the output file
     */
    public void printTransactions(PrintWriter writer){
        System.out.println("id = " + id + " name = " + name);
        writer.println("id = " + id + " name = " + name);
        System.out.println("There were " + transActionList.size() + " transactions.");
        writer.println("There were " + transActionList.size() + " transactions.");
        for(String transaction : transActionList){
            System.out.println(transaction);
            writer.println(transaction);
        }
        System.out.println();
        writer.println();
    }
}
