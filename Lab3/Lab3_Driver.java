import java.io.*;
import java.math.BigInteger;
import java.util.*;
import javax.swing.*;

/**
 * Main class containing all three methods
 * 
 * @author Gary Milshteyn
 * @version 4.5.25
 */
public class Lab3_Driver{
    public static void main(String[] args){
        P1();
        P2();
        P3();
    }
    
    public static void P1(){
        while(true){
            try{
                String input = JOptionPane.showInputDialog("Enter a non-negative integer:");
                
                //If user cancels input, exit method
                if(input == null){
                    JOptionPane.showMessageDialog(null, "Operation cancelled.");
                    return;
                }
                
                int num = Integer.parseInt(input);
                
                if(num < 0){
                    JOptionPane.showMessageDialog(null, "Negative numbers are not allowed.");
                    continue;
                }
                
                BigInteger result = factorial(num);
                JOptionPane.showMessageDialog(null, "Factorial of " + num + " is:\n " + result);
                break;
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a positive integer.");
            }
        }
    }
    public static void P2(){
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.print("Enter a non-negative integer: ");
            
            if(scanner.hasNextInt()){
                int num = scanner.nextInt();
                
                if(num < 0){
                    System.out.println("Negative numbers are not allowed.");
                } else {
                    BigInteger result = factorial(num);
                    System.out.println("Factorial of " + num + " is: " + result);
                    break;
                }
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next();
            }
        }
        scanner.close();
    }
    public static void P3(){
        try{
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(null);
            
            if(result != JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null, "No file selected.");
                return;
            }
            
            File file = chooser.getSelectedFile();
            Scanner reader = new Scanner(file);
            
            TreeSet<Integer> uniqueInts = new TreeSet<>();
            
            while(reader.hasNext()){
                if(reader.hasNextInt()){
                    uniqueInts.add(reader.nextInt());
                } else {
                    reader.next();
                }
            }
            
            reader.close();
            
            if(uniqueInts.isEmpty()){
                JOptionPane.showMessageDialog(null, "No integers found in file.");
            }
            
            File output = new File("sorted_output.txt");
            PrintWriter writer = new PrintWriter(output);
            
            for(int num : uniqueInts){
                writer.println(num);
            }
            
            writer.close();
            JOptionPane.showMessageDialog(null, "Sorted integers saved to sorted_output.txt");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public static BigInteger factorial(int n){
        BigInteger result = BigInteger.ONE;
        
        for(int i = 2; i<= n; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        
        return result;
    }
}