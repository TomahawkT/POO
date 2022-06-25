package segundosParciales;

import com.sun.source.tree.Tree;

import java.util.*;

public class TravelGuide {
    private final Map<String, Map<String, TreeSet<Landmark>>> landmarkMap = new TreeMap<>();

    public void addLandmark(String country, String city, Landmark landmark){
        landmarkMap.putIfAbsent(country, new TreeMap<>());
        landmarkMap.get(country).putIfAbsent(city,new TreeSet<>());
        landmarkMap.get(country).get(city).add(landmark);
    }

    public int landmarksCount(String country){
        int total = 0;
        for(String key : landmarkMap.getOrDefault(country, new TreeMap<>()).keySet()){
            total += landmarksCount(country, key);
        }
        return total;
    }

    public int landmarksCount(String country, String city){
        int total = 0;
        if (!landmarkMap.containsKey(country) || !landmarkMap.get(country).containsKey(city)){
            return total;
        }
        return landmarkMap.get(country).get(city).size();
    }

    public Collection<Landmark> getLandmarksFromCity(String country, String city){
        return landmarkMap.getOrDefault(country, new TreeMap<>()).getOrDefault(city, new TreeSet<>());
    }

    public Collection<Landmark> getLandmarksFromCountry(String country){
        List<Landmark> returnSet = new ArrayList<>();
        for (String city : landmarkMap.getOrDefault(country, new TreeMap<>()).keySet()){
            returnSet.addAll(getLandmarksFromCity(country, city));
        }
        return returnSet;
    }

    public void moveLandmark(String country, String originCity, String destinyCity, Landmark landmark){
        if(!landmarkMap.containsKey(country)){
            throw new TravelGuideException("Country does not exist");
        }
        if(!landmarkMap.get(country).containsKey(originCity)){
            throw new TravelGuideException("Origin city does not exist in country");
        }
        if (!landmarkMap.get(country).get(originCity).contains(landmark)){
            throw new TravelGuideException("Landmark does not exist in origin city");
        }
        landmarkMap.get(country).get(originCity).remove(landmark);
        addLandmark(country, destinyCity, landmark);
    }
}
