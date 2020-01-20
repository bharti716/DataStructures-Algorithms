public class trappingRainWater {
    // function to find the trapped water in between buildings
    // arr: input array
    // n: size of array
    static int trappingWater(int arr[], int n) {

        int left_max = 0 ;
        int high = n-1 ;
        int low = 0 ;
        int right_max = 0 ;
        int result = 0 ;
        while( low < high){
            if( arr[low] < arr[high]) {
                if (left_max < arr[low]) {
                    left_max = arr[low];

                } else
                    result += (left_max - arr[low]);
                low++ ;
            }
            else{
                if( right_max < arr[high]){
                    right_max = arr[high];
                }
                else{
                    result  = result + (right_max - arr[high]);
                }
                high-- ;
            }

        }


        return result;
    }

    public static void main(String[] args) {
        int result = trappingWater(new int[]{7,4,0,9},4);
        System.out.println(result);
    }
}