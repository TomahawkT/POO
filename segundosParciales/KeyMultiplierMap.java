package segundosParciales;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface KeyMultiplierMap<E> extends Map<Integer, E>{
    <T> List<T> convert(Function<E,T> function);
}
