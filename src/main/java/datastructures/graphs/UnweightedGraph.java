package datastructures.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Unweighted graph class. G := (V,E)
 * <ul>
 *     <li>adjacency list</li>
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
    // adjacencyList: O(|V|+|E|)
    private final Map<T, LinkedList<T>> adjacencyMap;    // [from][to_1, to_2, ...]

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
    public Map<T, LinkedList<T>> getAdjacencyMap() {
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
     * @return List of all outgoing edges with vertex as source, otherwise <Code>null</Code>
     */
    public List<Map<T, T>> getEdges(final T vertex) {
        if (this.hasVertex(vertex)) {
            return constructEdgesFromSourceVertex(vertex);
        } else {
            return null;
        }
    }

    /**
     * @return All edges in the graph as list of maps
     */
    public List<Map<T, T>> getEdges() {
        final List<Map<T, T>> allEdges = new LinkedList<>();
        for (final Map.Entry<T, LinkedList<T>> entry : adjacencyMap.entrySet()) {
            final T source = entry.getKey();
            allEdges.addAll(constructEdgesFromSourceVertex(source));
        }
        return allEdges;
    }

    /**
     * A helper method for the construction of edge pairs. It builds pairs of [source,destination]
     *
     * @param sourceVertex the source of the edge
     * @return List of edges
     */
    private List<Map<T, T>> constructEdgesFromSourceVertex(final T sourceVertex) {
        final List<Map<T, T>> edges = new LinkedList<>();
        for (final T destination : adjacencyMap.get(sourceVertex)) {
            final Map<T, T> edge = new HashMap<>();
            edge.put(sourceVertex, destination);
            edges.add(edge);
        }
        return edges;
    }

    /**
     * @param vertex the vertex
     * @return <Code>true</Code> if graph contains the vertex
     */
    public boolean hasVertex(final T vertex) {
        return adjacencyMap.containsKey(vertex);
    }

    /**
     * Prints the adjacency list of the graph.
     */
    public void printGraph() {
        for (final Map.Entry<T, LinkedList<T>> entry : adjacencyMap.entrySet()) {
            System.out.println(entry.getKey() + "\t:\t" + entry.getValue());
        }
    }
}
