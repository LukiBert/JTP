package LAB2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequentNames {
    private Map<String, Integer> frequentNames;

    public void insert(String name) {
        if (this.frequentNames.containsKey(name)) {
            this.frequentNames.put(name, this.frequentNames.get(name) + 1);
        } else {
            this.frequentNames.put(name, 1);
        }
    }

    public String choose() {
        if (this.frequentNames.isEmpty()) { return null; }

        String mostFrequentName = null;
        int max = 0;

        for (Map.Entry<String, Integer> entry : this.frequentNames.entrySet()) {
            if (entry.getValue() > max) {
                mostFrequentName = entry.getKey();
                max = entry.getValue();
            }
        }

        if (mostFrequentName != null) {
            if (this.frequentNames.get(mostFrequentName) == 1) {
                this.frequentNames.remove(mostFrequentName);
            } else {
                this.frequentNames.put(mostFrequentName, frequentNames.get(mostFrequentName) - 1);
            }
        }

        return mostFrequentName;
    }

    public boolean isEmpty() {
        return this.frequentNames.isEmpty();
    }

    public Map<String, Integer> getFrequentNames() {
        return this.frequentNames;
    }

    @Override
    public String toString() {
        return this.frequentNames.toString();
    }

    FrequentNames() {
        this.frequentNames = new HashMap<String, Integer>();
    }

    public static void main(String[] args) {
        List<String> initialNames = List.of("Kowalski", "Nowak", "Wiśniewski", "Dąbrowski", "Lewandowski",
                "Daniluk", "Chrapowicz", "Gogacz", "Brzozowski", "Cross", "Borowski", "Kowalski", "Nowak", "Wiśniewski",
                "Kowalski", "Nowak", "Wiśniewski", "Daniluk");

        FrequentNames freqNames = new FrequentNames();

        for (String name : initialNames) {
            freqNames.insert(name);
        }

        System.out.println(freqNames);

        while (!freqNames.isEmpty()) {
            System.out.println(freqNames);
            System.out.println(freqNames.choose());
        }
    }
}
