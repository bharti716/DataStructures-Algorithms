package graphs;

public class minKSwaps {

    private static void swap(char[] c, int i, int j) {
        char ch = c[i];
        c[i] = c[j];
        c[j] = ch;
    }


    public static int findMinimum(char[] c, int n, int k, int minSoFar) {

        String s = new String(c);


        if (s.compareTo(String.valueOf(minSoFar)) < 0) {
            minSoFar = Integer.valueOf(s);
        }

        // base case: no swaps left
        if (k < 1) {
            return minSoFar;
        }

        // do for each digit in the input string
        for (int i = 0; i < n - 1; i++) {
            // compare the current digit with remaining digits
            for (int j = i + 1; j < n; j++) {
                // if the digit at i'th index is more than the digit
                // at j'th index
                if (c[i] > c[j]) {
                    // swap c[i] and c[j]
                    swap(c, i, j);

                    // recur for remaining k - 1 swaps
                    minSoFar = findMinimum(c, n, k - 1, minSoFar);

                    // backtrack - restore the array back
                    swap(c, i, j);
                }
            }
        }
        return minSoFar;
    }

    public static void main(String[] args) {
        // input
        int i = 934651;
        int k = 3;

        char[] ch = String.valueOf(i).toCharArray();
        int minimum = findMinimum(ch, ch.length, k, i);

        System.out.println("The minimum number formed by doing at-most "
                + k + " swaps is " + minimum);
    }
}

