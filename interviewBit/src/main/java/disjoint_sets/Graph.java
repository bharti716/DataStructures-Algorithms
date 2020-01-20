package disjoint_sets;

import java.util.Arrays;

public class Graph {

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    class Subset {
        int parent, rank;
    }

    private int V , E;
    private Edge edge[];
    private Subset subset[];

    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
        subset = new Subset[V];
        for(int j = 0 ; j < V ; j++){
            subset[j] = new Subset();
        }

        for(int vr = 0 ; vr < V ; vr++){
            subset[vr].parent = vr ;
            subset[vr].rank = 0 ;

        }
    }
    int find(Subset subset[] , int i){

        if(subset[i].parent != i ){
            subset[i].parent = find(subset,subset[i].parent);
        }
        return subset[i].parent ;
    }
    void union(int x , int y , Subset sub[]){

        int a = find(sub , x);
        int b = find(sub , y);
        if( sub[a].rank > sub[b].rank ){
            sub[b].parent = a ;
        }
        else if (sub[a].rank < sub[b].rank){
            sub[a].parent = b ;
        }
        else {
            sub[b].parent = a;
            sub[a].rank++ ;
        }
    }
    void KruskalMST(){

        Edge result[] = new Edge[V];
        Arrays.sort(edge);
        int e = 0 ;
        int i = 0 ;
        while(e < V-1){
            new Edge();
            Edge next_edge;
            next_edge = edge[i++] ;

            int x = find(subset,next_edge.src);
            int y = find(subset,next_edge.dest);

            if(x != y){
                result[e++] = next_edge ;
                union(x,y,subset);

            }
        }

        // print the contents of result[] to display
        // the built MST
        System.out.println("Following are the edges in " +
                "the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src+" -- " +
                    result[i].dest+" == " + result[i].weight);

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

        int V = 4 ;
        int E = 5 ;
        Graph graph = new Graph(4,5);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.KruskalMST();

    }

}
