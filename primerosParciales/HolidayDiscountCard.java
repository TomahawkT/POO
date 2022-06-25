package primerosParciales;

public class HolidayDiscountCard extends DiscountCard{

    public HolidayDiscountCard(SaraCenter center, String name) {
        super(center, name);
    }
    @Override
    public double getDiscount() {
        return getCenter().getHolidayDiscount();
    }
    @Override
    public String toString(){
        return "Holiday" + super.toString();
    }
}
