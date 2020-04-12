/**
 * From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).
 * Given two strings source and target, return the minimum number of subsequences of source such that their concatenation
 * equals target. If the task is impossible, return -1.
 */

public class ShortestWayToFormString {

    public int shortestWay(String source, String target) {
        int numsSubsequences = 0;
        String remaining = target;
        while (remaining.length() > 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int j = 0;
            while (i < source.length() && j < remaining.length()) {
                if (source.charAt(i++) == remaining.charAt(j)) {
                    sb.append(remaining.charAt(j++));
                }
            }
            if (sb.length() == 0) {
                return -1;
            }
            numsSubsequences++;
            remaining = remaining.substring(sb.length());
        }
        return numsSubsequences;
    }

}
