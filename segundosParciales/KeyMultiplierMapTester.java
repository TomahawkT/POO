package segundosParciales;

import java.util.List;
import java.util.function.Function;

public class KeyMultiplierMapTester {
    public static void main(String[] args) {
        // Un mapa donde la clave es un entero y el valor es un String
        KeyMultiplierMap<String> keyMultMap1 = new KeyMultiplierMapImpl<>();
        keyMultMap1.put(1, "Uno");
        keyMultMap1.put(4, "Cuatro");
        keyMultMap1.put(2, "Dos");
        System.out.println(keyMultMap1.isEmpty()); // Imprime false
        System.out.println(keyMultMap1.size()); // Imprime 3
        System.out.println(keyMultMap1.containsKey(1)); // Imprime true
        System.out.println(keyMultMap1.containsValue("Tres")); // Imprime false
        System.out.println("-----");
        // Se obtiene una lista donde cada valor del mapa
        // aparece "clave" veces, en orden descendente por las claves
        List<String> list1 = keyMultMap1.convert(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        });
        for (String e : list1) {
            System.out.println(e);
        }
        System.out.println("-----");
        // Se obtiene una lista donde cada valor del mapa, pasado a mayúsculas,
        // aparece "clave" veces, en orden descendente por las claves
        List<String> list2 = keyMultMap1.convert(s -> s.toUpperCase());
        for (String e : list2) {
            System.out.println(e);
        }
        System.out.println("-----");
        // Se obtiene una lista donde cada valor del mapa, convertido a StringContainer,
        // aparece "clave" veces, en orden descendente por las claves
        List<StringContainer> list3 = keyMultMap1.convert(s -> new StringContainer(s));
        for (StringContainer e : list3) {
            System.out.println(e);
        }
        System.out.println("-----");
        // Un mapa donde la clave es un entero y el valor es un Double
        KeyMultiplierMap<Double> keyMultMap2 = new KeyMultiplierMapImpl<>();
        keyMultMap2.put(1, 10.0);
        keyMultMap2.put(2, 20.0);
        // Se obtiene una lista donde cada valor del mapa, multiplicado por 10,
        // aparece "clave" veces, en orden descendente por las claves
        List<Double> list4 = keyMultMap2.convert(d -> d * 10);
        for (Double e : list4) {
            System.out.println(e);
        }
        System.out.println("-----");
        keyMultMap2.put(-3, 50.0);

        // Se obtiene una lista donde cada valor del mapa,
        // aparece "clave" veces, en orden descendente por las claves
        List<Double> list5 = keyMultMap2.convert(d -> d);
        for (Double e : list5) {
            System.out.println(e);
        }
        System.out.println("-----");
    }
    static class StringContainer {
        private final String s;
        public StringContainer(String s) {
            this.s = s;
        }
        @Override
        public String toString() {
            return String.format("StringContainer{%s}", s);
        }
    }
}
