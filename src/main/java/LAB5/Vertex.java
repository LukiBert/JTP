package LAB5;

import java.util.*;

public class Vertex {
    private int label;
    private List<Vertex> neighbors;

    public Vertex(int label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }

    public int getLabel() {
        return label;
    }

    public void addEdge(Vertex to) {
        neighbors.add(to);
    }

    public boolean connectedWith(Vertex v) {
        Set<Vertex> visited = new HashSet<>();
        return dfs(this, v, visited);
    }

    private boolean dfs(Vertex current, Vertex target, Set<Vertex> visited) {
        if (current == target) return true;
        visited.add(current);

        for (Vertex neighbor : current.neighbors) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Vertex maximalConnected() {
        Set<Vertex> visited = new HashSet<>();
        Vertex[] max = new Vertex[] { this };
        dfsMax(this, visited, max);
        return max[0];
    }

    private void dfsMax(Vertex current, Set<Vertex> visited, Vertex[] max) {
        visited.add(current);
        if (current.label > max[0].label) {
            max[0] = current;
        }
        for (Vertex neighbor : current.neighbors) {
            if (!visited.contains(neighbor)) {
                dfsMax(neighbor, visited, max);
            }
        }
    }
}
