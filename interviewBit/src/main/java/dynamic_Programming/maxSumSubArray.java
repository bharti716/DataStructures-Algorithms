package dynamic_Programming;

public class maxSumSubArray {

    public static void main(String[] args) {
        int arr[] = new int[]{-2 ,-3 ,4 ,-1 ,-2 ,1 ,5 ,-3};
        int n = 8;
        System.out.println("the result is - " + func(arr, n));
    }

    private static int func(int[] arr, int n) {
        int leftArr[] = new int[n];
        int rightArr[] = new int[n];
        int currSum ;
        leftArr[0] = arr[0];
        for(int i = 1 ; i < n ; i++){
            currSum = leftArr[i-1] + arr[i];
            leftArr[i] = Math.max(arr[i] , currSum) ;
        }


        rightArr[n-1] = arr[n-1];
        int max_so_far = Integer.MIN_VALUE;
        for(int i = n-2 ; i >= 0 ; i--){
            currSum = rightArr[i+1] + arr[i];
            max_so_far = Math.max(max_so_far,currSum);
            rightArr[i] = Math.max(arr[i] , currSum) ;
        }

        int ans = max_so_far ;
        for(int k = 1 ; k < n-1 ; k++){
            ans = Math.max(ans,leftArr[k-1] + rightArr[k+1]) ;
        }
        return ans ;
    }
}
