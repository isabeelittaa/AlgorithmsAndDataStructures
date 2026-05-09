public class Main {
    public static void main(String[] args) {
        Experiment experiment = new Experiment();

        System.out.println("=== Assignment 4: Graph Traversal and Representation ===");
        System.out.println("Graphs: directed |V| = 10, 30, 100 with path + shortcut edges.");
        System.out.println();

        experiment.runMultipleTests();
        experiment.printResults();
    }
}