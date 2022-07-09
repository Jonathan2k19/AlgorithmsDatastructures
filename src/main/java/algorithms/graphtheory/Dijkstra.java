package algorithms.graphtheory;

import algorithms.graphtheory.BellmanFord.Edge;
import java.util.LinkedList;
import java.util.List;

public class Dijkstra {
    private final List<Integer> unvisited;  // stores nodes not yet visited by Dijkstra
    private final Edge[] edges;             // edges array
    private final int source;               // source node
    private final double[] dist;            // distances from source to all the other nodes

    public Dijkstra(final int source, final Edge[] edges, final List<Integer> nodes) {
        this.unvisited = new LinkedList<>(nodes);
        this.edges = edges;
        this.source = source;
        this.dist = new double[nodes.size()];
    }

    /**
     * @return the node that is not yet visited and has the minimal distance from all unvisited
     * nodes
     */
    private int getNextNode() {
        int minNode = -1;
        if (!unvisited.isEmpty()) {
            minNode = unvisited.get(0); // node with minimal distance

            for (final int node : unvisited) {
                if (dist[node] < dist[minNode])
                    minNode = node;
            }
        }
        return minNode;
    }

    /**
     * Runs the dijkstra shortest-path algorithm.
     *
     * @return array of the shortest distances from the source node to all the other nodes
     */
    public double[] dijkstra() {
        // initialization of distances
        java.util.Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[source] = 0;

        // Dijkstra's algorithm
        int currentNode = source;

        while (!unvisited.isEmpty()) {
            unvisited.remove(Integer.valueOf(currentNode));
            for (final Edge edge : edges) {
                if (edge.from == currentNode) {
                    // Neighbour of current node. Relax edge
                    if (dist[edge.to] > dist[currentNode] + edge.cost)
                        dist[edge.to] = dist[currentNode] + edge.cost;
                }
            }

            currentNode = getNextNode(); // min distance of all unvisited nodes
        }

        return dist;
    }

    public static void main(String[] args) {
        // #edges, #nodes, source node
        final int e = 9, n = 5, source = 0;
        final List<Integer> nodes = new LinkedList<>();
        nodes.add(0);
        nodes.add(1);
        nodes.add(2);
        nodes.add(3);
        nodes.add(4);

        // create edges
        // see graph: https://www.youtube.com/watch?v=_lHSawdgXpI
        final Edge[] edges = new Edge[e];
        edges[0] = new Edge(0, 1, 4);
        edges[1] = new Edge(0, 2, 2);
        edges[2] = new Edge(1, 2, 3);
        edges[3] = new Edge(1, 4, 2);
        edges[4] = new Edge(1, 3, 3);
        edges[5] = new Edge(2, 1, 1);
        edges[6] = new Edge(2, 3, 5);
        edges[7] = new Edge(2, 4, 4);
        edges[8] = new Edge(3, 4, 1);

        final Dijkstra dijkstra = new Dijkstra(source, edges, nodes);
        final double[] dist = dijkstra.dijkstra();

        // print results
        for (final int node : nodes)
            System.out.println("Distance from " + source + " to " + node + ":\t" + dist[node]);

        /* Result:
            Distance from 0 to 0:	0.0
            Distance from 0 to 1:	3.0
            Distance from 0 to 2:	2.0
            Distance from 0 to 3:	6.0
            Distance from 0 to 4:	5.0
        */
    }
}
