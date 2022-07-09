package algorithms.graphtheory;

public class BellmanFord {
    static class Edge {
        int from, to;
        double cost;

        /**
         * Creates a directed weighted edge
         * @param from start node of edge
         * @param to end node of edge
         * @param cost weight
         */
        public Edge(final int from, final int to, final double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    private final int n;                // #nodes
    private final int source;           // the source node
    private final double[] dist;        // shortest distances to every node from source node
    private final Edge[] edges;         // edges array
    private boolean ranBfAlready = false;

    public BellmanFord(final Edge[] edges, final int n, final int source) {
        this.n = n;
        this.dist = new double[n];
        this.edges = edges;
        this.source = source;
    }

    /**
     * Bellman ford algorithm.
     */
    public void bellmanFord() {
        // initialization of distances
        java.util.Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[source] = 0;

        // for #nodes-1 times, relax every edge
        for (int i = 0; i < n - 1; i++) {
            for (final Edge edge : this.edges) {
                // relax edge
                if (dist[edge.to] > dist[edge.from] + edge.cost)
                    dist[edge.to] = dist[edge.from] + edge.cost;
            }
        }

        ranBfAlready = true;
    }

    /**
     * Run bf once again: if dist changes after n-1 iterations, there is a negative cycle.
     * @return distances (-infinity for nodes that are part of negative cycle)
     */
    public double[] detectNegativeCycles() {
        if (ranBfAlready) {
            for (final Edge edge : this.edges) {
                if (dist[edge.to] > dist[edge.from] + edge.cost) {
                    // set distance to -infinity if node part of negative cycle
                    dist[edge.to] = Double.NEGATIVE_INFINITY;
                }
            }
        }

        return dist;
    }



    public static void main(String[] args) {
        // #edges, #nodes, source node
        final int e = 10, n = 9, source = 0;

        // create edges
        final Edge[] edges = new Edge[e];
        edges[0] = new Edge(0, 1, 1);
        edges[1] = new Edge(1, 2, 1);
        edges[2] = new Edge(2, 4, 1);
        edges[3] = new Edge(4, 3, -3);
        edges[4] = new Edge(3, 2, 1);
        edges[5] = new Edge(1, 5, 4);
        edges[6] = new Edge(1, 6, 4);
        edges[7] = new Edge(5, 6, 5);
        edges[8] = new Edge(6, 7, 4);
        edges[9] = new Edge(5, 7, 3);

        // run bf
        final BellmanFord bf = new BellmanFord(edges, n, source);
        bf.bellmanFord();
        final double[] shortestDistances = bf.detectNegativeCycles();

        // print distances
        for (int i = 0; i < n; i++)
            System.out.println("Distance from " + source + " to " + i + ":\t" + shortestDistances[i]);
    }

}
