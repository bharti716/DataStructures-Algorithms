package graphs;

import java.util.ArrayList;
import java.util.Iterator;

public class cycleInDirected {

    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        boolean visited[] = new boolean[V];
        boolean explored[] = new boolean[V];
        for(int p=0 ;p < V ; p++){
            if(!visited[p]){
                if(isCyclicUtil(list,p,visited,explored))
                    return true ;
            }
        }
        return false ;
    }
    static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> list,int v,boolean visited[],boolean explored[]){
        Iterator<Integer> itr = list.get(v).iterator();
        visited[v] = true;          // Mark current node visited as true
        explored[v] = true;
        int curr ;
        while(itr.hasNext()){
            curr = itr.next();
            if(!visited[curr]){
                if(isCyclicUtil(list,curr,visited,explored))
                    return true ;
            }
            else if(explored[curr]) return true ;

        }
        explored[v] = false ;
        return false ;

    }
}
