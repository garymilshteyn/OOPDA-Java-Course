/**
* A deposit runnable makes periodic deposits to a bank account.
* Thread-safe deposit runnable for Project 5
 */
public class DepositRunnableP5 implements Runnable
{
    private static final int DELTA = 1;
    private SavingsAccountP5 account;
    private double amount;
    private int count;

    /**
    Constructs a deposit runnable.
    @param anAccount the account into which to deposit money
    @param anAmount the amount to deposit in each iteration
    @param aCount the number of iterations
    */
    public DepositRunnableP5(SavingsAccountP5 anAccount, double anAmount, int aCount)
    {
        account = anAccount;
        amount = anAmount;
        count = aCount;
    }

    @Override
    public void run()
    {
        try
        {
            for (int i = 1; i <= count; i++)
            {
                account.deposit(amount);
                Thread.sleep(DELTA);
            }
        }
        catch (InterruptedException exception) {}
    }
}