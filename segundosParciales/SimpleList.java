package segundosParciales;


import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface SimpleList<E> extends List<E> {
    <K> Map<K,E> toMap(Function<E, K> function);
}
