package greedy;

public class ActivitySelection {

    public static void main(String[] args) {
        int start[] = new int[]{1, 3, 2, 5, 8, 5};
        int finish[] = new int[]{2, 4, 6, 7, 9, 9};
        int n = 6;

        maxActivity(start, finish, n);
    }

    private static void maxActivity(int[] s, int[] f, int n) {

        int i, j;

        System.out.print("Following activities are selected : n - ");

        i = 0;
        System.out.print(i + " ");

        for (j = 1; j < n; j++) {
            if (s[j] >= f[i]) {
                System.out.print(j + " ");
                i = j;
            }
        }
    }
}
