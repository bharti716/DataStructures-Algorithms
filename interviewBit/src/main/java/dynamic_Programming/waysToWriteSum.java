package dynamic_Programming;



public class waysToWriteSum {

    public static void main(String[] args) {
        int sum = 5;
        System.out.println("the result is - " + totalWays(sum));
    }

    private static int totalWays(int value) {

        int dp[] = new int[value + 1];
        dp[0] = 1 ;
        for (int i = 1 ; i < value ; i++) {
            for (int j = 1; j <= value; j++) {
                if (i <= j) {
                    dp[j] = (dp[j]+dp[j-i])%1000000007;
                }

            }

        }
        return dp[value];
    }


}
