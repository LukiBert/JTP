package LAB5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {
    @Test
    public void testConnectedWith1() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        v1.addEdge(v2);

        assertTrue(v1.connectedWith(v2));
        assertFalse(v2.connectedWith(v1));
    }

    @Test
    public void testConnectedWith2() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);

        v1.addEdge(v2);
        v2.addEdge(v3);

        assertTrue(v1.connectedWith(v3));
    }

    @Test
    public void testConnectedWith3() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);

        assertFalse(v1.connectedWith(v2));
    }

    @Test
    public void testMaximalConnected1() {
        Vertex v1 = new Vertex(10);

        assertEquals(10, v1.maximalConnected().getLabel());
    }

    @Test
    public void testMaximalConnected2() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(5);
        Vertex v3 = new Vertex(3);

        v1.addEdge(v2);
        v2.addEdge(v3);

        assertEquals(5, v1.maximalConnected().getLabel());
    }

    @Test
    public void testMaximalConnected3() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(10);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(7);

        v1.addEdge(v2);
        v1.addEdge(v3);
        v3.addEdge(v4);

        assertEquals(10, v1.maximalConnected().getLabel());
    }
}