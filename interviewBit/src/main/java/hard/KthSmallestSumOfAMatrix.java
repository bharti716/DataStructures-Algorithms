package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthSmallestSumOfAMatrix {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3, 11}, {2, 4, 6}};
        int sol = kthSmallest(arr, 5);
        System.out.println("solution is :  " + sol);

    }

    public static int kthSmallest(int[][] mat, int k) {

        List<Integer> total = new ArrayList<>();
        List<Integer> recur = new ArrayList<>();

        backtrack(mat, 0,  recur, total);

        Collections.sort(total);
        return k <= total.size() ? total.get(k - 1) : -1;

    }

    public static void backtrack(int[][] mat, int row, List<Integer> recur, List<Integer> total) {

        if (recur.size() == mat.length) {
            int result = 0;
            for (int x : recur) {
                result += x;
            }
            total.add(result);
            return;
        }

        if (row < 0 || row >= mat.length) {
            return;
        }
        for (int j = 0; j < mat[0].length; j++) {
            recur.add(mat[row][j]);
            backtrack(mat, row + 1, recur, total);
            recur.remove(recur.size() - 1);
        }
    }
}
