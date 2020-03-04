package graphAdvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class KosarajuSCC {

    private ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private boolean visited[];

    static class Edge {
        int src;
        int dest;

        Edge(int source, int destination) {
            this.src = source;
            this.dest = destination;
        }
    }

    private KosarajuSCC(List<Edge> edges, int V) {
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            adj.add(i, new ArrayList<>());
            visited[i] = false;
        }

        for (Edge current : edges) {
            adj.get(current.src).add(current.dest);
        }
    }

    void dfs(boolean visited[], int src) {
        visited[src] = true;
        System.out.print(src + " ");
        int n;
        Iterator<Integer> itr = adj.get(src).iterator();
        while (itr.hasNext()) {
            n = itr.next();
            if (!visited[n])
                dfs(visited, n);
        }
    }

    KosarajuSCC getTranspose() {
        List<Edge> newEdge = new ArrayList<>();
        for (int k = 0; k < adj.size(); k++) {
            int v;
            for (Integer integer : adj.get(k)) {
                v = integer;
                newEdge.add(new Edge(v, k));
            }
        }
        return new KosarajuSCC(newEdge, adj.size());
    }

    void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        for (Integer n : adj.get(v)) {
            if (!visited[n])
                fillOrder(n, visited, stack);
        }
        stack.push(v);
    }

    void printSCCs() {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < adj.size(); i++)
            if (!visited[i])
                fillOrder(i, visited, stack);

        KosarajuSCC revGraph = getTranspose();
        int count = 0 ;
        while (!stack.empty()) {

            int v = stack.pop();
            if (!revGraph.visited[v]) {
                revGraph.dfs(revGraph.visited, v);
                System.out.println();
                count++ ;
            }
        }
        System.out.println( "result is - " + count);

    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(1, 0), new Edge(0, 2),
                new Edge(2, 1), new Edge(0, 3), new Edge(3, 4));

        KosarajuSCC graph = new KosarajuSCC(edges, 5);
        System.out.println("Following are strongly connected components " +
                "in given graph ");
        graph.printSCCs();
    }

    @SuppressWarnings("Duplicates")
    void printGraph() {

        int n = adj.size();
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < adj.get(j).size(); k++) {
                int node = adj.get(j).get(k);
                System.out.print("(" + j + " --> " + node + ")\t");
            }
            System.out.println();
        }
    }
}
