package CompetitionQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AdventureLand {

    private ArrayList<ArrayList<Node>> adj = new ArrayList<>();
    private Set<Integer> visited;
    private int V;
    private int root;
    private int distance[];
    private PriorityQueue<Node> queue ;

    AdventureLand(List<Edge> edges, int v, int startVertex) {
        this.V = v;
        this.root = startVertex;
        distance = new int[V];
        visited = new HashSet<>();
        queue = new PriorityQueue<>(V,new Node());
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
            adj.add(i, new ArrayList<>());

        }
        for (Edge edge : edges) {
            adj.get(edge.source).add(new Node(edge.destination, edge.weight));
            adj.get(edge.destination).add(new Node(edge.source, edge.weight));

        }

    }

    static class Edge {

        int source;
        int destination;
        int weight;

        Edge(int src, int des, int wt) {
            this.source = src;
            this.destination = des;
            this.weight = wt;
        }
    }

    static class Node implements Comparator<Node> {
        int time;
        int vertex;

        Node(int ver, int t) {
            this.vertex = ver;
            this.time = t;
        }

        Node(){}

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.time < node2.time) return -1;
            if (node1.time > node2.time) return 1;
            return 0;
        }

        @Override
        public String toString() {
            return String.format("{%s}", vertex);
        }
    }

    void MST() {
        queue.add(new Node(root, 0));
        distance[root] = 0;
        while (visited.size() != V && !queue.isEmpty()) {
            int w = queue.remove().vertex;
            visited.add(w);
            traverse_adj(w);
        }
    }

    private void traverse_adj(int u) {
        int edgeDistance  ;
        int newDistance  ;

        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);
            if (!visited.contains(v.vertex)) {
                visited.add(v.vertex);
                edgeDistance = v.time;
                newDistance = distance[u] + edgeDistance;
                if (newDistance < distance[v.vertex]) {
                    distance[v.vertex] = newDistance;
                }
                queue.add(new Node(v.vertex, distance[v.vertex]));
            }
        }

    }

    private void printTotalTime(int arr[]) {
        int sum = 0;
        for (int k = 0; k < arr.length - 1; k++) {
            sum = sum + 2 * distance[arr[k]];
        }
        sum = sum + distance[arr[arr.length-1]];
        System.out.println("The result is : " + sum);
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(1, 2, 11), new Edge(1, 3, 2),
                new Edge(1, 4, 11), new Edge(1, 5, 10),
                new Edge(2, 4, 12), new Edge(3, 4, 13),
                new Edge(3, 5, 13));
        int flagNodes[] = new int[]{2, 5};
        AdventureLand graph = new AdventureLand(edges, 5 + 1, 4);
        graph.MST();
        graph.printTotalTime(flagNodes);

    }
}
