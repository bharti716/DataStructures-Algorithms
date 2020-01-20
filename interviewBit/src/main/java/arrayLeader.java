import java.util.ArrayList;
import java.util.Collections;

public class arrayLeader {

    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> result = new ArrayList<>();
        int max = arr[n-1];
        result.add(max);

        for(int i = n-2 ; i >= 0 ; i--){
            if(arr[i] >= max){
                result.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> result = leaders(new int[]{7,4,5,7,3} , 5);
        result.stream().forEach(x-> System.out.print(x + " "));
    }
}
