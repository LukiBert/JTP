package LAB5;

import java.util.*;
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

    @Test
    public void testShortestPath1() {
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        a.addEdge(b);

        List<Vertex> path = a.shortestPath(b);
        assertEquals(List.of(a, b), path);
    }

    @Test
    public void testShortestPath2() {
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);

        List<Vertex> path = a.shortestPath(b);
        assertTrue(path.isEmpty());
    }

    @Test
    public void testShortestPath3() {
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);
        Vertex d = new Vertex(4);

        a.addEdge(b);
        b.addEdge(d);
        a.addEdge(c);
        c.addEdge(d);

        // Długości wszystkich krawędzi są równe 1
        // len(a->b->d) = len(a->c->d) = 2
        List<Vertex> path = a.shortestPath(d);
        // path to lista wierzchołków w ścieżce zatem,
        // zatem jej długość to liczba krawędzi między nimi,
        // czyli n-1
        assertEquals(2, path.toArray().length - 1);
    }

    @Test
    public void testShortestPath4() {
        Vertex a = new Vertex(1);
        List<Vertex> path = a.shortestPath(a);
        assertEquals(0, path.toArray().length - 1);
    }

    @Test
    public void testShortestPath5() {
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);

        a.addEdge(b);
        b.addEdge(c);
        c.addEdge(a);

        List<Vertex> path = a.shortestPath(c);
        assertEquals(2, path.toArray().length - 1);
    }

    @Test
    public void testShortestPath6() {
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);
        Vertex d = new Vertex(4);
        Vertex e = new Vertex(5);

        a.addEdge(b);
        b.addEdge(c);
        c.addEdge(d);
        d.addEdge(e);

        List<Vertex> path = a.shortestPath(e);
        assertEquals(4, path.toArray().length - 1);
    }

    @Test
    public void testHasLoop1() {
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);

        a.addEdge(b);
        b.addEdge(a);

        assertTrue(a.hasLoop());
    }

    @Test
    public void testHasLoop2() {
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);

        a.addEdge(b);
        b.addEdge(c);

        assertFalse(a.hasLoop());
    }

    @Test
    public void testHasLoop3() {
        Vertex a = new Vertex(1);
        a.addEdge(a);

        assertTrue(a.hasLoop());
    }

    @Test
    public void testHasLoop4() {
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);
        Vertex d = new Vertex(4);

        a.addEdge(b);
        b.addEdge(c);
        c.addEdge(d);
        d.addEdge(b);

        assertTrue(a.hasLoop());
    }

    @Test
    public void testHasLoop5() {
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);

        a.addEdge(b);

        assertFalse(a.hasLoop());
        assertFalse(c.hasLoop());
    }

    @Test
    public void testHasLoop6() {
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);
        Vertex d = new Vertex(4);
        Vertex e = new Vertex(5);
        Vertex f = new Vertex(6);

        a.addEdge(b);
        b.addEdge(c);
        c.addEdge(d);
        d.addEdge(e);
        e.addEdge(f);
        f.addEdge(c); // cykl: c → d → e → f → c

        assertTrue(a.hasLoop());
    }
}