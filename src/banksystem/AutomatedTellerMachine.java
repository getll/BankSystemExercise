package banksystem;

import java.util.Scanner;

/**
 *
 * @author Denmar Ermitano
 */
public class AutomatedTellerMachine {
    private String atmID;
    private User user;
    private Account account;
    private static int nextID = 1;

    /**
     * Default constructor
     */
    public AutomatedTellerMachine() {
        this.atmID = String.format("%06d", nextID++);
        this.user = null;
        this.account = null;
    }

    /**
     * Constructor with the id of the atm
     * @param atmID the id of the atm
     */
    public AutomatedTellerMachine(String atmID) {
        this.atmID = atmID;
        this.user = null;
        this.account = null;
    }
    
    /**
     * Copy constructor
     * @param automatedTellerMachine the atm to copy
     */
    public AutomatedTellerMachine(AutomatedTellerMachine automatedTellerMachine) {
        this.atmID = automatedTellerMachine.atmID;
        this.user = new User(automatedTellerMachine.user);
        this.account = new Account(automatedTellerMachine.account);
    }
    
    /**
     * The pipeline of the atm, it is called when someone wants to use it
     */
    public void pipeline() {
        printWelcome();
        readUserId();
        
        if (user == null)
            System.exit(1);
        if (!inputPin())
            System.exit(2);
        
        chooseAccount();
        
        //loop for account operations, asks at the end if they want to do another
        do {
            int oper = chooseOperation();
            
            switch (oper) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                default:
                    displayBalance();
            }
        } while(doesContinue());
        
        printGoodBye();
    }
    
    /**
     * To print a welcome message
     */
    public void printWelcome() {
        System.out.println("Welcome to our ATM!");
    }
    
    /**
     * To ask the user to enter their user id.
     * if it does not exist, the process is shut down
     */
    public void readUserId() {
        Scanner console = new Scanner(System.in);
        
        System.out.println("Please enter your user ID: ");
        String inputId = console.next();
        
        for (int i = 0; i < Bank.getUsers().size(); i++)
            if (inputId.equals(Bank.getUsers().get(i).getUserId())) {
                user = Bank.getUsers().get(i);
                return;
            }
        
        user = null;
    }
    
    /**
     * To ask the pin from the user, with a maximum of 3 times. else, the process
     * will be shut down.
     * @return true if the pin is correct, false if the pin is incorrect 3 times
     */
    public boolean inputPin() {
        Scanner console = new Scanner(System.in);
        int maxTry = 3;
        
        for (int i = 0; i < maxTry; i++){
            System.out.println("Please enter your pin: ");
            String pin = console.next();
            
            if (user.getPin().equals(pin))
                return true;
            else
                System.out.println("Your pin is wrong");
        }
        
        System.out.println("You input the wrong pin 3 times");
        return false;
    }
    
    /**
     * To ask the user which account they want to use, either
     * 1. checking account
     * 2. saving account
     */
    public void chooseAccount() {
        Scanner console = new Scanner(System.in);
        
        System.out.println("Please choose the account you want to operate with"
                + "\n\t1. Checking account"
                + "\n\t2. Saving account");
        
        int accountChoice = console.nextInt();
        
        account = (accountChoice == 1) ? user.getCheckingAccount() : user.getSavingAccount();
    }
    
    /**
     * To ask the user what operation they want to do, either
     * 1. withdraw
     * 2. deposit
     * 3. display balance
     * @return the operation they want to do
     */
    public int chooseOperation() {
        Scanner console = new Scanner(System.in);
        
        System.out.println("Please choose the operation"
                + "\n\t1. Withdraw"
                + "\n\t2. Deposit"
                + "\n\t3. Display balance");
        
        int operation = console.nextInt();
        
        return operation;
    }
    
    /**
     * To withdraw from the atm
     * @return true if the withdraw is successful, false if the withdraw failed
     */
    public boolean withdraw() {
        Scanner console = new Scanner(System.in);
        
        System.out.println("How much do you want to withdraw? ");
        double amount = console.nextDouble();
        
        if (account.getBalance() < amount) {
            System.out.println("Sorry, you don't have enough in your balance.");
            return false;
        }
        
        account.setBalance(account.getBalance() - amount);
        System.out.println("Withdraw successful.");
        user.getHistory().add(new Record("withdraw", amount, atmID));
        return true;
    }
    
    /**
     * To deposit into the atm
     * @return true if the deposit is successful, false if the deposit failed
     * (it can't really fail, since you add into the account)
     */
    public boolean deposit() {
        Scanner console = new Scanner(System.in);
        
        System.out.println("How much do you want to deposit? ");
        double amount = console.nextDouble();

        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposit successful.");
        user.getHistory().add(new Record("deposit", amount, atmID));
        return true;
    }
    
    /**
     * To display the balance of the account
     */
    public void displayBalance() {
        System.out.printf("Your current balance is $%.2f\n", account.getBalance());
    } 
    
    /**
     * To ask the user if they want to do another operation
     * @return true if the user wants to do another operation, false if they want to stop
     */
    public boolean doesContinue() {
        Scanner console = new Scanner(System.in);
        
        System.out.println("Do you want to do another operation? ");
        System.out.println("0. No");
        System.out.println("1. Yes");
        int answer = console.nextInt(); //assume they can only input 0 or 1
        
        return answer == 1;
    }
    
    /**
     * To print a goodbye message
     */
    public void printGoodBye() {
        System.out.println("Thank you for using our ATM. Goodbye");
    }
    
    /**
     * To compare two atms
     * @param automatedTellerMachine the atm to compare
     * @return true if both atms are the same, false if they are different
     */
    public boolean equals(AutomatedTellerMachine automatedTellerMachine) {
        return this.atmID.equals(automatedTellerMachine.atmID);
    }

    /**
     * To generate a string to represent the atm
     * @return the string representing the atm
     */
    @Override
    public String toString() {
        return String.format("%-10s: %s", "ATM ID", atmID);
    }

    public String getAtmID() {
        return atmID;
    }

    public void setAtmID(String atmID) {
        this.atmID = atmID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        AutomatedTellerMachine.nextID = nextID;
    }
}

