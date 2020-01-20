package graphs;

import java.util.ArrayList;

public class Islands {

    // Function to find the number of island in the given list
    // N, M: size of list row and column respectively
    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M)
    {

        if(list == null || list.size() == 0){
            return 0 ;
        }
        boolean visited[][] = new boolean[N][M];
        int noOfIslands = 0 ;
        for(int i=0 ; i < N ; i++){
            for(int j = 0 ; j<M ; j++){
                noOfIslands += dfs(list,i,j,visited);
                visited[i][j] = true ;
            }
        }
        return noOfIslands ;
    }
    static int dfs(ArrayList<ArrayList<Integer>> list, int row, int col, boolean visited[][]){
        if(row < 0 || row >= list.size() || col < 0 || col >= list.get(row).size() ||
                list.get(row).get(col) == 0 || visited[row][col]){
            return 0 ;
        }
        list.get(row).set(col,0);
        dfs(list,row-1,col,visited);
        dfs(list,row+1,col,visited);
        dfs(list,row,col-1,visited);
        dfs(list,row,col+1,visited);
        dfs(list,row-1,col-1,visited);
        dfs(list,row+1,col+1,visited);
        dfs(list,row-1,col+1,visited);
        dfs(list,row+1,col-1,visited);
        return 1 ;
    }
}
