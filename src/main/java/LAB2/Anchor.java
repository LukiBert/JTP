package LAB2;

public class Anchor {
    private Element first;

    public void insertAtTheFront(int x) {
        if (this.first == null) {
            this.first = new Element(x);
        } else {
            Element oldHead = this.first;
            this.first = new Element(x);
            this.first.setNext(oldHead);
        }
    }

    public void insertAtTheEnd(int x) {
        if (this.first == null) {
            this.first = new Element(x);
        } else {
            Element current = this.first;

            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(new Element(x));
        }
    }

    public Element removeFirst() {
        if (this.first == null) {
            return null;
        } else {
            Element oldHead = this.first;
            this.first = this.first.getNext();
            return oldHead;
        }
    }

    public Element removeLast() {
        if (this.first == null) {
            return null;
        } else if (this.first.getNext() == null) {
            Element oldHead = this.first;
            this.first = null;
            return oldHead;
        } else {
            Element current = this.first;
            Element next = current.getNext();

            while (next.getNext() != null) {
                current = next;
                next = next.getNext();
            }

            current.setNext(null);
            return next;
        }
    }

    public void revert() {

    }

    public boolean hasLoop() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (this.first != null) {
            Element current = this.first;

            do {
                ret.append(current.getVal()).append(" -> ");
                current = current.getNext();
            }
            while (current != null);
        }
        ret.append("null");
        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) { return false; }

        Element currO = ((Anchor) o).first;
        Element currThis = this.first;

        if (currThis == null) {
            if (currO == null) { return true; }
        } else {
            if (currO == null) { return false; }

            while (currThis.getNext() != null && currO.getNext() != null) {
                if (currThis.getVal() != currO.getVal()) { return false; }

                currThis = currThis.getNext();
                currO = currO.getNext();
            }

            if (currThis.getNext() == null && currO.getNext() == null) {
                return currThis.getVal() == currO.getVal();
            }
        }

        return false;
    }

    @Override
    public Anchor clone() {
        //super.clone();
        Anchor a = new Anchor();
        a.first = this.first;
        return a;
    }

    public Anchor() {
        this.first = null;
    }

    public static void main(String[] args) {
        Anchor link = new Anchor();
        link.insertAtTheFront(1);
        link.insertAtTheFront(2);
        Anchor link2 = new Anchor();
        link2.insertAtTheFront(1);
        link2.insertAtTheFront(2);
        System.out.println(link.equals(link2));
    }
}
