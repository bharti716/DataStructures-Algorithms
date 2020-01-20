package searching;

public class medianOfSortedArraysEfficient {

    public static void main(String[] args) {
        double result = findMedian(new int[]{1, 3, 8, 9, 15}, 5, new int[]{7, 11, 18, 19, 21, 25}, 6);
        System.out.println(result);
    }

    static int maximum(int a, int b) {
        return a > b ? a : b;
    }

    static int minimum(int a, int b) {
        return a < b ? a : b;
    }

    private static double findMedian(int[] a, int n, int[] b, int m) {
        int min_index = 0, i = 0, j = 0, median = 0;
        int max_index = n;
        while (min_index < max_index) {
            i = (min_index + max_index) / 2;
            j = (n + m + 1) / 2 - i;

            if (i < max_index && b[j - 1] > a[i]) {
                min_index = i + 1;
            } else if (i > min_index && a[i - 1] > b[j]) {
                max_index = i - 1;
            } else {
                if (i == 0)
                    median = b[j - 1];
                else if (j == 0)
                    median = a[i - 1];
                else
                    median = maximum(a[i - 1],
                            b[j - 1]);
                break;
            }
        }
        if ((n + m) % 2 == 1)
            return (double) median;

        if (i == n)
            return (median + b[j]) / 2.0;

        if (j == m)
            return (median + a[i]) / 2.0;

        return (median + minimum(a[i],
                b[j])) / 2.0;

    }
}
