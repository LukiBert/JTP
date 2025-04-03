package WYK;

public class Playground {
    public void m() {
        try {
            System.out.println("m thorws runtime exception e.");
            if(2==1 + 1) throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("m handles e.");
            throw e;
        } finally {
            System.out.println("m end executes its finally-part.");
        }
        System.out.println("X");
    }

    public void n() {
        try {
            System.out.println("n calls m.");
            this.m();
        } catch (RuntimeException e) {
            System.out.println("n handles e.");
        } finally {
            System.out.println("n executes its finally-part.");
        }
    }

    public static void main(String[] args) {
        Playground p = new Playground();
        p.n();
    }
}
