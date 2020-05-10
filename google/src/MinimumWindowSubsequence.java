import java.util.Arrays;
import java.util.Comparator;

/**
 Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
 If there is no such window in S that covers all characters in T, return the empty string "".
 If there are multiple such minimum-length windows, return the one with the left-most starting index.
 https://www.youtube.com/watch?v=0GOyCIJ2ajQ
 */

public class MinimumWindowSubsequence {


    public static void main(String[] args) {

        int[][] intervals = {{6,30},{5,10},{15,20}};
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Arrays.stream(intervals).forEach(x-> System.out.println(x[0]));

    }

}
