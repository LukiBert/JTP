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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex vertex = (Vertex) obj;
        return label == vertex.label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    public List<Vertex> shortestPath(Vertex target) {
        Map<Vertex, Vertex> prev = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        queue.add(this);
        visited.add(this);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            if (current.equals(target)) {
                return reconstructPath(prev, target);
            }

            for (Vertex neighbor : current.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    prev.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return Collections.emptyList();
    }

    private List<Vertex> reconstructPath(Map<Vertex, Vertex> prev, Vertex target) {
        List<Vertex> path = new ArrayList<>();
        for (Vertex at = target; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public boolean hasLoop() {
        Set<Vertex> visited = new HashSet<>();
        Set<Vertex> inPath = new HashSet<>();
        return dfsLoop(this, visited, inPath);
    }

    private boolean dfsLoop(Vertex current, Set<Vertex> visited, Set<Vertex> inPath) {
        if (inPath.contains(current)) {
            return true;
        }

        if (visited.contains(current)) {
            return false;
        }

        visited.add(current);
        inPath.add(current);

        for (Vertex neighbor : current.neighbors) {
            if (dfsLoop(neighbor, visited, inPath)) {
                return true;
            }
        }

        inPath.remove(current);
        return false;
    }
}
