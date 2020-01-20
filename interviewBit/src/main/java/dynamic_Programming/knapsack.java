package dynamic_Programming;

public class knapsack {

    public static void main(String[] args) {
        int n = 3;
        int w = 4;
        int val[] = new int[]{1, 2, 3};
        int wt[] = new int[]{4, 5, 1};
        System.out.println("result is - " + maxValue(n, w, val, wt));
    }

    private static int maxValue(int n, int W, int[] val, int[] wt) {

        int K[][] = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w){
                    K[i][w] = Math.max(K[i-1][w],val[i-1] + K[i-1][w-wt[i-1]]);
                }
                else {
                    K[i][w] = K[i-1][w] ;
                }
            }
        }

        return K[n][W];
    }
}
