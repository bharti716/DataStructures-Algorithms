import java.util.ArrayDeque;
import java.util.Deque;

public class trappingRainWater {

    static int trappingWater(int arr[], int N) {

        int n = arr.length;
        if(n < 3) return 0 ;

        int lmax = arr[0];
        int rmax = arr[n-1];
        int total_water = 0 ;

        int i = 0 ;
        int j = n-1 ;

        while(i <= j){

            lmax = Math.max(lmax , arr[i]);
            rmax = Math.max(rmax , arr[j]);
            if(lmax >= rmax){
                total_water += (rmax - arr[j]);
                j = j - 1 ;
            }
            else {
                total_water += (lmax - arr[i]);
                i = i + 1 ;
            }
        }

        return total_water ;
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