import java.util.*;

public class Main {

    // Pair for weighted edge
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // Graph container
    static class Graph {
        int vertices;
        List<List<Pair>> adj;

        Graph(int vertices, List<List<Pair>> adj) {
            this.vertices = vertices;
            this.adj = adj;
        }
    }

    // Build weighted graph
    static Graph buildGraph(int v, int[][] edges) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // edges: {u, v, weight}
        for (int[] e : edges) {
            int u = e[0];
            int w = e[1];
            int wt = e[2];

            adj.get(u).add(new Pair(w, wt));
            adj.get(w).add(new Pair(u, wt)); // remove if directed
        }

        return new Graph(v, adj);
    }

    // Convert to weighted matrix
    static int[][] buildMatrix(Graph g) {

        int v = g.vertices;
        int[][] matrix = new int[v][v];

        // initialize with 0 (means no edge)
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < v; i++) {
            for (Pair p : g.adj.get(i)) {
                matrix[i][p.node] = p.weight;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

        int v = 5;

        // {u, v, weight}
        int[][] edges = {
            {0,1,2},
            {1,2,4},
            {1,3,1},
            {2,4,7},
            {3,4,3}
        };

        Graph g = buildGraph(v, edges);

        // print adjacency list
        System.out.println("Adjacency List:");
        for (int i = 0; i < g.vertices; i++) {
            System.out.print(i + " -> ");
            for (Pair p : g.adj.get(i)) {
                System.out.print("(" + p.node + "," + p.weight + ") ");
            }
            System.out.println();
        }

        // build matrix
        int[][] matrix = buildMatrix(g);

        // print matrix
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
