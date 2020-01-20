package dynamic_Programming;

public class kadanes1 {

    public static void main(String[] args) {
        int arr[] = new int[]{5 ,-2 ,-3 ,32 ,-5 ,65} ;
        int n = 6 ;
        System.out.println("result is - " + contSumSubArr(arr,n));
    }

    private static int contSumSubArr(int[] arr, int n) {
        int currSum ;
        int currMax = arr[0] ;
        for(int i = 1 ; i < n ; i++){
            currSum = currMax + arr[i] ;
            currMax = Math.max(arr[i],currSum);
        }
        return currMax ;
    }
}
