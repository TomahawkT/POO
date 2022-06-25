package TP7;

public class PremiumBankAccountMovement extends BankAccountMovement{
    private String shopName;

    public PremiumBankAccountMovement(BankAccountMovementType type, double balance, String shopName) {
        super(type, balance);
        this.shopName = shopName;
    }

    @Override
    public String toString(){
        return String.format("%s for shop %s", super.toString(), shopName);
    }
}
