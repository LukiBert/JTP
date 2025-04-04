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
        Element prev = null;
        Element curr = this.first;
        Element next = null;

        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);

            prev = curr;
            curr = next;
        }

        this.first = prev;
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
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) { return false; }

        Anchor anchorO = (Anchor) o;
        Element currO = anchorO.first;
        Element currThis = this.first;

        while (currThis != null && currO != null) {
            if (!currThis.equals(currO)) { return false; }

            currThis = currThis.getNext();
            currO = currO.getNext();
        }

        return currThis == null && currO == null;
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
        link.insertAtTheFront(3);
        link.insertAtTheFront(4);
        Anchor link2 = new Anchor();
        link2.insertAtTheFront(1);
        link2.insertAtTheFront(2);
        System.out.println(link.equals(link2));
        System.out.println(link);
        link.revert();
        System.out.println(link);
    }
}
