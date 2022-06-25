package primerosParciales;

public enum ClubType {
    CLUB_1000(1000,950,0,0),
    CLUB_2000(2000,1750,1000,2),
    CLUB_5000(5000,4400,2500,5),
    CLUB_10000(10000,14400,10000,6);
    private final int miles, promotionMiles, promotionLength;
    private final double cost;

    ClubType(int miles, double cost, int promotionMiles, int promotionLength) {
        this.miles = miles;
        this.cost = cost;
        this.promotionMiles = promotionMiles;
        this.promotionLength = promotionLength;
    }
    public int getTotalMiles(int month){
        if (month <= promotionLength){
            return miles + promotionMiles;
        }
        return miles;
    }

    public double getCost() {
        return cost;
    }
}
