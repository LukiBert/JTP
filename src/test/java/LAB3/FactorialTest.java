package LAB3;

import org.junit.jupiter.api.Test;

class FactorialTest {
    @Test
    void testFactorial11() {
            try {
                assert(Factorial.factorial1(0) == 1);
            } catch (Exception _) {  }
    }
    @Test
    void testFactorial12() {
            try {
                assert(Factorial.factorial1(1) == 1);
            } catch (Exception _) {  }
    }
    @Test
    void testFactorial13() {
        try {
            assert(Factorial.factorial1(2) == 2);
        } catch (Exception _) {  }

    }
    @Test
    void testFactorial14() {
        try {
            assert(Factorial.factorial1(3) == 6);
        } catch (Exception _) {  }
    }
    @Test
    void testFactorial15() {
        try {
            assert(Factorial.factorial1(4) == 24);
        } catch (Exception _) {  }
    }
    @Test
    void testFactorial16() {
        try {
            assert(Factorial.factorial1(5) == 120);
        } catch (Exception _) { }
    }
    @Test
    void testFactorial17() {
        try {
            Factorial.factorial1(-3);
        } catch (Exception x) {
            assert(x instanceof MyException);
        }
    }
    @Test
    void testFactorial18() {
        try {
            Factorial.factorial1(-2);
        } catch (Exception x) {
            assert(x instanceof MyException);
        }
    }
    @Test
    void testFactorial19() {
        try {
            Factorial.factorial1(-1);
        } catch (Exception x) {
            assert(x instanceof MyException);
        }
    }
}