package dynamic_Programming;

public class longCommSubseq {

    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char str1[] = s1.toCharArray();
        char str2[] = s2.toCharArray();
        int n1 = s1.length();
        int n2 = s2.length();

        System.out.println("result is - " + func(str1, str2, n1, n2));
    }

    private static int func(char[] X, char[] Y, int m, int n) {

        int L[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }
}
