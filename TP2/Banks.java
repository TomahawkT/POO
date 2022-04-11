package TP2;

import java.awt.image.BaseMultiResolutionImage;

public class Banks {
    public static void main(String[] args){

    }

    public abstract class BankAccount{
        private final int id;
        protected double balance = 0;

        protected BankAccount(int id){
            this.id = id;
        }
        public void deposit(double amount){
            balance += amount;
        }
        public void withdraw(double amount){
            if (canExtract(amount)){
                balance -= amount;
            }
        }
        protected abstract boolean canExtract(double amount);

        public double getBalance() {
            return balance;
        }

        @Override
        public String toString() {
            return String.format("Cuenta %d con saldo %.2f", id, balance);
        }
    }

    public class CheckingAccount extends BankAccount{

        private final double overdraft;

        public CheckingAccount(int id, double overdraft){
            super(id);
            this.overdraft = overdraft;
        }
        @Override
        protected boolean canExtract(double amount) {
            return balance - amount + overdraft >= 0;
        }
        public double getOverdraft(){
            return overdraft;
        }
    }

    public class SavingsAccount extends BankAccount{

        public SavingsAccount(int id){
            super(id);
        }

        @Override
        protected boolean canExtract(double amount) {
            return balance - amount >= 0;
        }
    }
}
