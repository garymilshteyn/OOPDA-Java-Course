/**
 * This driver class processes demosntrates hash sets and how to read data from a file
 * 
 * @Gary Milshteyn
 * @2.24.25
 */

import java.io.*;
import java.util.*;
import javax.swing.*;
public class Project3_Driver
{
    public static void main (String[] args)
    {
        P1();
        P2();
        P3();
    }

    /**
     * Reads integers from a file, stores them in a HashSet, and prints the unique numbers.
     */
    public static void P1()
    {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            try {
                List<Integer> numbers = readIntegersFromFile(selectedFile);
                Set<Integer> uniqueSortedNumbers = new HashSet<>(numbers);
                
                System.out.println("The selected file is " + selectedFile.getName());
                System.out.println(uniqueSortedNumbers);
            } catch (FileNotFoundException e) {
                System.err.println("Error: File not found.");
            }
        } else {
            System.out.println("No file selected.");
        }
    }
    
    /**
     * Reads integers from two files, calcualtes and prints their union and intersection, and writes them to files
     */
    public static void P2()
    {
        JFileChooser fileChooser = new JFileChooser();
        int result1 = fileChooser.showOpenDialog(null);
        if(result1 != JFileChooser.APPROVE_OPTION){
            System.out.println("No file selected for sequence 1.");
            return;
        }
        File file1 = fileChooser.getSelectedFile();
        
        int result2 = fileChooser.showOpenDialog(null);
        if(result2 != JFileChooser.APPROVE_OPTION){
            System.out.println("No file selected for sequence 2.");
            return;
        }
        
        File file2 = fileChooser.getSelectedFile();
        
        try {
            List<Integer> list1 = readIntegersFromFile(file1);
            List<Integer> list2 = readIntegersFromFile(file2);
            
            Set<Integer> unionSet = new HashSet<>();
            unionSet.addAll(list1);
            unionSet.addAll(list2);
            List<Integer> unionList = new ArrayList<>(unionSet);
            
            Set<Integer> intersectionSet = new HashSet<>();
            for(Integer num : list1){
                if(list2.contains(num)){
                    intersectionSet.add(num);
                }
            }
            List<Integer> intersectionList = new ArrayList<>(intersectionSet);
            
            bubbleSort(unionList);
            bubbleSort(intersectionList);
            
            writeListToFile(unionList, "unionout.txt");
            writeListToFile(intersectionList, "xout.txt");
            
            System.out.println("The selected file is " + file1.getName());
            System.out.println("The selected file is " + file2.getName());
            System.out.println("set1 " + list1);
            System.out.println("set2 " + list2);
            System.out.println("Union " + unionList);
            System.out.println("Intersection " + intersectionList);
        } catch (FileNotFoundException e){
            System.out.println("Error: File not found.");
        }
        
    }
    
    /**
     * Reads a bank transaction file, creates PersonP3 objects, stores them in a HashSet, and prints a customer transaction log
     */
    public static void P3()
    {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("The selected file is " + selectedFile.getName());
            System.out.println("Reading the bank transaction file");
            String line;
            printFileContents(selectedFile);
            processBankFile(selectedFile);
        } else {
            System.out.println("No file selected.");
        }
    }
    
    /**
     * Reads integers from the specified file
     * 
     * @param file      The file to read integers from
     * @return A list of integers read from the file
     * @throws FileNotFoundException if the file is not found
     */
    private static List<Integer> readIntegersFromFile(File file) throws FileNotFoundException{
        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()){
            numbers.add(scanner.nextInt());
        }
        scanner.close();
        return numbers;
    }
    
    /**
     * Sorts a list of integers using the Bubble Sort algorithm
     * 
     * @param list      The list of integers to be sorted
     */
    private static void bubbleSort(List<Integer> list){
        int n = list.size();
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(list.get(j) > list.get(j+1)){
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }
    
    /**
     * Writes a list of integers to a file
     * 
     * @param list      The list of integers to write
     * @param filename  The name of the file to write to
     */
    private static void writeListToFile(List<Integer> list, String filename){
        try (PrintWriter writer = new PrintWriter(filename)){
            writer.println(list);
        } catch(FileNotFoundException e){
            System.out.println("Error writing to file: " + filename);
        }
    }
    
    /**
     * Prints the contents of a file to the console
     * 
     * @param file      The file to print the contents of
     */
    private static void printFileContents(File file){
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine())!=null){
                System.out.println(line);
            }
            System.out.println();
        } catch (IOException e){
            System.out.println("Error reading file for printing: " + e.getMessage());
        }
    }
    
    /**
     * Processes a bank transaction file, creaiting and updating PersonP3 objects
     * 
     * @param file      The bank transaction file to process
     */
    private static void processBankFile(File file){
        Set<PersonP3> customerSet = new HashSet<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null){
                line = line.trim();
                if(line.isEmpty())
                    continue;
                    
                String[] parts = line.split("\\s+");
                if(parts.length != 3){
                    System.out.println("Invalid record format: " + line);
                    continue;
                }
                
                try {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String transaction = parts[2];
                    
                    PersonP3 newPerson = new PersonP3(id, name, transaction);
                    PersonP3 existingPerson = null;
                    
                    for(PersonP3 p: customerSet){
                        if(p.equals(newPerson)){
                            existingPerson = p;
                            break;
                        }
                    }
                    
                    if(existingPerson != null){
                        existingPerson.addTransaction(transaction);
                    } else {
                        customerSet.add(newPerson);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID fomrat: " + line);
                }
            }
            
            System.out.println("\nDisplay of customer transaction log");
            for(PersonP3 person : customerSet){
                System.out.println(person);
                System.out.println();
            }
        } catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
