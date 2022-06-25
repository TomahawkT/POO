package primerosParciales;

public enum Toppings {
    EXTRA_QUESO("Extra queso", 20),
    TOMATE("Tomate", 30),
    CEBOLLA("Cebolla", 10);

    private final String description;
    private final double price;

    Toppings(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    @Override
    public String toString(){
        return description;
    }
}
