package LAB2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Names {
    private List<String> names;
    private Random random;

    public String chose() {
        if (this.names.isEmpty()) {
            System.out.println("The list is empty");
            return null;
        }

        int randomNIndex = random.nextInt(this.names.size());
        return this.names.remove(randomNIndex);
    }

    public List<String> getNames() {
        return this.names;
    }

    Names(List<String> names) {
        this.names = new ArrayList<>(names);
        this.random = new Random();
    }

    public static void main(String[] args) {
        List<String> initialNames = List.of("Kowalski", "Nowak", "Wiśniewski", "Dąbrowski", "Lewandowski", "Daniluk",
                "Chrapowicz", "Gogacz", "Brzozowski", "Cross", "Borowski");
        Names names = new Names(initialNames);

        String temp = "";
        do {
            System.out.println(names.getNames());
            System.out.println(temp);
            System.out.println(" - - - - - ");
        } while ((temp = names.chose()) != null);
    }
}
