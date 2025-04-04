package LAB2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FrequentNamesTest {

    @Test
    void testInsert1() {
        FrequentNames freqNames = new FrequentNames();

        String name = "Kowalski";
        freqNames.insert(name);

        assert(freqNames.getFrequentNames().containsKey(name));
    }

    @Test
    void testInsert2() {
        List<String> initialNames = List.of("Kowalski", "Nowak", "Wiśniewski", "Dąbrowski", "Lewandowski",
                "Daniluk", "Chrapowicz", "Gogacz", "Brzozowski", "Cross", "Borowski", "Kowalski", "Nowak", "Wiśniewski",
                "Kowalski", "Nowak", "Wiśniewski", "Daniluk");

        FrequentNames freqNames = new FrequentNames();

        for (String name : initialNames) {
            freqNames.insert(name);
        }

        for (String name : initialNames) {
            assert(freqNames.getFrequentNames().containsKey(name));
        }
    }

    @Test
    void testChoose1() {
        FrequentNames freqNames = new FrequentNames();

        String name = "Kowalski";
        freqNames.insert(name);
        freqNames.choose();

        assert(freqNames.isEmpty());
    }

    @Test
    void testChoose2() {
        FrequentNames freqNames = new FrequentNames();

        String name = "Kowalski";
        freqNames.insert(name);
        assert(freqNames.getFrequentNames().containsKey(name));
        freqNames.insert(name);
        assert(freqNames.getFrequentNames().get(name) == 2);
        freqNames.choose();
        assert(freqNames.getFrequentNames().get(name) == 1);
    }

    @Test
    void testChoose3() {
        FrequentNames freqNames = new FrequentNames();
        freqNames.choose();
        assert(freqNames.isEmpty());
    }

    @Test
    void testChoose4() {
        List<String> initialNames = List.of("Kowalski", "Nowak", "Wiśniewski", "Dąbrowski", "Lewandowski",
                "Daniluk", "Chrapowicz", "Gogacz", "Brzozowski", "Cross", "Borowski", "Kowalski", "Nowak", "Wiśniewski",
                "Kowalski", "Nowak", "Wiśniewski", "Daniluk");

        FrequentNames freqNames = new FrequentNames();

        for (String name : initialNames) {
            freqNames.insert(name);
        }

        while (!freqNames.isEmpty()) {
            freqNames.choose();
        }

        assert(freqNames.isEmpty());
    }
}