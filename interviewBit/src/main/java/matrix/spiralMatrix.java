package matrix;

public class spiralMatrix {

    static void spiralMatrixPrint(int[][] arr, int m, int n) {
        int k = 0, l = 0;

        while (k < m && l < n) {

            for (int i = l; i < n; i++) {
                System.out.println(arr[k][i] + " ");
            }

            k++;

            for (int j = k; j < m; j++) {
                System.out.println(arr[j][n - 1] + " ");
            }

            n--;

            if (k < m) {
                for (int i = n - 1; i >= l; i--) {
                    System.out.println(arr[m - 1][i]);
                }
                m--;
            }

            if (l < n) {
                for (int i = m-1 ; i >= k ; i--) {
                    System.out.println(arr[i][l] + " ");
                }
                l++;
            }

        }
    }

    public static void main(String[] args) {
        spiralMatrixPrint(new int[][]{
                {1, 2, 3, 13},
                {4, 5, 6, 14},
                {7, 8, 9, 15},
                {1, 5, 2, 16}
        }, 4, 4);
    }
}
