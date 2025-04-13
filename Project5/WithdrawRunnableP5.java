
/**
 * A withdraw runnable makes periodic withdrawals from a bank account.
 * Thread-safe withdraw runnable for Project 5
 * 
 * @author (OOPDA)
 * @version (v1.0)
 */

public class WithdrawRunnableP5 implements Runnable
{
    private static final int DELAY = 1;
    private SavingsAccountP5 account;
    private double amount;
    private int count;

    /**
    Constructs a withdraw runnable.
    @param anAccount the account from which to withdraw money
    @param anAmount the amount to withdraw in each iteration
    @param aCount the number of iterations
     */
    public WithdrawRunnableP5(SavingsAccountP5 anAccount, double anAmount, int aCount)
    {
        account = anAccount;
        amount = anAmount;
        count = aCount;
    }

    public void run()
    {
        try
        {
            for (int i = 1; i <= count; i++)
            {
                account.withdraw(amount);
                Thread.sleep(DELAY);
            }
        }
        catch (InterruptedException exception) {}
    }
}