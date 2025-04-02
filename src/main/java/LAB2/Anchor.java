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

    @Override
    public String toString() {
        String ret = "";
        if (this.first != null) {
            Element current = this.first;

            do {
                ret += current.getVal() + " -> ";
                current = current.getNext();
            }
            while (current != null);
        }
        ret += "null";
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (this == o) { return true; }
        if (this.getClass() != o.getClass()) { return false; }

        Element thisCurr = this.first;
        Element oCurr = ((Anchor) o).first;

        while (thisCurr.getNext() != null) {
            if (oCurr == null) { return false; }

            thisCurr = thisCurr.getNext();
            oCurr = oCurr.getNext();
        }

        current.setNext(null);
        return next;

        return true;
    }

    @Override
    public Anchor clone() {
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
        link.insertAtTheFront(3);
        link.insertAtTheFront(4);
        link.insertAtTheFront(5);
        link.insertAtTheEnd(6);

        link.removeLast();
        link.removeLast();
        link.removeLast();
        System.out.println(link);

        Element l1 = new Element(4);
        Element l2 = null;
        System.out.println(l1.equals(l2));
    }
}
