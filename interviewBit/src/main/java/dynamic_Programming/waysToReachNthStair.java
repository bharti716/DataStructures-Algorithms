package dynamic_Programming;

public class waysToReachNthStair {

    public static void main(String[] args) {

        int n = 10 ;
        System.out.println("result is - " + noOfWays(n));
    }

    private static int noOfWays(int m) {

        int dp[] = new int[m+1];
        dp[0] = 1 ;
        dp[1] = 1 ;
        for(int i = 2 ; i <= m ; i++) {
            dp[i] = (dp[i - 1]%1000000007 + dp[i - 2]%1000000007)%1000000007;
        }
        return dp[m] ;
    }
}
