package matrix;

public class snakePattern {

    public static void main(String[] args) {
        snakePatternPrint(new int[][]{
                {1, 2, 3, 13},
                {4, 5, 6, 14},
                {7, 8, 9, 15},
                {1, 5, 2, 16}
        }, 4, 4);
    }

    private static void snakePatternPrint(int[][] arr, int m, int n) {

        for(int i = 0 ; i < m ; i++){
            if(i%2 == 0){
                for(int j = 0 ; j < n ; j++){
                    System.out.print(arr[i][j] + " ");
                }
            }
            else{
                for(int j = n-1 ; j >= 0 ; j--){
                    System.out.print(arr[i][j] + " ");
                }
            }
        }

    }
}
