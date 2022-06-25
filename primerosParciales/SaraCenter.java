package primerosParciales;

public class SaraCenter {
    private final String name;
    private double holidayDiscount;
    private double memberDiscount;
    public SaraCenter(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public double getHolidayDiscount() {
        return holidayDiscount;
    }
    public void setHolidayDiscount(double holidayDiscount) {
        this.holidayDiscount = holidayDiscount;
    }
    public double getMemberDiscount() {
        return memberDiscount;
    }
    public void setMemberDiscount(double memberDiscount) {
        this.memberDiscount = memberDiscount;
    }
    public HolidayDiscountCard buildHolidayDiscountCard(String name){
        return new HolidayDiscountCard(this,name);
    }
    public MemberDiscountCard buildMemberDiscountCard(String name){
        return new MemberDiscountCard(this,name);
    }
}
