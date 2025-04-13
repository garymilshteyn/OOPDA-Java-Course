import java.util.concurrent.locks.*;

/**
 * A savings account has a balance that can be changed by deposits and withdrawals.
 * Thread-save version of SavingsAccount for Project 5
 *
 * @author (OOPDA), Gary Milshteyn
 * @version (v1.0, 11/23/21), 4.13.25
 */
public class SavingsAccountP5
{
    private double balance;
    private Lock balanceLock;
    private Condition sufficientFunds;

    /**
    Constructs a savings account with a zero balance.
     */
    public SavingsAccountP5()
    {
        balance = 0;
        balanceLock = new ReentrantLock();
        sufficientFunds = balanceLock.newCondition();
    }

    /**
    Deposits money into the bank account.
    @param amount the amount to deposit
     */
    public void deposit(double amount)
    {
        balanceLock.lock();
        try{
            System.out.print("Depositing " + amount);
            double newBalance = balance + amount;
            System.out.println(", new balance is " + newBalance);
            balance = newBalance;
            sufficientFunds.signalAll();
        } finally {
            balanceLock.unlock();
        } 
    }

    /**
    Withdraws money from the bank account.
    @param amount the amount to withdraw
     */
    public void withdraw(double amount) throws InterruptedException
    {
        balanceLock.lock();
        try{
            while (balance < amount){
                System.out.println("Insufficient funds. Waiting...");
                sufficientFunds.await();
            }
            System.out.print("Withdrawing " + amount);
            double newBalance = balance - amount;
            System.out.println(", new balance is " + newBalance);
            balance = newBalance;
        } finally {
            balanceLock.unlock();
        }
    }

    /**
    Gets the current balance of the bank account.
    @return the current balance
     */
    public double getBalance()
    {
        return balance;
    }
}