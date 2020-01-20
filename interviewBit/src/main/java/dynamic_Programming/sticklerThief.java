package dynamic_Programming;

public class sticklerThief {
    public static void main(String[] args) {
        int arr[] = new int[]{5 ,5 ,10 ,100 ,10 ,5};
        int n = 6 ;
        System.out.println("result is - " + optimalStrategy(arr,n));
    }

    private static int optimalStrategy(int[] arr, int n) {

        if (n == 0)
            return 0;
        if (n == 1)
            return arr[0];
        if (n == 2)
            return Math.max(arr[0], arr[1]);

        int dp[] = new int[n];
        dp[0] = arr[0] ;
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i = 2 ; i < n ; i++){
            dp[i] = Math.max(arr[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
}
