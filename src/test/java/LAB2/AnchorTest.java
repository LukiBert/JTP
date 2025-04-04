package LAB2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnchorTest {

    @Test
    void testRemoveFirst1() {
        Anchor link = new Anchor();
        link.insertAtTheFront(1);
        link.insertAtTheFront(2);
        link.insertAtTheFront(3);
        link.insertAtTheFront(4);
        assertEquals(4, link.removeFirst().getVal());
        assert(link.getFirst().getVal() != 4);
    }

    @Test
    void testRemoveFirst2() {
        Anchor link = new Anchor();
        link.insertAtTheFront(1);
        link.removeFirst();
        assertNull(link.getFirst());
    }

    @Test
    void testRemoveLast1() {
        Anchor link = new Anchor();
        link.insertAtTheFront(1);
        link.removeLast();
        assertNull(link.getFirst());
    }

    @Test
    void testRemoveLast2() {
        Anchor link = new Anchor();
        link.insertAtTheFront(1);
        link.insertAtTheFront(2);
        link.insertAtTheFront(3);
        assertEquals(1, link.removeLast().getVal());
    }

    @Test
    void testInsertAtTheFront1() {
        Anchor link = new Anchor();
        link.insertAtTheFront(1);
        link.insertAtTheFront(2);
        link.insertAtTheFront(3);
        link.insertAtTheFront(4);
        assertEquals(4, link.getFirst().getVal());
    }

    @Test
    void testInsertAtTheFront2() {
        Anchor link = new Anchor();
        link.insertAtTheFront(1);
        assertEquals(1, link.getFirst().getVal());
    }

    @Test
    void testInsertAtTheEnd1() {
        Anchor link = new Anchor();
        link.insertAtTheEnd(1);
        link.insertAtTheEnd(2);
        link.insertAtTheEnd(3);
        link.insertAtTheEnd(4);
        assertEquals(4, link.removeLast().getVal());
    }

    @Test
    void testInsertAtTheEnd2() {
        Anchor link = new Anchor();
        link.insertAtTheEnd(1);
        assertEquals(1, link.removeLast().getVal());
    }

    @Test
    void testEquals1() {
        Anchor link = new Anchor();
        link.insertAtTheFront(1);
        link.insertAtTheFront(2);
        Anchor link2 = new Anchor();
        link2.insertAtTheFront(1);
        link2.insertAtTheFront(2);
        assertTrue(link.equals(link2));
    }

    @Test
    void testEquals2() {
        Anchor link = new Anchor();
        Anchor link2 = new Anchor();
        assertTrue(link.equals(link2));
    }

    @Test
    void testClone1() {
        Anchor link = new Anchor();
        link.insertAtTheFront(1);
        link.insertAtTheFront(2);
        link.insertAtTheFront(3);

        Anchor link2 = link.clone();
        assertEquals(link, link2);
    }

    @Test
    void testClone2() {
        Anchor link = new Anchor();
        Anchor link2 = link.clone();
        assertEquals(link, link2);
    }

    @Test
    void testRevert1() {
        Anchor link = new Anchor();
        link.insertAtTheFront(1);
        link.insertAtTheFront(2);
        link.insertAtTheFront(3);
        link.insertAtTheFront(4);

        Anchor link2 = link.clone();
        link.revert();
        link.revert();
        assertEquals(link2, link);
    }

    @Test
    void testRevert2() {
        Anchor link = new Anchor();
        link.insertAtTheFront(1);
        link.insertAtTheFront(2);
        link.insertAtTheFront(3);
        link.insertAtTheFront(4);
        Anchor link2 = new Anchor();
        link2.insertAtTheEnd(1);
        link2.insertAtTheEnd(2);
        link2.insertAtTheEnd(3);
        link2.insertAtTheEnd(4);
        link.revert();
        assertEquals(link2, link);
    }
}