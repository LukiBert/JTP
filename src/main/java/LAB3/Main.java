package LAB3;

public class Main {
    public static void main(String[] args) throws MyException {
        int[] data = {-3, -2, -1, 0, 1, 2, 3, 4, 5};

        for (int i = 0; i < data.length; i++) {
            try {
                System.out.println(Factorial.factorial1(data[i]));
            } catch (Exception _) { }
        }
    }
}
