package datastructures.graphs;

import java.util.HashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicGraphTest {
    private UnweightedGraph<Integer> graph;
    private final GraphUtils graphUtils;

    public BasicGraphTest() {
        this.graphUtils = new GraphUtils();
    }

    @BeforeEach
    public void setupGraph() {
        // create a directed graph
        this.graph = graphUtils.createUndirectedGraph(10, 20);
    }

    @Test
    public void containsEdgeTest() {
        final HashSet<Edge<Integer>> edges = graph.getEdges();
        for (final Edge<Integer> edge : edges) {
            Assertions.assertTrue(graph.containsEdge(edge));
        }
    }
}
