package dynamic_Programming;

public class waysToReachNthStair2 {

    public static void main(String[] args) {
        int n = 4 ;
        System.out.println("result is - " + ways(n));
    }

    private static int ways(int m) {
        int dp[] = new int[m+1];
        dp[0] = 1 ;
        dp[1] = 1 ;
        for(int i = 2 ; i <= m ; i++) {
            dp[i] = dp[i - 2] + 1 ;
        }
        return dp[m] ;


    }
}
