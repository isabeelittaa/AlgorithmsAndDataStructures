import java.util.*;

public class Experiment {
    private static final int[] SIZES = {10, 30, 100};

    private final List<Long> bfsNanos = new ArrayList<>();
    private final List<Long> dfsNanos = new ArrayList<>();

    public void runTraversals(Graph g) {
        System.out.println(">>> Traversals (start = 0)");

        long bfsStart = System.nanoTime();
        g.bfs(0);
        long bfsEnd = System.nanoTime();

        long bfsTime = bfsEnd - bfsStart;
        bfsNanos.add(bfsTime);

        System.out.println("BFS time: " + bfsTime + " ns");

        long dfsStart = System.nanoTime();
        g.dfs(0);
        long dfsEnd = System.nanoTime();

        long dfsTime = dfsEnd - dfsStart;
        dfsNanos.add(dfsTime);

        System.out.println("DFS time: " + dfsTime + " ns");
        System.out.println();
    }

    public void resetTimings() {
        bfsNanos.clear();
        dfsNanos.clear();
    }

    public void runMultipleTests() {
        resetTimings();

        System.out.println("========== Multi-size traversal experiment ==========");

        for (int n : SIZES) {
            System.out.println("---- Graph size: " + n + " vertices ----");

            Graph g = Graph.createSampleDirected(n);

            g.printGraph();

            if (n == SIZES[0]) {
                System.out.println("Small graph — traversal order:");
            }

            runTraversals(g);
        }
    }

    public void printResults() {
        System.out.println("========== Execution time summary (nanoseconds) ==========");

        System.out.printf("%-12s %-18s %-18s%n", "Vertices", "BFS", "DFS");

        for (int i = 0; i < SIZES.length; i++) {
            System.out.printf("%-12d %-18d %-18d%n",
                    SIZES[i],
                    bfsNanos.get(i),
                    dfsNanos.get(i));
        }

        System.out.println();
    }
}