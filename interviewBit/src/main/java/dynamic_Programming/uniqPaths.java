package dynamic_Programming;

public class uniqPaths {

    public static void main(String[] args) {
        int m = 3 ;
        int n = 4 ;
        int arr[][] = new int[m][n] ;
        System.out.println("the result is - " + func(arr, m,n));
    }

    private static int func(int[][] dp, int m, int n) {

        for( int i = 0 ; i < m ; i++){
            dp[i][0] = 1 ;
        }

        for(int j = 0 ; j < n ; j++){
            dp[0][j] = 1 ;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; //+ count[i-1][j-1];
        }
        return dp[m - 1][n - 1];
    }

}
