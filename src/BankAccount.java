public class BankAccount
{
    private String accountHolder;
    private int accountNumber;
    private double balance;
    private double[] arr = new double[3];
    private int transactionCount = 0;
    private double[] balanceArr = new double[3];


    public BankAccount(String name,int number,double balance)
    {
        this.accountHolder = name;
        this.accountNumber = number;
        this.balance = balance;
    }

    public double getBalance()
    {
        return balance;
    }
    void displayAccountDetails()
    {
        System.out.println("Account Holder's Name: " +accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: " + balance);
    }

    void deposit(double amount)
    {
        if(amount>0)
        {
            double depositValue = amount;
            balance += amount;
            double transactionBalance = balance;
            transactions(depositValue,transactionBalance);
            System.out.println("Deposit successfully");
            System.out.println("Current Balance: "+balance);
        }
        else
        {
            System.out.println("Invalid deposit amount");
        }
    }

    void withdraw(double amount)
    {
        if(amount > 0 && balance>=amount)
        {
            double withdrawValue = -amount;
            balance -= amount;
            double transactionBalance = balance;
            transactions(withdrawValue,transactionBalance);
            System.out.println("Withdraw Successfully");
            System.out.println("Current Balance: "+balance);
        }
        else
        {
            System.out.println("Invalid withdraw amount");
        }
    }

    void transactions(double transactionValue,double balanceValue)
    {
        if(transactionCount == arr.length)
        {
            double[] newArr = new double[arr.length*2];
            for(int i=0;i<arr.length;i++)
            {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        if(transactionCount == balanceArr.length)
        {
            double[] newBalanceArr = new double[balanceArr.length*2];
            for(int i=0;i<balanceArr.length;i++)
            {
                newBalanceArr[i] = balanceArr[i];
            }
            balanceArr = newBalanceArr;
        }
        arr[transactionCount] = transactionValue;
        balanceArr[transactionCount] = balanceValue;
        transactionCount++;
    }
    void transactionDisplay()
    {
        System.out.println("Transaction History");
        if(transactionCount==0)
        {
            System.out.println("No Transaction yet");
        }
        if(transactionCount>0)
        {
            for(int i = 0; i < transactionCount; i++)
            {
                if(arr[i] > 0)
                {
                    System.out.println((i + 1) + "." + "Deposit: " + arr[i]);
                    System.out.println("  Balance: " + balanceArr[i]);
                }
                else
                {
                    System.out.println((i + 1) + "." + "Withdraw: " + (-arr[i]));
                    System.out.println("  Balance: " + balanceArr[i]);
                }
            }
            System.out.println("Total Transactions: "+ transactionCount);
            System.out.println("Current Balance: "+ balance);
        }
    }
}
