package primerosParciales;

public class Pizza {
    private final PizzaType type;
    private final Toppings[] toppings;

    public Pizza(PizzaType type, Toppings[] toppings) {
        this.type = type;
        this.toppings = toppings;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Pizza ").append(type.getDescription());
        double totalPrice = type.getPrice();
        for (Toppings topping:toppings) {
            stringBuilder.append(String.format(" con %s", topping));
            totalPrice += topping.getPrice();
        }
        stringBuilder.append(": ").append("$").append(String.format("%.2f", totalPrice));
        return stringBuilder.toString();
    }
}
