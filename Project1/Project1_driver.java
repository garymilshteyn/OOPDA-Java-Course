
/**
 * OOPDA, Project 1
 *
 * @author Gary Milshteyn
 * @version 2/3/2025
 */
import java.util.ArrayList;
import java.util.List;
public class Project1_driver
{
    public static void main(String[] args)
    {
        // Modify to include your name!!!!!!!!!!!!!!!!
        System.out.println("Project1, John Doe, student id = 9999999");
        
        P1();
        P2();
    }
    
    /**
     * Driver code for Problem1 (The Animal/Pet program)
     *
     */
    
    static void P1()
    {

        List<Animal> pets = new ArrayList<>();
        Animal refVarAnimal = null;
        
        pets.add(new Dog(12, "Rover"));    // Create a dog object and store it in array that hold animal objects.
        pets.add(new Cat(7,  "Felix"));    // Create a cat object and store it in array that hold animal objects.
        pets.add(new Cat(6.5,"Garfield")); // Create a cat object and store it in array that hold animal objects.
        pets.add(new Dog(15, "Ren"));      // Create a dog object and store it in array that hold animal objects.
        pets.add(new Dog(14, "Astro"));   // Create a dog object and store it in
        pets.add(new Duck(2, "Frank")); // Create a Duck pet
        pets.add(new Fish(1, "Goldie")); //Creates a fish pet
        
        for (int i = 0; i < pets.size(); i++)
        {
            refVarAnimal = pets.get(i);
            System.out.println("The pet's name is " + pets.get(i).getName()); // Animal class getter
            System.out.println("It weighs " + pets.get(i).getWeight());       // Animal class getter
            refVarAnimal.Sound(); // polymorphic method
            refVarAnimal.Eat();   // polymorphic method
            System.out.println();
        }
        
        // Use the Animal getter and setter methods to allow the pets to gain some weight
        for (int i = 0; i < pets.size(); i++)
        {
           refVarAnimal = pets.get(i);
           double weight = refVarAnimal.getWeight();
           weight = weight + 0.5;
           pets.get(i).setWeight(weight);
        }
        
        System.out.println("-----------------------------------------\n");
        System.out.println("After the pets have been eating the great pet food for a month!!!");
        //
        // Do not modify any of the code in this for loop code block!!!
        //
        for (int i = 0; i < pets.size(); i++)
        {
            refVarAnimal = pets.get(i);
            System.out.println("The pet's name is " + refVarAnimal.getName()); // Animal class getter
            System.out.println("It weighs " + refVarAnimal.getWeight());       // Animal class getter
            refVarAnimal.Sound(); // polymorphic method
            refVarAnimal.Eat();   // polymorphic method
            System.out.println();
        }

    }

     /**
     * Driver code for Problem2
     *
     */

    static void P2()
    {
        //
        // Do not modify any of the code in the P2 code block!!!
        //

        List<Person> people = new ArrayList<>();
        Person refVarPerson = null;
        
        //                           ID    Last  Hours rate
        people.add(new HourlyWorker(101, "Smith", 50, 10.25));
        //                                 ID    Last  Hours rate
        people.add(new CommissionedWorker(123, "Jones", 10000.0, 0.10));
        //                     ID    Last  weekly stipend
        people.add(new Intern(120, "Wilson", 120.00));
        people.add(new HourlyWorker(103, "Williams", 50, 20.25));
        people.add(new CommissionedWorker(140, "Decker", 35000.0, 0.10));
        people.add(new Intern(129, "Brown", 105.00));
        people.add(new HourlyWorker(113, "Miller", 55, 30.25));
        people.add(new CommissionedWorker(150, "Davis", 15000.0, 0.20));
        people.add(new Intern(180, "Adams", 100.00));
        people.add(new HourlyWorker(119, "Murphy", 55, 30.50));
        
                
        for (int i = 0; i < people.size(); i++)
        {
            refVarPerson = people.get(i);
            System.out.println(refVarPerson); 
        }

        System.out.println();
        System.out.println("id             Name    Salary");
        
        for (Person refVar : people)  // Enhanced for loop (for-each)
        {
            System.out.printf("%d %15s  $%8.2f\n",refVar.GetId(),refVar.GetLastName(), refVar.ComputeSalary());
        }

    }
}