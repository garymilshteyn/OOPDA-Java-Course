/**
 * PrintNum class - prints numbers from 1 to n, line breaks every 10
 * 
 * @author Gary Milshteyn
 * @version 4.13.25
 */
public class PrintNum implements Runnable{
    private final int lastNum;

    public PrintNum(int n){
        lastNum = n;
    }

    @Override
    public void run(){
        for(int i = 1; i <= lastNum; i++){
            System.out.print(i + " ");
            if(i % 10 == 0){
                 System.out.println();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
