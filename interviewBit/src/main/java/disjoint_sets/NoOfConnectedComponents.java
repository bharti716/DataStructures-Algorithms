package disjoint_sets;

public class NoOfConnectedComponents {

    private int V, E;
    private Subset subset[] ;
    private Edge edge[] ;

    class Edge {
        int src;
        int dest;

    }

    private NoOfConnectedComponents(int v, int e) {
        V = v;
        E = e;
        subset = new Subset[V];
        edge = new Edge[E];
        for(int k = 0 ; k < V ; k++){
            subset[k] = new Subset();
        }
        for (int j = 0; j < V; j++) {
            subset[j].parent = j;
            subset[j].rank = 0;
        }
        for (int j = 0; j < E; j++) {
            edge[j] = new Edge();
        }
    }

    class Subset {
        int parent;
        int rank;
    }

    void union(Subset subset[] , int x, int y) {

        int xroot = find(subset, x);
        int yroot = find(subset, y);

        if (subset[xroot].rank > subset[yroot].rank) {
            subset[yroot].parent = xroot;
        } else if (subset[yroot].rank > subset[xroot].rank) {
            subset[xroot].parent = yroot;
        } else {
            subset[yroot].parent = xroot;
            subset[xroot].rank++;
        }

    }

    int find(Subset subsets[], int node) {

        if (subset[node].parent != node) {
            subset[node].parent = find(subset, subset[node].parent);
        }
        return subset[node].parent;
    }

    void noOfConnComp() {
        int cnt=0;
        int e = 0;
        Edge next_edge;
        while (e < E) {
            next_edge = edge[e++];

            int x = find(subset, next_edge.src);
            int y = find(subset, next_edge.dest);

            if (x != y) {
                union(subset, x, y);
            }
        }

        for(int p = 0 ; p < V ; p++ ){
            if( find(subset,p) == p) {
                cnt++;
            }
        }

        System.out.println("no of connected component is - " + cnt) ;
    }

    public static void main(String[] args) {
         /* Let us create following weighted graph

                                0-------1        4
                                  \     |        |
                                    \   |        |
                                      \ |        |
                                2-------3        5
                                    4       */

        int V = 6;
        int E = 5;
        NoOfConnectedComponents graph = new NoOfConnectedComponents(V, E);
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 3;

        graph.edge[2].src = 1;
        graph.edge[2].dest = 3;

        graph.edge[3].src = 2;
        graph.edge[3].dest = 3;

        graph.edge[4].src = 4;
        graph.edge[4].dest = 5;

        graph.noOfConnComp() ;
    }
}
