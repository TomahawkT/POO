package segundosParciales;

public enum ProductCategory {
    GROCERY(5,1.25),
    BOOKS(30,0),
    ELECTRONICS(80,1.10);

    private final int basePoints;
    private final double multiplier;

    ProductCategory(int basePoints, double multiplier){
        this.basePoints = basePoints;
        this.multiplier = multiplier;
    }

    public double totalPoints(double price){
        return basePoints + price * multiplier;
    }
}
