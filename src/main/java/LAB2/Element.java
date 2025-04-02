package LAB2;

public class Element {
    private int val;
    private Element next;

    public int getVal() {
        return val;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public Element(int val) {
        this.val = val;
        this.next = null;
    }
}
