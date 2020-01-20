package graphAdvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TarjansSCC {

    private ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private boolean visited[];
    private int V ;
    private int low[];
    private int dis[];
    private int count;               // number of strongly-connected components
    private int timer;
    private int parent[];
    private Stack<Integer> stack;

    static class Edge {
        int src;
        int dest;

        Edge(int source, int destination) {
            this.src = source;
            this.dest = destination;
        }
    }

    private TarjansSCC(List<Edge> edges, int v) {
        this.V = v;
        visited = new boolean[V];
        low = new int[V];
        dis = new int[V];
        parent = new int[V];
        timer = 0;
        count = 0;
        stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            adj.add(i, new ArrayList<>());
            visited[i] = false;
        }

        for (Edge current : edges) {
            adj.get(current.src).add(current.dest);
        }

    }

    void dfs(){
        for (int n = 0; n < V; n++) {
            if (!visited[n]) {
                dfsUtil(n);
            }
        }
    }
    @SuppressWarnings("Duplicates")
    void dfsUtil(int u) {
        visited[u] = true;
        low[u] = dis[u] = timer++;
        stack.push(u);
        int v;
        for (Integer integer : adj.get(u)) {
            v = integer;
            parent[v] = u;
            if (!visited[v]) {
                dfsUtil(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], dis[v]);
            }
        }

        if (low[u] == dis[u]) {
            int curr ;
            do {
                curr = stack.pop();
                System.out.print(curr + " ");
            }
            while ( u != curr) ;
            System.out.println();
        }


    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(0, 2), new Edge(2, 3),
                new Edge(3, 4), new Edge(4, 5), new Edge(5, 6),
                new Edge(6, 7),new Edge(7, 4),new Edge(2, 1),
                new Edge(1, 0));

        TarjansSCC graph = new TarjansSCC(edges, 8);
        System.out.println("Following are strongly connected components " +
                "in given graph ");
        graph.dfs();

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
