package segundosParciales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;
import java.util.Map;


public class SimpleArrayList<E> extends ArrayList<E> implements SimpleList<E> {

    @Override
    public <K> Map<K, E> toMap(Function<E, K> function) {
        Map<K,E> returnMap = new HashMap<>();
        for(E elem : this){
            returnMap.putIfAbsent(function.apply(elem), elem);
        }
        return returnMap;
    }
}
