import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("=====IOB BANK=====");
        System.out.println("Account Creation");
        System.out.println("Accountholder's Name: ");
        String accountHolder = sc.nextLine().trim();
        while (accountHolder.isEmpty())
        {
            System.out.println("Please Enter your Name: ");
            accountHolder = sc.nextLine().trim();
        }
        for (int i = 0; i < accountHolder.length(); i++)
        {
            char ch = accountHolder.charAt(i);
            if (!Character.isLetter(ch) && ch != ' ')
            {
                System.out.println("Enter the valid account name");
                accountHolder = sc.nextLine().trim();
                while (accountHolder.isEmpty())
                {
                    System.out.println("Please Enter your Name: ");
                    accountHolder = sc.nextLine().trim();
                }
                i=-1;
            }
        }
        System.out.println("Account Number: ");
        int accountNumber = 0;
        while (accountNumber <= 0) {
            if (sc.hasNextInt()) {
                accountNumber = sc.nextInt();

                if (accountNumber <= 0) {
                    System.out.println("Account number must be greater than zero.");
                    System.out.println("Account Number: ");
                }
            } else {
                sc.next(); // Consume invalid input
                System.out.println("Please enter a valid integer account number: ");
            }
        }
        System.out.println("Account Balance: ");
        double balance = 0.0;
        while(balance<1000.0)
        {
            if(sc.hasNextDouble())
            {
                balance = sc.nextDouble();
                if(balance<1000.0)
                {
                    System.out.println("Minimum Balance needs to be 1000 to create an account");
                    System.out.println("Account Balance: ");
                }
            }
            else
            {
                sc.next();
                System.out.println("Please Enter an Integer Balance: ");
            }
        }
        BankAccount account1 = new BankAccount(accountHolder,accountNumber,balance);
        int choice = 0;
        do
        {
            System.out.println("=====MENU=====");
            System.out.println();
            System.out.println("1.Account Details:");
            System.out.println("2.Deposit:");
            System.out.println("3.Withdraw:");
            System.out.println("4.Balance:");
            System.out.println("5.Transactions:");
            System.out.println("6.Exit:");
            System.out.println();
            System.out.println("Enter your choice: ");
            if(sc.hasNextInt())
            {
                choice = sc.nextInt();
            }
            else {
                sc.next();
                System.out.println("Please enter a number");
                continue;
            }
            switch(choice)
            {
                case 1:
                    account1.displayAccountDetails();
                    break;

                case 2:
                    System.out.println("Enter amount: ");
                    double deposit = 0.0;
                    while(deposit<=0.0)
                    {
                        if(sc.hasNextDouble())
                        {
                            deposit = sc.nextDouble();
                            if(deposit<=0.0)
                            {
                                System.out.println("Please enter a valid Deposit number: ");
                                System.out.println("Enter amount: ");
                            }
                        }
                        else
                        {
                            sc.next();
                            System.out.println("Please enter Deposit as a number: ");
                            System.out.println("Enter amount: ");
                        }
                    }
                    account1.deposit(deposit);
                    break;

                case 3:
                    System.out.println("Enter amount: ");
                    double withdraw = 0.0;
                    while(withdraw <= 0.0 || account1.getBalance()<withdraw)
                    {
                        if(sc.hasNextDouble())
                        {
                            withdraw = sc.nextDouble();
                            if(withdraw<=0.0)
                            {
                                System.out.println("Please enter a valid withdraw amount: ");
                                System.out.println("Enter amount: ");
                            }
                            if(account1.getBalance()<withdraw)
                            {
                                System.out.println("Please enter a withdraw amount lesser than balance: ");
                                System.out.println("enter amount: ");
                            }
                        }
                        else
                        {
                            sc.next();
                            System.out.println("Please enter a Integer value as an withdraw amount: ");
                            System.out.println("Enter amount: ");
                        }
                    }
                    account1.withdraw(withdraw);
                    break;

                case 4:
                    System.out.println("Balance: "+account1.getBalance());
                    break;

                case 5:
                    account1.transactionDisplay();
                    break;

                case 6:
                    System.out.println("Thanks for using our Service");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
        while(choice!=6);
    }
}