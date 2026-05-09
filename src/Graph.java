import java.util.*;

public class Graph {
    private Map<Integer, Vertex> vertices = new HashMap<>();
    private Map<Integer, List<Edge>> adjacencyList = new HashMap<>();

    public void addVertex(Vertex v) {
        vertices.putIfAbsent(v.getId(), v);
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        if (adjacencyList.containsKey(from) && adjacencyList.containsKey(to)) {
            adjacencyList.get(from).add(new Edge(from, to));
        }
    }

    public void printGraph() {
        for (Integer id : adjacencyList.keySet()) {
            System.out.print("Vertex " + id + " -> ");
            for (Edge e : adjacencyList.get(id)) {
                System.out.print(e.getDestination() + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int startId) {
        if (!vertices.containsKey(startId)) return;

        Set<Integer> visited = new HashSet<>();
        // Using standard Java Queue and LinkedList
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startId);
        queue.add(startId); // Standard method to enqueue

        System.out.print("BFS Traversal starting from " + startId + ": ");
        while (!queue.isEmpty()) {
            int currentId = queue.poll(); // Standard method to dequeue
            System.out.print(currentId + " ");

            for (Edge edge : adjacencyList.get(currentId)) {
                int neighborId = edge.getDestination();
                if (!visited.contains(neighborId)) {
                    visited.add(neighborId);
                    queue.add(neighborId);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int startId) {
        if (!vertices.containsKey(startId)) return;

        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS Traversal starting from " + startId + ": ");
        dfsHelper(startId, visited);
        System.out.println();
    }

    private void dfsHelper(int currentId, Set<Integer> visited) {
        visited.add(currentId);
        System.out.print(currentId + " ");

        for (Edge edge : adjacencyList.get(currentId)) {
            int neighborId = edge.getDestination();
            if (!visited.contains(neighborId)) {
                dfsHelper(neighborId, visited);
            }
        }
    }
}