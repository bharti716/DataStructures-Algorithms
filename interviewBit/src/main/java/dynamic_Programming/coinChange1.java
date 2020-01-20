package dynamic_Programming;

import java.util.Arrays;

public class coinChange1 {

    public static void main(String[] args) {
        int arr[] = new int[]{2, 5, 3, 6};
        int sum = 10;
        System.out.println("the result is - " + minCoins(arr, sum));
    }

    private  static int minCoins(int[] coins, int value) {
        Arrays.sort(coins);
        int dp[] = new int[value + 1];
        Arrays.fill(dp,value+1);
        dp[0] = 0;
        for (int i = 0; i <= value; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                } else break;
            }

        }
        return dp[value] > value ? -1 : dp[value];
    }
}
