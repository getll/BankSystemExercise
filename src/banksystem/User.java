package banksystem;

import java.util.ArrayList;

/**
 *
 * @author Denmar Ermitano
 */
public class User {
    private String userId;
    private String userName;
    private String pin;
    private Account savingAccount;
    private Account checkingAccount;
    private ArrayList<Record> history;
    private static int nextId = 1;
    
    /**
     * Default constructor
     */
    public User() {
        this.userId = String.format("%06d", nextId++);
        this.userName = null;
        this.pin = null;
        this.savingAccount = null;
        this.checkingAccount = null;
        this.history = null;
    }

    /**
     * Constructor with the name of the user and the pin of the user
     * @param userName the name of the user
     * @param pin the pin of the user
     */
    public User(String userName, String pin) {
        this.userId = String.format("%06d", nextId++);
        this.userName = userName;
        this.pin = pin;
        this.savingAccount = null;
        this.checkingAccount = new Account();
        this.history = new ArrayList<>();
    }
    
    /**
     * Copy constructor
     * @param user the user to copy
     */
    public User(User user) {
        this.userId = user.userId;
        this.userName = user.userName;
        this.pin = user.pin;
        this.savingAccount = new Account(savingAccount);
        this.checkingAccount = new Account(checkingAccount);
        this.history = new ArrayList<>(history);
    }
    
    /**
     * To compare two users
     * @param user the user to compare
     * @return true if the users are the same, false if they are different
     */
    public boolean equals(User user) {
        return this.userId.equals(user.userId) &&
                this.userName.equals(user.userName) &&
                this.pin.equals(user.pin) &&
                this.savingAccount.equals(user.savingAccount) &&
                this.checkingAccount.equals(user.checkingAccount) &&
                this.history.equals(user.history);
    }
    
    /**
     * To generate a string to represent the user
     * @return the string representing the user
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-20s: %s\n", "User ID", userId);
        str += String.format("%-20s: %s\n", "User Name", userName);
        str += String.format("%-20s: %s\n", "Saving Account", savingAccount);
        str += String.format("%-20s: %s\n", "Checking Account", checkingAccount);
        str += String.format("%-20s: %s\n", "History", history);
        
        return str;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Account getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(Account savingAccount) {
        this.savingAccount = savingAccount;
    }

    public Account getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(Account checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public ArrayList<Record> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Record> history) {
        this.history = history;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        User.nextId = nextId;
    }
}
