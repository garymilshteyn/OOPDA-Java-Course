import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 * The Lab2_Driver class reads a transaction file, processes transactions, and displays the results to the console and output file.
 * 
 * @Gary Milshteyn
 * @3.3.25
 */
public class Lab2_Driver{
    public static void main(String[] args){
        p1();
    }
    public static void p1(){
        Scanner mapScanner = new Scanner(System.in);
        System.out.println("Select Map type: (1) HashMap (2) LinkedHashMap (3) TreeMap");
        int choice = mapScanner.nextInt();
        mapScanner.nextLine();
        
        Map<Integer, PersonL2> map;
        switch (choice) {
            case 2:
                map = new LinkedHashMap<>();
                break;
            case 3:
                map = new TreeMap<>();
                break;
            default:
                map = new HashMap<>();
        }
        
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if(result != JFileChooser.APPROVE_OPTION) {
            System.out.println("No file selected. Exiting program.");
            return;
        }
        
        File inputFile = fileChooser.getSelectedFile();
        System.out.println("The selected file is " + inputFile.getName());
        
        System.out.println("Reading the bank transaction file...");
        
        try (Scanner fileScanner = new Scanner(inputFile)){
            while(fileScanner.hasNextLine()){
                String[] parts = fileScanner.nextLine().split("\\s+");
                if(parts.length < 3)
                    continue;
                int id = Integer.parseInt(parts[0]);
                String name = parts[1].toLowerCase();
                String transaction = parts[2];
                
                PersonL2 pF = map.get(id);
                if(pF != null) {
                    pF.addTransaction(transaction);
                } else {
                    PersonL2 p = new PersonL2(id, name);
                    p.addTransaction(transaction);
                    map.put(id, p);
                }
            }
        } catch (IOException e){
            System.out.println("Error reading the file.");
        }
        
        System.out.println("\nDisplay of customer transaction log");
        
        try(PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))){
            for(Map.Entry<Integer, PersonL2> entry : map.entrySet()){
                entry.getValue().printTransactions(writer);
            }
            System.out.println("Transaction log has been written to output.txt");
            try {
                Desktop.getDesktop().open(new File("output.txt"));
            } catch (IOException e){
                System.out.println("Error opening output file.");
            }
        } catch (IOException e){
            System.out.println("Error writing to file.");
        }
    }
}