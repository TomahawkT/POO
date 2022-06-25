package TP7;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {

    protected int id;
    private List<BankAccountMovement> movements;
    protected double balance;

    protected BankAccount(int id) {
        this.id = id;
        this.movements = new ArrayList<>();
    }

    public double deposit(double amount) {
        movements.add(new BankAccountMovement(BankAccountMovementType.DEPOSIT, amount));
        return balance += amount;
    }

    public double extract(double amount) {
        return extract(new BankAccountMovement(BankAccountMovementType.EXTRACTION, -amount));
    }

    protected double extract(BankAccountMovement movement) {
        if(!canExtract(movement.getBalance())) {
            throw new IllegalArgumentException("No cuenta con los fondos necesarios");
        }
        movements.add(movement);
        return balance -= movement.getBalance();
    }

    abstract protected boolean canExtract(double amount);

    @Override
    public String toString() {
        return String.format("Cuenta %d con saldo %.1f", id, balance);

    }

    public void showMovements() {
        System.out.println("Movements for Account " + id);
        for(BankAccountMovement bankAccountMovement : movements) {
            System.out.println(bankAccountMovement);
        }
    }

}

