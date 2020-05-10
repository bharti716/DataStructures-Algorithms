import java.util.ArrayDeque;
import java.util.Deque;

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

    public int trap(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int curIndex = 0;

        while (curIndex < n) {

            while (!stack.isEmpty() && height[stack.peek()]
                    < height[curIndex]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;

                int h = Math.min(height[stack.peek()], height[curIndex]) - height[top];
                int dist = curIndex - stack.peek() - 1;
                res += dist * h;
            }

            stack.push(curIndex++);
        }

        return res;
    }

    public static void main(String[] args) {
        int result = trappingWater(new int[]{7,4,0,9},4);
        System.out.println(result);
    }
}