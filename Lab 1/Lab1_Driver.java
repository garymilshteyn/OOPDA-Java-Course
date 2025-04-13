/**
 * OOPDA, Lab 1
 * 
 * This is the driver class for the employee payroll system
 *
 * @author Gary Milshteyn
 * @version 2/17/2025
 */
import java.util.*;
public class Lab1_Driver
{
    public static void main(String[] args)
    {
        P1();
    }
    
    static void P1(){
    
        //Creates an ArrayList with an initial capacity of 10
       List<Person> people = new ArrayList<>(10);
       
       //Adds people to the list
       people.add(new HourlyWorker(101, "Smith", 50, 10.25));
       people.add(new CommissionedWorker(123, "Jones", 10000.0, 0.10));
       people.add(new Intern(120, "Wilson", 120.00));
       people.add(new HourlyWorker(103, "Williams", 50, 20.25));
       people.add(new CommissionedWorker(140, "Decker", 35000.0, 0.10));
       people.add(new Intern(129, "Brown", 105.00));
       people.add(new HourlyWorker(113, "Miller", 55, 30.25));
       people.add(new CommissionedWorker(150, "Davis", 15000.0, 0.20));
       people.add(new Intern(180, "Adams", 100.00));
       people.add(new HourlyWorker(119, "Murphy", 55, 30.50));
       
       //Prints out the list of people and their salaries
       System.out.println("id\tName\tSalary");
       for(Person person: people)
       {
           System.out.println(person);
       }
       
       //Shuffles the list
       Collections.shuffle(people);
       
       //Prints out the shuffled list
       System.out.println("\nAfter shuffle");
       System.out.println("id\tName\tSalary");
       for(Person person: people)
       {
           System.out.println(person);
       }
       
       //Check if the list contains "Davis" and remove if there is
       for(int i = 0; i < people.size(); i++){
           if(people.get(i).GetLastName().equals("Davis")){
               System.out.println("Does List contain Davis : true");
               System.out.println("remove Davis : " + people.remove(i));
               i--;
            }
        }
        System.out.println("Does List contain Davis : false");
        System.out.println("remove Davis : false");
        
        //Finds the index of "Williams"
        int indexWilliams = -1;
        for(int i = 0; i < people.size(); i++){
            if (people.get(i).GetLastName().equals("Williams")){
                indexWilliams = i;
                break;
            }
        }
        System.out.println("\nindexOf Williams is " + indexWilliams);
        
        
        //Change the hours worked
        if (indexWilliams >= 0){
            people.set(indexWilliams, new HourlyWorker(103, "Williams", 55, 20.25));
            System.out.println("New Salary: " + people.get(indexWilliams));
        }
        
        //Prints the first and last objects in the list
        System.out.println("First Object in list is " + people.get(0));
        System.out.println("Last object in list is " + people.get(people.size()-1));
        
        //Sorts the list by its natural ordering
        Collections.sort(people);
        
        //Prints the first and last objects in the sorted list
        System.out.println("Sorted list by its natural ordering");
        System.out.println("First object in list is " + people.get(0));
        System.out.println("Last object in the list is " + people.get(people.size()-1));
        
        //Iterates through the list alphabetically
        ListIterator<Person> it = people.listIterator();
        System.out.println("\nIterate in order alphabetically by name");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("\nIterate in reverse order");
        while(it.hasPrevious()){
            System.out.println(it.previous());
        }
    }
}