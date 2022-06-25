package primerosParciales;

public class MemberDiscountCard extends DiscountCard{
    private double points;
    public static final double POINTS_PERCENTAGE = 0.5;

    public MemberDiscountCard(SaraCenter center, String name) {
        super(center, name);
    }
    @Override
    public double getDiscount() {
        return getCenter().getMemberDiscount();
    }
    @Override
    public String toString(){
        return "Member" + super.toString();
    }
    @Override
    public double checkPrice(Product product){
        double originalPrice = product.getPrice();
        if (originalPrice <= points){
            return 0;
        }
        return super.checkPrice(product);
    }
    @Override
    public void buyProduct(Product product){
        double originalPrice = product.getPrice();
        if (originalPrice <= points){
            points -= product.getPrice();
            return;
        }
        super.buyProduct(product);
        points += originalPrice * POINTS_PERCENTAGE;
    }

}
