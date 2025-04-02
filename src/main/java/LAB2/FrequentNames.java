package LAB2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequentNames {
    private Map<String, Integer> frequentNames;

    public void insert(String name) {
        if (frequentNames.containsKey(name)) {
            frequentNames.put(name, frequentNames.get(name) + 1);
        } else {
            frequentNames.put(name, 1);
        }
    }

    FrequentNames(List<String> frequentNames) {
        this.frequentNames = new HashMap<String, Integer>();
    }

    public static void main(String[] args) {
        List<String> initialNames = List.of("Kowalski", "Nowak", "Wiśniewski", "Dąbrowski", "Lewandowski", "Daniluk",
                "Chrapowicz", "Gogacz", "Brzozowski", "Cross", "Borowski");


    }
}
