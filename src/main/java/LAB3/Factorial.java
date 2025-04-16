package LAB3;

public class Factorial {
    public static int factorial(int x) {
        if (x < 0) { throw new IllegalArgumentException("x < 0"); }
        if (x == 0) { return 1; }
        return x == 1 ? 1 : x * factorial(x - 1);
    }

    public static int factorial1(int x) throws MyException {
        if (x < 0) { throw new MyException("x < 0"); }
        if (x == 0) { return 1; }
        return x == 1 ? 1 : x * factorial(x - 1);
    }
}
