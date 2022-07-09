package algorithms.graphtheory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {
    private final HashMap<Integer, LinkedList<Integer[]>> adj;

    protected Graph() {
        this.adj = new HashMap<>();
    }

    /**
     * Creates an edge.
     *
     * @param from the source of the edge
     * @param to   the destination of the edge
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
     *
     * @return the source nodes
     */
    protected Set<Integer> getNodes() {
        return this.adj.keySet();
    }

    /**
     * Get all edges (=adjacency list)
     *
     * @return adjacency list
     */
    protected HashMap<Integer, LinkedList<Integer[]>> getEdges() {
        return this.adj;
    }

    /**
     * Get the outgoing edges of a node.
     *
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
