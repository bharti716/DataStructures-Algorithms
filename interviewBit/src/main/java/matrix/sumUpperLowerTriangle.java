package matrix;

public class sumUpperLowerTriangle {

    public static void main(String[] args) {
        sumUpperLower(new int[][]{
                {1, 2, 3, 13},
                {4, 5, 6, 14},
                {7, 8, 9, 15},
                {1, 5, 2, 16}
        }, 4, 4);
    }

    private static void sumUpperLower(int[][] arr, int m, int n) {
        int upper = 0, lower = 0;
        for (int i = 0 ; i < m ; i++) {
            for (int j = i ; j < n ; j++) {
                    upper += arr[i][j];
            }
        }
        System.out.println("Upper sum is " + upper);

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < i+1 ; j++) {
                lower += arr[i][j];
            }
        }
        System.out.println("Upper sum is " + lower);
    }
}
