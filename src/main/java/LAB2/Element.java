package LAB2;

import java.util.concurrent.ExecutionException;

public class Element {
    private int val;
    private Element next;

    public int getVal() {
        return val;
    }

    public Element getNext() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) { return false; }

        Element eO = (Element) o;

        return this.val == eO.val;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public Element(int val) {
        this.val = val;
        this.next = null;
    }
}
