package graphs;

import java.util.ArrayList;
import java.util.Iterator;

public class cycleInUnDirected {

    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
        for(int u = 0 ; u < V ; u++){
            if(!visited[u]){
                if(isCyclicUtil(list,u,visited,-1))
                    return true ;
            }
        }
        return false ;
    }
    static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> list,int v ,Boolean visited[],int parent){
        Iterator<Integer> itr = list.get(v).iterator();
        visited[v] = true ;
        int curr ;
        while(itr.hasNext()){

            curr = itr.next();

            if(!visited[curr]){
                if(isCyclicUtil(list,curr,visited,v)){
                    return true ;
                }
            }
            else if (curr != parent)
                return true ;

        }
        return false ;
    }
}
