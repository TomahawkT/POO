package primerosParciales;

public class Item implements Comparable<Item>{
    private final String name;
    private final double price;
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Item o) {
        int priceCmp = Double.compare(price, o.price);
        if(priceCmp == 0){
            return name.compareTo(o.name);
        }
        return priceCmp;
    }
    @Override
    public String toString(){
        return String.format("{ %s >> $%.2f }", name, price);
    }
}
