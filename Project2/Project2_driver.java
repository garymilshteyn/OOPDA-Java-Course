
/**
 * OPPDA Project 2 driver 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.*;
public class Project2_driver
{
    public static void main(String[] args)
    {
        P1();
        P2();
    }

 
    static void P1()
    {
        Circle c;
        Rectangle r;
        
        LinkedList<Shape> shapesList = new LinkedList<>();

        c = new Circle(20, 0, 10.0);
        shapesList.add(c);

        c = new Circle(40, 10, 4.0);
        shapesList.add(c);

        r = new Rectangle(50, 20, 5.0, 6.0);
        shapesList.add(r);

        r = new Rectangle(30, 20, 5.0, 16.0);
        shapesList.add(r);
        
        System.out.println();
        System.out.println("Original Ordering");
        for (int i = 0; i < 4; i++) {
            System.out.println(shapesList.get(i));       
        }

        System.out.println(c.compareTo(r));
        // Sort by area using the Capmparable Interface
        Collections.sort(shapesList);

        System.out.println();
        System.out.println("Sorted by area");
        for (int i = 0; i < 4; i++) {
            System.out.println(shapesList.get(i));       
        }
        
        // Sort by the x position via shape implementation of the the Comparator Interface
        Collections.sort(shapesList, new ShapeXPosComparator());
        
        System.out.println();
        System.out.println("Sorted by x position");
        for (int i = 0; i < 4; i++) { 
            System.out.println(shapesList.get(i));      
        }
        
        // Sort by the x position via shape implementation the Comparator Interface
        
        Collections.sort(shapesList, new ShapePerimeterComparator());
        
        System.out.println();
        System.out.println("Sorted by perimeter");
        for (int i = 0; i < 4; i++) {
            System.out.println(shapesList.get(i));      
        }
    }    
    
    static void P2()
    {
        //
        // Do not modify any of the code in this code block!!!
        // 
        
        List<Person> people = new LinkedList<>();
        
        //                          ID    Last Hours  rate
        people.add(new HourlyWorker(101, "Smith", 50, 10.25));
        //                                 ID    Last    Sales    rate
        people.add(new CommissionedWorker(123, "Jones", 10000.0, 0.10));
        //                    ID    Last  weekly stipend
        people.add(new Intern(120, "Wilson", 120.00));
        people.add(new HourlyWorker(103, "Williams", 50, 20.25));
        people.add(new CommissionedWorker(140, "Decker", 35000.0, 0.10));
        people.add(new Intern(129, "Brown", 105.00));
        people.add(new HourlyWorker(113, "Miller", 55, 30.25));
        people.add(new CommissionedWorker(150, "Davis", 15000.0, 0.20));
        people.add(new Intern(180, "Adams", 100.00));
        people.add(new HourlyWorker(119, "Murphy", 55, 30.50));
        
        for (Person p : people)
        {
            System.out.println(p); 
        }

        System.out.println();
        System.out.println("id             Name    Salary");
        for (Person p : people)
        {
            System.out.printf("%d %15s  $%8.2f\n",p.GetId(), p.GetLastName(), p.ComputeSalary());
        }
        
        Collections.sort(people);  // Use Caomparble interface
        
        ListIterator iterator = people.listIterator();

        System.out.println("Iterate in order alphabetically");
        while (iterator.hasNext()) 
        {
            System.out.println(iterator.next());
        }

        System.out.println("Iterate in reverse order");
        while (iterator.hasPrevious()) 
        {
            System.out.println(iterator.previous());
        }
        
        // Sort by id
        Comparator<Person> idComparator = new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2){
                return Integer.compare(p1.GetId(), p2.GetId());
            }
        };
        Collections.sort(people, idComparator);
        System.out.println("People sorted by ID:");
        for (Person p: people){
            System.out.println(p);
        }
        
        // Sort by salary
        Comparator<Person> salaryComparator = new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2){
                return Double.compare(p1.ComputeSalary(), p2.ComputeSalary());
            }
        };
        Collections.sort(people, salaryComparator);
        System.out.println("People sorted by salary from lowest to highest");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("People sorted by salary from highest to lowest");
        while(iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
        
    }
}
