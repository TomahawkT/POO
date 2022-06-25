package segundosParciales;

import java.util.*;

public class FreeMarket {
    private Map<String, Double> clientsMap = new HashMap<>();
    private Map<ProductCategory, Map<String, Double>> productsMap = new HashMap<>();

    public void addProduct(String productName, double price, ProductCategory category){
        productsMap.putIfAbsent(category, new TreeMap<>());
        productsMap.get(category).putIfAbsent(productName, price);
    }

    public Iterable<String> getProductsByCategory(ProductCategory category){
        return productsMap.getOrDefault(category, new TreeMap<>()).keySet();
    }

    public void printUserPoints(String clientName){
        if (!clientsMap.containsKey(clientName)){
            throw new IllegalArgumentException(String.format("El usuario %s no existe", clientName));
        }
        System.out.println(String.format("Puntos del usuario %s: %.2f", clientName, clientsMap.get(clientName)));
    }

    public void buyProduct(String clientName, ProductCategory category, String productName){
        if (!productsMap.containsKey(category) || !productsMap.get(category).containsKey(productName)){
            throw new IllegalArgumentException("El producto no existe");
        }
        clientsMap.putIfAbsent(clientName, 0.0);
        double newPoints = category.totalPoints(productsMap.get(category).get(productName));
        clientsMap.merge(clientName, newPoints, Double::sum);
    }
}
