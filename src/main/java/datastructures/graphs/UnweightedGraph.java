package datastructures.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Unweighted graph class. G := (V,E)
 * <ul>
 *     <li>adjacency list/map</li>
 *        <ol>
 *          <li>space: O(|V|+|E|)</li>
 *          <li>time:  O(outdegree(from_node)) -> worst case: O(|V|)</li>
 *        </ol>
 *     <li>adjacency matrix: O(|V|+|E|)</li>
 *        <ol>
 *          <li>space: O(|V| * |E|)</li>
 *          <li>time:  O(1)</li>
 *        </ol>
 * </ul>
 */
class UnweightedGraph<T extends Comparable<T>> {
    private final HashMap<T, LinkedList<T>> adjacencyMap;    // [from][to_1, to_2, ...]

    public UnweightedGraph() {
        adjacencyMap = new HashMap<>();
    }

    /**
     * Creates a new adjacencyMap entry for this vertex.
     *
     * @param vertex the vertex to add
     */
    private void addVertex(final T vertex) {
        adjacencyMap.put(vertex, new LinkedList<>());
    }

    /**
     * Creates a directed edge.
     *
     * @param from Edge source
     * @param to   Edge destination
     */
    public void addDirectedEdge(final T from, final T to) {
        if (!adjacencyMap.containsKey(from)) {
            addVertex(from);
        }
        if (!adjacencyMap.containsKey(to)) {
            addVertex(to);
        }
        adjacencyMap.get(from).add(to);
    }

    /**
     * Creates an undirected edge.
     *
     * @param v1 First vertex
     * @param v2 Second vertex
     */
    public void addUndirectedEdge(final T v1, final T v2) {
        if (!adjacencyMap.containsKey(v1)) {
            addVertex(v1);
        }
        if (!adjacencyMap.containsKey(v2)) {
            addVertex(v2);
        }
        adjacencyMap.get(v1).add(v2);
        adjacencyMap.get(v2).add(v1);
    }

    /**
     * @return the adjacency map
     */
    public HashMap<T, LinkedList<T>> getAdjacencyMap() {
        return adjacencyMap;
    }

    /**
     * @return the set of vertices
     */
    public Set<T> getVertices() {
        return adjacencyMap.keySet();
    }

    /**
     * @param vertex the source vertex
     * @return HashSet of all outgoing edges with vertex as source, otherwise <Code>null</Code>
     */
    public HashSet<Edge<T>> getEdges(final T vertex) {
        if (this.containsVertex(vertex)) {
            return constructEdgesFromSourceVertex(vertex);
        } else {
            return null;
        }
    }

    /**
     * @return All edges in the graph as HashSet of edges
     */
    public HashSet<Edge<T>> getEdges() {
        final HashSet<Edge<T>> allEdges = new HashSet<>();
        for (final HashMap.Entry<T, LinkedList<T>> entry : adjacencyMap.entrySet()) {
            final T source = entry.getKey();
            allEdges.addAll(constructEdgesFromSourceVertex(source));
        }
        return allEdges;
    }

    /**
     * A helper method for the construction of edges.
     *
     * @param sourceVertex the source of the edge
     * @return HashSet of edges
     */
    private HashSet<Edge<T>> constructEdgesFromSourceVertex(final T sourceVertex) {
        final HashSet<Edge<T>> edges = new HashSet<>();
        for (final T destination : adjacencyMap.get(sourceVertex)) {
            final Edge<T> edge = new Edge<>(sourceVertex, destination);
            edges.add(edge);
        }
        return edges;
    }

    /**
     * @param vertex the vertex
     * @return <Code>true</Code> if graph contains the vertex
     */
    public boolean containsVertex(final T vertex) {
        return adjacencyMap.containsKey(vertex);
    }

    /**
     * @param edge the edge
     * @return <Code>true</Code> if this graph contains the edge
     */
    public boolean containsEdge(final Edge<T> edge) {
        if (adjacencyMap.containsKey(edge.getSource())) {
            return adjacencyMap.get(edge.getSource()).contains(edge.getDestination());
        } else {
            return false;
        }
    }

    /**
     * Prints the adjacency list of the graph.
     */
    public void printGraph() {
        for (final HashMap.Entry<T, LinkedList<T>> entry : adjacencyMap.entrySet()) {
            System.out.println(entry.getKey() + "\t:\t" + entry.getValue());
        }
    }
}
