package segundosParciales;

import java.util.*;
import java.util.function.Function;

public class KeyMultiplierMapImpl<E> extends TreeMap<Integer, E> implements KeyMultiplierMap<E> {
    public KeyMultiplierMapImpl(){
        super(Comparator.reverseOrder());
    }

    @Override
    public <T> List<T> convert(Function<E, T> function) {
        List<T> returnList = new ArrayList<>();
        for(Integer key : keySet()){
            if( key > 0){
                for(int i=0; i < key; i++){
                    returnList.add(function.apply(get(key)));
                }
            }
        }
        return returnList;
    }
}
