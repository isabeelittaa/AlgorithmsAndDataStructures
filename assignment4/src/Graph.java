import java.util.*;

public class Graph {
    private final Map<Integer, Vertex> vertices = new HashMap<>();
    private final Map<Integer, List<Integer>> adjacency = new HashMap<>();

    public void addVertex(Vertex v) {
        int id = v.getId();
        vertices.put(id, v);
        adjacency.putIfAbsent(id, new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        requireVertex(from);
        requireVertex(to);
        adjacency.get(from).add(to);
    }

    private void requireVertex(int id) {
        if (!vertices.containsKey(id)) {
            throw new IllegalArgumentException("Unknown vertex id: " + id);
        }
    }

    public void printGraph() {
        System.out.println("--- Adjacency list ---");
        List<Integer> ids = new ArrayList<>(vertices.keySet());
        Collections.sort(ids);

        for (int id : ids) {
            System.out.println(id + " -> " + adjacency.get(id));
        }

        System.out.println();
    }

    public int getVertexCount() {
        return vertices.size();
    }

    public void bfs(int start) {
        requireVertex(start);

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);

            for (int neighbor : adjacency.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("BFS from " + start + ": " + order);
    }

    public void dfs(int start) {
        requireVertex(start);

        Set<Integer> visited = new HashSet<>();
        List<Integer> order = new ArrayList<>();

        dfsVisit(start, visited, order);

        System.out.println("DFS from " + start + ": " + order);
    }

    private void dfsVisit(int current, Set<Integer> visited, List<Integer> order) {
        visited.add(current);
        order.add(current);

        for (int neighbor : adjacency.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsVisit(neighbor, visited, order);
            }
        }
    }

    public static Graph createSampleDirected(int n) {
        Graph g = new Graph();

        for (int i = 0; i < n; i++) {
            g.addVertex(new Vertex(i));
        }

        for (int i = 0; i < n - 1; i++) {
            g.addEdge(i, i + 1);
        }

        if (n >= 4) {
            g.addEdge(0, n / 2);
            g.addEdge(n / 4, (3 * n) / 4);
        }

        return g;
    }
}