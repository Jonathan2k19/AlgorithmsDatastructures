package datastructures.graphs;

import java.util.Random;

public class GraphUtils {
    private final Random random;
    private final UnweightedGraph<Integer> graph;

    public GraphUtils() {
        this.random = new Random();
        this.graph = new UnweightedGraph<>();
    }

    /**
     * @param size  the size of the graph
     * @param bound the upper bound for vertices
     * @return a directed unweighted graph
     */
    public UnweightedGraph<Integer> createDirectedGraph(final int size, final int bound) {
        for (int i = 0; i < size; i++) {
            final int source = random.nextInt(bound);
            final int destination = random.nextInt(bound);
            System.out.println("Source: " + source + ", destination: " + destination);
            this.graph.addDirectedEdge(source, destination);
        }
        return this.graph;
    }

    /**
     * @param size  the size of the graph
     * @param bound the upper bound for vertices
     * @return an undirected unweighted graph
     */
    public UnweightedGraph<Integer> createUndirectedGraph(final int size, final int bound) {
        for (int i = 0; i < size; i++) {
            final int source = random.nextInt(bound);
            final int destination = random.nextInt(bound);
            this.graph.addUndirectedEdge(source, destination);
        }
        return this.graph;
    }
}
