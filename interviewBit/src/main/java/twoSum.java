import java.util.HashMap;
import java.util.Map;

public class twoSum {

    public  static int[] twoSumFunc(int[] nums, int target) {
        int complementary ;
        int[] result = new int[2] ;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;  i < nums.length ; i++ ){
            complementary = target - nums[i];
            if(map.containsKey(complementary)){
                return new int[]{map.get(complementary),i};
            }
            map.put(nums[i],i);
        }

        return result ;

    }

    public static void main(String[] args) {
        int[] ans = twoSumFunc(new int[]{2,6,7,11,15},9);
        System.out.println("RESULT IS - " + "[" + ans[0] + "," + ans[1] + "]" );
    }

}
