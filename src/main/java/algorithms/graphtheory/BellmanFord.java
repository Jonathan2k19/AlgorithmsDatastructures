package algorithms.graphtheory;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BellmanFord {
    private final Graph graph;
    private final int startNode;

    public BellmanFord(final int startNode) {
        // the source for bf algorithm
        this.startNode = startNode;

        // https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/ this graph
        this.graph = new Graph();
        this.graph.addEdge(0,1,-1);
        this.graph.addEdge(0,2,4);
        this.graph.addEdge(1,2,3);
        this.graph.addEdge(1,3,2);
        this.graph.addEdge(1,4,2);
        this.graph.addEdge(3,2,5);
        this.graph.addEdge(3,1,1);
        this.graph.addEdge(4,3,-3);
    }

    /**
     * Get the graph.
     * @return graph
     */
    private Graph getGraph() {
        return this.graph;
    }

    /**
     * Runs the Bellman-Ford algorithm. Works on graphs with negative edge cases. Does not work
     * on graph with negative cycle.
     * For #nodes-1 times relax every edge.
     * If there is an edge that changes if we relax it after these #nodes-1 iterations, there is
     * a negative cycle.
     * @return distances map <node, distance>
     */
    // FIXME: doesn't work yet -> TODO
    public HashMap<Integer, Integer> run() {
        // initialization
        final Set<Integer> nodes = this.graph.getNodes();
        final HashMap<Integer, Integer> distances = new HashMap<>();
        for (final Integer node : nodes) {
            distances.put(node, Integer.MAX_VALUE);   // set distances to infinity
        }
        distances.put(this.startNode, 0);  // distance from start to start is 0
        final HashMap<Integer, LinkedList<Integer[]>> edges = this.graph.getEdges();


        // #nodes-1 iterations
        for (int i = 0; i < nodes.size() - 1; i++) {
            // for each edge
            for (final Map.Entry<Integer, LinkedList<Integer[]>> edge : edges.entrySet()) {
                final int from = edge.getKey();
                for (final Integer[] pair : edge.getValue()) {
                    final int to = pair[0];
                    final int weight = pair[1];

                    // relax edge
                    if (distances.get(from) + weight < distances.get(to)) {
                        distances.put(to, distances.get(from) + weight);
                    }
                }
            }
        }
        // TODO: negative cycles; make edges easier
        return distances;
    }

    public static void main(String[] args) {
        final BellmanFord bf = new BellmanFord(0);
        final Graph bfGraph = bf.getGraph();
        final HashMap<Integer, Integer> distances = bf.run();
        for (final Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            System.out.println(entry);
        }
    }
}


class Graph {
    private final HashMap<Integer, LinkedList<Integer[]>> adj;

    protected Graph() {
        this.adj = new HashMap<>();
    }

    /**
     * Creates an edge.
     * @param from the source of the edge
     * @param to the destination of the edge
     */
    protected void addEdge(final int from, final int to, final int weight) {
        if (!this.adj.containsKey(from)) {
            // create an empty list of <to,weight>, <to,weight>, ...
            final LinkedList<Integer[]> toList = new LinkedList<>();
            this.adj.put(from, toList);
        }
        final LinkedList<Integer[]> toList = this.adj.get(from);
        final Integer[] destinationWeight = {to, weight};
        toList.add(destinationWeight);
        this.adj.put(from, toList);
    }

    /**
     * Gets the nodes of the graph.
     * @return the source nodes
     */
    protected Set<Integer> getNodes() {
        return this.adj.keySet();
    }

    /**
     * Get all edges (=adjacency list)
     * @return adjacency list
     */
    protected HashMap<Integer, LinkedList<Integer[]>> getEdges() {
        return this.adj;
    }

    /**
     * Get the outgoing edges of a node.
     * @param from the node
     * @return the outgoing edges
     */
    protected LinkedList<Integer[]> outgoingEdges(final int from) {
        return this.adj.get(from);
    }

    /**
     * Prints all edges.
     */
    protected void printEdges() {
        for (final Map.Entry<Integer, LinkedList<Integer[]>> edge : this.adj.entrySet()) {
            System.out.print("From: " + edge.getKey());
            for (final Integer[] pair : edge.getValue()) {
                System.out.print(", [to: " + pair[0] + ", w: " + pair[1] + "]\t");
            }
            System.out.print("\n");
        }
    }
}
