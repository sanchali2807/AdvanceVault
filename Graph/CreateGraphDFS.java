import java.util.*;

public class Main {

    // Graph container
    static class Graph {
        int vertices;
        List<List<Integer>> adj;

        Graph(int vertices, List<List<Integer>> adj) {
            this.vertices = vertices;
            this.adj = adj;
        }
    }

    // Build adjacency list
    static Graph buildGraph(int v, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int w = e[1];

            adj.get(u).add(w);
            adj.get(w).add(u); // remove if directed
        }

        return new Graph(v, adj);
    }

    // Convert to adjacency matrix
    static int[][] buildMatrix(Graph g) {

        int v = g.vertices;
        int[][] matrix = new int[v][v];

        for (int i = 0; i < v; i++) {
            for (int neighbor : g.adj.get(i)) {
                matrix[i][neighbor] = 1;
            }
        }

        return matrix;
    }
    static void dfs(boolean[]visited,List<List<Integer>> adj,int node){
        if(visited[node]){
            return;
        }
        visited[node] = true; 
        System.out.println(node);
        for(int nei : adj.get(node)){
            if(!visited[nei]){
                // visited[nei] = true;
                dfs(visited,adj,nei);
            }
        }
    }
    public static void main(String[] args) {

        int v = 7;

        int[][] inputEdges = {
            {0,0},{1,2},{1,4},{1,3},
            {2,5},{2,6},{3,6},{4,5}
        };

        // build graph
        Graph g = buildGraph(v, inputEdges);

        // print adjacency list
        System.out.println("Adjacency List:");
        for (int i = 0; i < g.vertices; i++) {
            System.out.println(i + " -> " + g.adj.get(i));
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
        // for weighted we add weight in the inputEdge 2d array
        
        boolean visited[] = new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(visited,g.adj,i);
            }
        }
    }
}
