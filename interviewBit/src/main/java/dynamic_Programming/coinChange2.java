package dynamic_Programming;

import java.util.Arrays;

public class coinChange2 {

    public static void main(String[] args) {
        int arr[] = new int[]{3, 5, 10};
        int sum = 8;
        System.out.println("the result is - " + totalWaysCoins(arr, sum));
    }

    private static int totalWaysCoins(int[] coins, int value) {
        Arrays.sort(coins);
        int dp[] = new int[value + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= value; i++) {
                if (coin <= i) {
                    dp[i] += dp[i - coin];
                }
            }

        }
        return dp[value];
    }
}
