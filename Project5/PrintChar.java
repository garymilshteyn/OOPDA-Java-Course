/**
 * PrintChar class - prints a character a given number of times
 * 
 * @author Gary Milshteyn
 * @version 4.13.25
 */
public class PrintChar implements Runnable {
    private final char charToPrint;
    private final int times;

    public PrintChar(char c, int t){
        charToPrint = c;
        times = t;
    }

    @Override
    public void run(){
        for(int i = 0; i < times; i++){
            System.out.print(charToPrint);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
