package models;

public class Transaction {
    public String name;
    public double amount;

    public Transaction(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() { return name + ": $" + amount; }
}
