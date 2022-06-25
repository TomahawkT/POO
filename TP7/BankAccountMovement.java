package TP7;

public class BankAccountMovement {
    private BankAccountMovementType type;
    private double balance;

    public BankAccountMovement(BankAccountMovementType type, double balance) {
        this.type = type;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString(){
        return String.format("%s $%.2f", type.getDescription(), Math.abs(balance));
    }
}
