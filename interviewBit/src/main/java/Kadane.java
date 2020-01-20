public class Kadane {

    // Function to find subarray with maximum sum
    // arr: input array
    // n: size of array
    static int maxSubarraySum(int arr[], int n) {

        int curr_max = 0;
        int max_so_far = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            curr_max += arr[i];
            if (curr_max > max_so_far) {
                max_so_far = curr_max;
            }
            if (curr_max < 0) {
                curr_max = 0;
            }
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int result = maxSubarraySum(new int[]{1, 2, 3, -2, 5}, 5);
        System.out.println(result);
    }
}
