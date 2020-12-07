package banksystem;

/**
 *
 * @author Denmar Ermitano
 */
public class Test {
    public static void main(String[] args) {
        Bank.addUser("Yi", "1234");
//        Bank.addUser("Wang", "2345");
//        Bank.addUser("Mike", "3456");
        
        AutomatedTellerMachine a1 = new AutomatedTellerMachine();
//        AutomatedTellerMachine a2 = new AutomatedTellerMachine();
        
        
        a1.pipeline();
        
        
        
    }
}
