package graphs;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfPathExists {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            System.out.println("value of n : \n");
            System.out.println(n);
            inputLine = br.readLine().trim().split(" ");
            System.out.println(inputLine[1]);
            int[][] arr = new int[n][n];
            int k = 0;
//            Pair s = null, d = null;
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    arr[i][j] = Integer.parseInt(inputLine[k++]);
//                    if (arr[i][j] == 1) s = new Pair(i, j);
//                    if (arr[i][j] == 2) d = new Pair(i, j);
//                }
//            }
//            System.out.println(pathExists(arr, n, s, d));
        }
    }

    private static boolean pathExists(int[][] arr, int n, Pair s, Pair d) {
        return false;
    }
}
