
/**
 * Write a description of class P1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Project5_driver
{
    public static void main(String[] args)
    {
        //P1();
        //P2();
        P3();
    }
    
    public static void P1()
    {
        Thread printA   = new Thread(new PrintChar('a', 100));  
        Thread printB   = new Thread(new PrintChar('b', 100));
        Thread print100 = new Thread(new PrintNum(100));
        
        printA.start();
        printB.start();
        print100.start();
    }
    public static void P2()
    {
        SavingsAccountP5 account = new SavingsAccountP5();
        final double AMOUNT = 100;
        final int ITERATIONS = 2000;
        final int THREADS = 2;

        for (int i = 1; i <= THREADS; i++)
        {
            DepositRunnableP5 d = new DepositRunnableP5(account, AMOUNT, ITERATIONS);
            WithdrawRunnableP5 w = new WithdrawRunnableP5(account, AMOUNT, ITERATIONS);

            Thread dt = new Thread(d);
            Thread wt = new Thread(w);

            dt.start();
            wt.start();
        }
    }

    public static void P3(){
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, String> songs = new HashMap<>();
        songs.put(1, "Project5/bear_growl_y.wav");
        songs.put(2, "Project5/bird.wav");
        songs.put(3, "Project5/cat_big_x.wav");
        songs.put(4, "Project5/coyote_howl.wav");
        songs.put(5, "Project5/rooster.wav");

        Thread currentSongThread = null;

        while (true) { 
            System.out.println("\n Available Sounds:");
            for(int i = 1; i <= songs.size(); i++)
                System.out.println(i + ": " + songs.get(i));
            System.out.println("0: Stop current sound");
            System.out.println("-1: Exit");

            System.out.print("Pick a sound number: ");
            int choice = scanner.nextInt();

            if(choice == -1){
                if (currentSongThread != null && currentSongThread.isAlive()){
                    currentSongThread.interrupt();
                }
                break;
            }
            else if (choice == 0){
                if (currentSongThread != null && currentSongThread.isAlive()){
                    currentSongThread.interrupt();
                    System.out.println("Sound stopped.");
                } else
                    System.out.println("No sound is playing.");
                
            }
            else if (songs.containsKey(choice)){
                if (currentSongThread != null && currentSongThread.isAlive())
                    currentSongThread.interrupt();
                
                Runnable player = new audioPlayer(songs.get(choice));
                currentSongThread = new Thread(player);
                currentSongThread.start();
                System.out.println("Now playing: " + songs.get(choice));
            }
            else
                System.out.println("Invalid choice.");
        }
        scanner.close();
        System.out.println("Exiting Sound Player.");
    }
}
