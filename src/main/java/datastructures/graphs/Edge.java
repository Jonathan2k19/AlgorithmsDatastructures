package datastructures.graphs;

import java.util.ArrayList;

/**
 * Represents a simple edge: [source -> destination]
 *
 * @param <T> extends <Code>Comparable</Code>
 */
public class Edge<T extends Comparable<T>> {
    private final T source;
    private final T destination;

    public Edge(final T source, final T destination) {
        this.source = source;
        this.destination = destination;
    }

    /**
     * @return the edge as pair of source and destination
     */
    public ArrayList<T> getEdge() {
        final ArrayList<T> edge = new ArrayList<>(2);
        edge.add(source);
        edge.add(destination);
        return edge;
    }

    /**
     * @return the source of the edge
     */
    public T getSource() {
        return source;
    }

    /**
     * @return the destination of the edge
     */
    public T getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return source + ":" + destination;
    }
}
