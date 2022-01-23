package datastructures.graphs;

import org.junit.jupiter.api.BeforeEach;

public class BasicGraphTest {
    private UnweightedGraph<Integer> graph;
    private final GraphUtils graphUtils;

    public BasicGraphTest() {
        this.graphUtils = new GraphUtils();
    }

    @BeforeEach
    public void setupGraph() {
        // create a directed graph
        this.graph = graphUtils.createDirectedGraph(10, 20);
    }

}
