package firstPackage;

public class DiscountRechargeableSubwayCard extends RechargeableSubwayCard{
    double discount;

    public DiscountRechargeableSubwayCard(SubwayCentral sc, double discount) {
        super(sc);
        this.discount = discount;
    }

    @Override
    protected double rideCost(){
        return getRideCost()/2;
    }
}
