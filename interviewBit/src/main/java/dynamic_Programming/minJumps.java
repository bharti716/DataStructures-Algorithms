package dynamic_Programming;

import java.util.Arrays;

public class minJumps {

    public static void main(String[] args) {
        int n = 11 ;
        int arr[] = new int[]{1 ,3 ,5 ,8 ,9 ,2 ,6 ,7 ,6 ,8 ,9} ;
        System.out.println("result is - " + minNoOfJumps(arr,n));
    }

    private static int minNoOfJumps(int[] arr, int n) {
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = 0 ;
        dp[1] = 1 ;
        int maxRange ;
        int jumps ;
        int j ;
        for(int i = 2 ; i < n ; i++){
            j = 0 ;
            jumps = 0 ;
            while(j < i) {
                maxRange = arr[j] ;
                if((j+maxRange) >= i) {
                    j = j + (i-j) ;
                }
                else{
                    j = maxRange ;
                }
                jumps = jumps + 1 ;
            }
            dp[i] = jumps ;
        }
        return dp[n-1] ;
    }
}
