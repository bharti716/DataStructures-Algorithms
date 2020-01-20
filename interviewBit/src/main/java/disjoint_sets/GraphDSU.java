package disjoint_sets;


public class GraphDSU {
    int V;
    int E;
    Subset subset[];
    Edge edge[];

    class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    class Subset {
        int parent;
        int rank;
    }

    GraphDSU(int v, int e) {
        V = v;
        E = e;
        subset = new Subset[V];
        edge = new Edge[E];

        for(int k = 0 ; k < V ; k++){
            subset[k] = new Subset();
        }
        for (int i = 0; i < V; i++) {
            subset[i].parent = i;
            subset[i].rank = 0;
        }

        for (int j = 0; j < E; j++) {
            edge[j] = new Edge();
        }
    }

    int find(Subset subsets[], int p) {
        if (subsets[p].parent != p) {
            subsets[p].parent = find(subsets, subsets[p].parent);
        }
        return subsets[p].parent;
    }

    void union(Subset sub[], int x, int y) {

        int xroot = find(sub, x);
        int yroot = find(sub, y);

        if (sub[xroot].rank > sub[yroot].rank) {
            sub[yroot].parent = xroot;

        } else if (sub[yroot].rank > sub[xroot].rank) {
            sub[xroot].parent = yroot;
        } else {
            sub[yroot].parent = xroot;
            sub[xroot].rank++;
        }
    }

    boolean findCycle() {
        int e = 0;
        while (e < E ) {
            Edge next_edge = edge[e++];
            int x = find(subset, next_edge.src);
            int y = find(subset, next_edge.dest);

            if (x == y) {
                return true;
            } else {
                union(subset, x, y);
            }

        }
        return false;
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

        int V = 4;
        int E = 5;

        GraphDSU graph = new GraphDSU(4, 5);

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

        System.out.println("Is Cycle Present : " + graph.findCycle());

    }
}
