
/**
 * Main class that demonstrates lambda expressions, sorting, and functional interfaces
 *
 * @author Gary Milshteyn
 * @version 3.10.25
 */
import java.util.function.*;
import java.util.*;
public class Project4_Driver
{
    public static void main(String[] args){
        P1();
        P2();
        P3();
    }
    
    /**
     * Problem 1: Demonstrates a functional interface and lambda expressions
     */
    public static void P1(){
        //Two Lambda Expressions that implement MyFunctionalInterface
        MyFunctionalInterface cap = msg -> System.out.println(msg.toUpperCase());
        MyFunctionalInterface low = msg -> System.out.println(msg.toLowerCase());
        
        //Execution of the Lambda Expressions
        cap.execute("Hello World!");
        low.execute("Hello World!");
        
        //Consumer implementation
        Consumer<String> displayMessage = msg -> System.out.println("Message: " + msg);
        displayMessage.accept("This is a Consumer example.");
        
        //BiConsumer implementation
        BiConsumer<Integer, Integer> add = (a, b) -> System.out.println("Addition: "+ (a+b));
        add.accept(10, 15);
        
        //Passing lambda to a static method
        foo(cap, "Passing a lambda to foo!");
    }
    /**
     * Accepts a functional interface variable and executes it
     * @param func      A functional interface implementation.
     * @param message   The message to be processed
     */
    public static void foo(MyFunctionalInterface func, String message){
        func.execute(message);
    }
    
    /**
     * Demonstrates sorting using lambda expressions and forEach loop, rather than Comparators
     */
    public static void P2(){
        List<Shape> shapesList = new ArrayList<Shape>();
        shapesList.add(new Rectangle(5, 10, 4, 6));
        shapesList.add(new Circle(3, 15, 5));
        shapesList.add(new Rectangle(7, 8, 10, 2));
        shapesList.add(new Circle(5, 10, 10));
        
        //Sorts by X position using lambda expression and print
        shapesList.sort((s1, s2) -> Double.compare(s1.getX(), s2.getX()));
        System.out.println("Shapes sorted by X position: ");
        shapesList.forEach(System.out::println);
        
        //Sorts by Area using lambda expression and print
        shapesList.sort((s1, s2) -> Double.compare(s1.ComputeArea(), s2.ComputeArea()));
        System.out.println("Shapes sorted by Area: ");
        shapesList.forEach(System.out::println);
    }
    
    /**
     * Problem 3: Demonstrates the use of Predicate and Consumer funcitonal interfaces
     */
    public static void P3(){
        //Creates a list of number
        List<Integer> nums = List.of(2, 3, 1, 5, 6, 7, 8, 9, 12, 256, 300, 301, 303, 17, 120);
        
        //Predicate to check if a number is prime
        Predicate<Integer> isPrime = n -> {
            if(n < 2)
                return false;
            for(int i = 2; i <= Math.sqrt(n); i++)
                if(n % i == 0)
                    return false;
            return true;
        };
        
        //Predicate to check if a number is odd
        Predicate<Integer> isOdd = n -> n % 2 != 0;
        
        //Predicate to check if a number is a multiple of 3
        Predicate<Integer> isMultipleOfThree = n -> n % 3 == 0;
        
        //Prints all numbers
        System.out.println("Display all numbers:");
        PerformConditionally(nums, i -> true, System.out::println);
        
        //Prints all prime numbers
        System.out.println("\nDisplay all prime numbers:");
        PerformConditionally(nums, isPrime, System.out::println);
        
        //Prints all odd numbers
        System.out.println("\nDisplay all odd numbers:");
        PerformConditionally(nums, isOdd, System.out::println);
        
        //Prints all numbers that are multiples of 3
        System.out.println("\nDisplay all numbers that are multiples of 3:");
        PerformConditionally(nums, isMultipleOfThree, System.out::println);
    }
    
    /**
     * Filters and processes numbers based on given predicate and consumer
     * @param nums      The list of integers to process
     * @param predicate A condition to filter numbers
     * @param consumer  A function to apply to the filtered numbers
     */
    private static void PerformConditionally(List<Integer> nums, Predicate<Integer> predicate, Consumer<Integer> consumer){
        for(Integer i : nums){
            if (predicate.test(i)){
                consumer.accept(i);
            }
        }
    }
}
