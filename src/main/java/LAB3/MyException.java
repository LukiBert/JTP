package LAB3;

public class MyException extends Exception {
    public MyException(String message) {
        super(message);
        printStackTrace();
    }
}
