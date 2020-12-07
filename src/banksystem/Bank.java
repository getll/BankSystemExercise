package banksystem;

import java.util.ArrayList;

/**
 *
 * @author Denmar Ermitano
 */
public class Bank {
    private static ArrayList<AutomatedTellerMachine> atms = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    
    /**
     * To add a new user to the user array list
     * @param userName the name of the user
     * @param pin the pin of the user
     */
    public static void addUser(String userName, String pin) {
        users.add(new User(userName, pin));
    }

    public static ArrayList<User> getUsers() { //I think this is a getter? so no documentation
        return users;
    }
}

