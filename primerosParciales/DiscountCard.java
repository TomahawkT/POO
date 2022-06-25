package primerosParciales;

public abstract class DiscountCard {
    private SaraCenter center;
    private final String name;
    private double totalSpent;
    public void buyProduct(Product product){
        totalSpent += checkPrice(product);
    }
    public DiscountCard(SaraCenter center,String name) {
        this.center = center;
        this.name = name;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public double checkPrice(Product product) {
        return product.getPrice() * (1 - getDiscount());
    }
    public abstract double getDiscount();
    @Override
    public String toString(){
        return String.format("Card %s of %s spent %.2f", name, center, totalSpent);
    }
    protected SaraCenter getCenter(){
        return center;
    }
}
