package primerosParciales;

import java.util.function.Function;
public class ElementTester {
    public static void main(String[] args) {
        WordSign wordSign = new WordSign("Hola", 3, 2);
        System.out.println(wordSign); // 3 filas y 2 columnas
        System.out.println("----------");
        CustomWordSign upperWordSign = wordSign.custom(new Function<String, String>(){
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        });
        System.out.println(upperWordSign); // 3 filas y 2 columnas en Mayusculas
        System.out.println("----------");
        ResizableWordSign twoTimesWordSign = wordSign.resizable(2);
        System.out.println(twoTimesWordSign); // x2 = 6 filas y 4 columnas
        System.out.println("----------");
        ResizableWordSign threeTimesUpperWordSign = upperWordSign.resizable(3);
        System.out.println(threeTimesUpperWordSign); // x3 = 9 filas y 6 columnas en Mayusculas
        System.out.println("----------");
        // Los WordSign deben permitir cambiar el ancho y alto recibido en el constructor
        wordSign.setHeight(2);
        System.out.println(upperWordSign); // 2 filas y 2 columnas en Mayusculas
        System.out.println("----------");
        System.out.println(twoTimesWordSign); // x2 = 4 filas y 4 columnas
        System.out.println("----------");
    }
}