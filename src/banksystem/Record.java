package banksystem;

import java.util.Date;

/**
 *
 * @author Denmar Ermitano
 */
public class Record {
    private String operation;
    private double amount;
    private Date date;
    private String atmId;

    /**
     * Default constructor
     */
    public Record() {
        this.operation = null;
        this.amount = 0;
        this.date = null;
        this.atmId = null;
    }
    
    /**
     * Constructor with all data members (excluding date)
     * @param operation the operation that happened
     * @param amount the amount transferred
     * @param atmId the id of the atm
     */
    public Record(String operation, double amount, String atmId) {
        this.operation = operation;
        this.amount = amount;
        this.date = new Date();
        this.atmId = atmId;
    }
    
    /**
     * Copy constructor
     * @param record the record to copy
     */
    public Record(Record record) {
        this.operation = record.operation;
        this.amount = record.amount;
        this.date = record.date;
        this.atmId = record.atmId;
    }
    
    /**
     * To compare two records
     * @param record the record to copy
     * @return true if the records are the same, false if they are different
     */
    public boolean equals(Record record) {
        return this.operation.equals(record.operation) &&
                this.amount == record.amount &&
                this.date.equals(record.date) &&
                this.atmId.equals(record.atmId);
    }

    /**
     * To generate a string to represent the record
     * @return the string representing the record
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-10s: %s\n", "Operation", operation);
        str += String.format("%-10s: $%.2f\n", "Amount", amount);
        str += String.format("%-10s: %s\n", "Date", date);
        str += String.format("%-10s: %s\n", "ATM ID", atmId);
        
        return str;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }
}
