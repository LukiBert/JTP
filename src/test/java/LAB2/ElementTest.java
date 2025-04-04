package LAB2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    @Test
    void testGetVal1() {
        Element e = new Element(4);
        assertEquals(4, e.getVal());
    }

    @Test
    void testSetNext1() {
        Element e = new Element(4);
        Element next = new Element(3);
        e.setNext(next);
        assert(e.getNext() == next);
    }

    @Test
    void testGetNext1() {
        Element e = new Element(4);
        assertNull(e.getNext());
    }

    @Test
    void testGetNext2() {
        Element e = new Element(4);
        Element next = new Element(3);
        e.setNext(next);
        assertEquals(next, e.getNext());
    }

    @Test
    void testEquals() {
        Element e = new Element(4);
        Element f = new Element(4);
        assertTrue(e.equals(f));
    }
}