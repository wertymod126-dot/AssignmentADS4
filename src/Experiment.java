import java.util.Random;

public class Experiment {
    private Random random = new Random();

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};

        for (int size : sizes) {
            System.out.println("\n=================================");
            System.out.println("--- Testing Graph Size: " + size + " ---");
            System.out.println("=================================");

            Graph g = generateRandomGraph(size);

            // To prevent errors, we ensure node 0 exists to start the traversal
            runTraversals(g, 0);
        }
    }

    private Graph generateRandomGraph(int size) {
        Graph g = new Graph();
        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        // Add random edges 
        for (int i = 0; i < size * 1.5; i++) {
            g.addEdge(random.nextInt(size), random.nextInt(size));
        }
        return g;
    }

    public void runTraversals(Graph g, int startNode) {
        // Measure BFS
        long startBfs = System.nanoTime();
        g.bfs(startNode);
        long endBfs = System.nanoTime();

        // Measure DFS
        long startDfs = System.nanoTime();
        g.dfs(startNode);
        long endDfs = System.nanoTime();

        printResults(endBfs - startBfs, endDfs - startDfs);
    }

    public void printResults(long bfsTime, long dfsTime) {
        System.out.println("\n--> BFS Execution Time: " + bfsTime + " ns");
        System.out.println("--> DFS Execution Time: " + dfsTime + " ns\n");
    }
}