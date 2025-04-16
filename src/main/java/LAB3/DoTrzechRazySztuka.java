package LAB3;

import java.util.Scanner;

public class DoTrzechRazySztuka {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int n = 2;

        while (n >= 0) {
            System.out.println("Wprowadź liczbę typu 'float': ");
            try {
                float inputData = Float.parseFloat(scanner.nextLine());
                System.out.println("x = " + inputData);
                n = -1;
            } catch (Exception x) {
                if (n > 0) {
                    System.out.println("Błąd: oczekiwana wartość typu 'float'. Pozostało " + n + " prób.");
                }
                n -= 1;
            }
        }
    }
}
