package primerosParciales;

import java.util.Arrays;
import java.util.Comparator;

public class Inventory {
    private final Item[] items;

    public Inventory(Item[] items) {
        this.items = items;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        for(int i=0; i < items.length; i++){
            stringBuilder.append(items[i].toString());
            if (i < items.length-1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public Item[] getItems(Comparator<Item> comparable){
        Item[] toReturn = Arrays.copyOf(items, items.length);
        Arrays.sort(toReturn, comparable);
        return toReturn;
    }

    public Item[] getItems(){
        return getItems(Comparator.naturalOrder());
    }

}
