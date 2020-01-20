package dynamic_Programming;

public class kadanes2 {

    public static void main(String[] args) {
        int arr[] = new int[]{4 ,5 ,6 ,7 ,8} ;
        int n = 5 ;
        System.out.println("result is - " + SumSubArr(arr,n));
    }

    private static int SumSubArr(int[] arr, int n) {
        int currSum ;
        int dp[] = new int[n];
        dp[0] = arr[0];
        dp[1] = arr[1];

        for(int i = 2 ; i < n ; i++){
                currSum = dp[i-2] + arr[i];
                dp[i] = Math.max(arr[i] , currSum) ;
        }
        return dp[n-1] ;
    }
}
