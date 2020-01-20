package graphAdvanced;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {

    private Set<Integer> visited ;
    private int V ;
    private int dist[] ;
    List<List<Node>> adj ;
    PriorityQueue<Node> queue ;
    Graph(int v ){
        V = v ;
        dist = new int[V];
        visited = new HashSet<>();
        adj = new ArrayList<>();
        queue = new PriorityQueue<>(V,new Node());
        for(int i = 0 ; i < V ;i++){
            dist[i] = Integer.MAX_VALUE ;
            adj.add(i,new ArrayList<>());
        }

    }

    private void addEdge(int source, int destination, int weight) {
        Node node1 = new Node(source,weight);
        Node node2 = new Node(destination,weight);

        adj.get(node1.vertex).add(node2);
        adj.get(node2.vertex).add(node1);

    }
    static class Node implements Comparator<Node> {
        int vertex ;
        int edgeWt ;
        Node(int ver,int wt ){
            this.vertex = ver;
            this.edgeWt  = wt ;
        }
        Node(){

        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.edgeWt < node2.edgeWt)
                return -1;
            if (node1.edgeWt > node2.edgeWt)
                return 1;
            return 0;
        }
    }
    private void dijkstra(List<List<Node>> adj, int src){

        this.adj = adj;
        queue.add(new Node(src,0 ));

        dist[src] = 0;
        while(visited.size() != V ){
            int n = queue.remove().vertex ;
            visited.add(n);
            traverse_neighbours(n);
        }

    }

    private void traverse_neighbours(int u) {

        int edgeDistance ;
        int newDistance ;
        for(int i = 0 ; i < adj.get(u).size() ; i++){
            Node v = adj.get(u).get(i);
            if(!visited.contains(v.vertex)){
                edgeDistance = v.edgeWt ;
                newDistance = dist[u] + edgeDistance;
                    if(newDistance < dist[v.vertex]){
                        dist[v.vertex] = newDistance ;
                    }
                    queue.add(new Node(v.vertex , dist[v.vertex] ));
            }
        }
    }

    public static void main(String[] args) {
            /*        8        7
               1 ---------2---------3
            4 / |         |  \      | \
             /  |         |2  \     |  \ 9
            0   | 11      8    \ 4  |   \
             \  |       / |     \   |14 4
            8 \ |    /7   |6     \  |  /
               \| /       |       \ | / 10
                7---------6---------5/
                      1         2
          */
        int V = 9;
        int S = 0;

        Graph g = new Graph(V);
        g.addEdge(0,1,4);
        g.addEdge(0,7,8);
        g.addEdge(1,2,8);
        g.addEdge(1,7,11);
        g.addEdge(2,3,7);
        g.addEdge(2,8,2);
        g.addEdge(2,5,4);

        g.addEdge(3,4,9);
        g.addEdge(3,5,14);
        g.addEdge(4,5,10);

        g.addEdge(5,6,2);
        g.addEdge(6,7,1);
        g.addEdge(6,8,6);
        g.addEdge(7,8,7);

        g.dijkstra(g.adj,S);

        System.out.println("The shorted path from node :");
        for (int i = 0; i < g.dist.length; i++)
            System.out.println(S + " to " + i + " is "
                    + g.dist[i]);
    }
}
