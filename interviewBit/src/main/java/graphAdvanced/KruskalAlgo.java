package graphAdvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalAlgo {

    private int V;
    private int parent[];
    private PriorityQueue<Edge> queue;

    static class Edge implements Comparable<Edge> {
        int source;
        int destination;
        int weight;

        Edge(int src, int des, int wt) {
            this.source = src;
            this.destination = des;
            this.weight = wt;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    KruskalAlgo(List<Edge> edges, int v) {
        queue = new PriorityQueue<>();
        this.V = v;
        parent = new int[V];
        queue.addAll(edges);
        makeSet(parent);
    }

    private void makeSet(int[] parent) {

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }

    int find(int parent[], int vertex) {

        if (parent[vertex] != vertex) {
            return find(parent, parent[vertex]);
        }
        return vertex;
    }

    void union(int parent[], int x, int y) {

        int xroot = find(parent, x);
        int yroot = find(parent, y);

        parent[xroot] = yroot;

    }

    void kruskal_MST() {

        List<Edge> result = new ArrayList<>();
        while(result.size() < V - 1) {
            Edge edge = queue.remove();

            int xroot = find(parent, edge.source);
            int yroot = find(parent, edge.destination);

            if (xroot != yroot) {
                result.add(edge);
                union(parent, xroot, yroot);
            }
        }
        System.out.println("Minimum Spanning Tree: ");
        printGraph(result);
    }

    private void printGraph(List<Edge> result) {

        for (int i = 0; i < result.size(); i++) {
            Edge edge = result.get(i);
            System.out.println("Edge-" + i + " source: " + edge.source +
                    " destination: " + edge.destination +
                    " weight: " + edge.weight);
        }
    }

    public static void main(String[] args) {
        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */

        List<Edge> edges = Arrays.asList(new Edge(0, 1, 10), new Edge(1, 3, 15),
                new Edge(3, 2, 4), new Edge(2, 0, 6),
                new Edge(0, 3, 5));

        KruskalAlgo graph = new KruskalAlgo(edges, 4);
        graph.kruskal_MST();


    }
}
