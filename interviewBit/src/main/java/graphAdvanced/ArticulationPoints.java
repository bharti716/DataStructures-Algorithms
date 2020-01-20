package graphAdvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArticulationPoints {

    private ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private boolean visited[];
    private int V ;
    int time = 0 ;

    static class Edge{
        int src ;
        int des ;

        Edge(int u , int v){
            this.src = u ;
            this.des = v ;
        }
    }
    private ArticulationPoints(List<Edge> edges , int v){
        this.V = v;
        visited = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            adj.add(i, new ArrayList<>());
        }
        for(Edge current : edges){
            adj.get(current.src).add(current.des);
        }
    }
    void AP(){
        int parent[] = new int[V];
        int disc[]= new int[V];
        int lowDisc[] = new int[V] ;
        boolean result[] = new boolean[V] ;

        for(int k = 0 ; k < V ; k++){
            parent[k] = -1 ;
            result[k] = false ;
            visited[k] = false ;
        }

        for(int p = 0 ; p < V ; p++){
            if(!visited[p])
                APUtil(visited,parent,disc,lowDisc,p,result);
        }

        for(int m = 0 ; m < V ; m++){
            if(result[m]){
                System.out.print(m+" ");
            }
        }
    }

    private void APUtil(boolean[] visited, int[] parent, int[] disc, int[] lowDisc, int u, boolean[] result) {
        int children = 0 ;
        disc[u] = lowDisc[u] = ++time ;
        visited[u] = true ;

        Iterator<Integer> itr = adj.get(u).iterator();
        while(itr.hasNext()){
            int v = itr.next();
            if(!visited[v]){
                children++ ;
                parent[v] = u ;
                APUtil(visited,parent,disc,lowDisc,v, result);
                lowDisc[u] = Math.min(lowDisc[v],lowDisc[u]);

                if (parent[u] == -1 && children > 1)
                    result[u] = true;

                if (parent[u] != -1 && lowDisc[v] >= disc[u])
                    result[u] = true;
            }
            else if(v != parent[u]){
                lowDisc[u] = Math.min(lowDisc[u],disc[v]);
            }
        }
    }

    void bridge(){
        int b_parent[] = new int[V];
        int b_dis[] = new int[V];
        int b_low[] = new int[V];

         for(int i = 0 ; i < V ; i++){
              b_parent[i] = -1 ;
              visited[i] = false ;
         }

         for(int j = 0 ; j < V ; j++){
             if(!visited[j]){
                 bridgeUtil(b_dis,b_low,b_parent,visited,j);
             }
         }

    }

    private void bridgeUtil(int[] b_dis, int[] b_low, int[] b_parent, boolean[] visited, int u) {

        visited[u] = true ;
        b_dis[u] = b_low[u] = ++time ;

        Iterator<Integer> itr = adj.get(u).iterator();
        while(itr.hasNext()){
            int v = itr.next();

            if(!visited[v]){
                bridgeUtil(b_dis,b_low,b_parent,visited,v);

                b_low[u] = Math.min(b_low[u],b_low[v]);

                if(b_low[v] > b_dis[u] ){
                    System.out.println(u+" "+v);
                }
            }
            else if (v != b_parent[u]){
                    b_low[u] = Math.min(b_low[u],b_dis[v]);
            }
        }
    }

    public static void main(String[] args) {
        List<Edge> edgeList = Arrays.asList(new Edge(1, 0), new Edge(0, 2),
                new Edge(2, 1), new Edge(0, 3), new Edge(3, 4));

        ArticulationPoints graph = new ArticulationPoints(edgeList,5);
        System.out.println("Articulation points in the graph");
        graph.AP();
        System.out.println("\n");
        System.out.println("Bridge edges in the graph");
        graph.bridge();

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
