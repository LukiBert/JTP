package LAB2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NamesTest {

    @Test
    void testChose1() {
        List<String> initialNames = List.of("Kowalski", "Nowak", "Wiśniewski", "Dąbrowski", "Lewandowski",
                "Daniluk", "Chrapowicz", "Gogacz", "Brzozowski", "Cross", "Borowski");
        Names names = new Names(initialNames);

        assertEquals(initialNames, names.getNames());
    }

    @Test
    void testChose2() {
        List<String> initialNames = List.of("Kowalski", "Nowak", "Wiśniewski", "Dąbrowski", "Lewandowski",
                "Daniluk", "Chrapowicz", "Gogacz", "Brzozowski", "Cross", "Borowski");
        Names names = new Names(initialNames);

        String temp = "";
        while ((temp = names.chose()) != null);

        assert(names.getNames().isEmpty());
    }

    @Test
    void testChose3() {
        List<String> initialNames = List.of("Kowalski", "Dąbrowski", "Lewandowski", "Daniluk", "Chrapowicz", "Gogacz",
                "Brzozowski", "Cross", "Borowski" );
        Names names = new Names(initialNames);
        String chosen = names.chose();
        assert(!names.getNames().contains(chosen));
    }
}