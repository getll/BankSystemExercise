package banksystem;

/**
 *
 * @author Denmar Ermitano
 */
public class Account {
    private char type;
    private double balance;

    /**
     * Default constructor
     */
    public Account() {
        this.type = 'c'; //since checking is the usual wanted account
        this.balance = 0;
    }
    
    /**
     * Constructor with all data members
     * @param type the type of account (checking or saving)
     * @param balance the balance of the account
     */
    public Account(char type, double balance) {
        this.type = type;
        this.balance = balance;
    }
    
    /**
     * Copy constructor
     * @param account the account to copy
     */
    public Account(Account account) {
        this.type = account.type;
        this.balance = account.balance;
    }
    
    /**
     * To compare two accounts
     * @param account the account to compare
     * @return true if the accounts are the same, false if they are different
     */
    public boolean equals(Account account) {
        return this.type == account.type &&
                this.balance == account.balance;
    }

    /**
     * To generate a string to represent the account
     * @return the string representing the account
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-10s: %s\n", "Type", type == 'c' ? "Checking" : "Saving");
        str += String.format("%-10s: $%.2f\n", "Balance", balance);
        
        return str;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

