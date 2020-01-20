package backtracking;


import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        int arr[] = new int[]{2, 4, 6, 8};
        int k = 8;

        List<List<Integer>> res = combinationSum(arr,k);
        printSum(res);

    }

    private static void printSum(List<List<Integer>> res) {

        for(List<Integer> outer : res){
            for(Integer inner : outer){
                System.out.print(inner + " ");
            }
            System.out.print("\n");
        }
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, 0, target, 0, temp, result);
        return result;
    }

    private static void helper(int[] candidates, int start, int target, int sum,
                        List<Integer> list, List<List<Integer>> result){
        if(sum>target){
            return;
        }

        if(sum==target){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<candidates.length; i++){
            list.add(candidates[i]);
            helper(candidates, i, target, sum+candidates[i], list, result);
            list.remove(list.size()-1);
        }
    }
}
