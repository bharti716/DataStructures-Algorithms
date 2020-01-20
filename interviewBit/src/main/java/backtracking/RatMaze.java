package backtracking;

public class RatMaze {
    public static void main(String[] args) {
        int arr[][] = {
                {2, 1, 0, 0},
                {3, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1}};

        int n = 4;

        int sol[][] = new int[n][n];
        solve(arr, sol, n);
    }

    private static boolean solve(int[][] arr, int[][] sol, int n) {

        if (!solveUtil(arr, sol, 0, 0, n)) {
            System.out.print("Solution doesn't exist");
            return false;
        }
        printSolution(sol, n);
        return true;

    }

    private static void printSolution(int[][] sol, int N) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(" %d ", sol[i][j]);
            }
            System.out.print("\n");
        }
    }

    private static boolean solveUtil(int[][] maze, int[][] sol, int x, int y, int N) {

        if (x == N - 1 && y == N - 1) {
            return true;
        }

        if (isSafe(x, y, maze, N)) {
            sol[x][y] = 1;

            for (int i = 1; i <= maze[x][y]; i++) {
                if (solveUtil(maze, sol, x, y + i, N)) {
                    return true;
                }
                if (solveUtil(maze, sol, x + i, y, N)) {
                    return true;
                }
            }

            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    private static boolean isSafe(int p, int q, int[][] arr, int N) {

        if (p >= 0 && p < N && q >= 0 &&
                q < N && arr[p][q] != 0) {
            return true;
        }

        return false;
    }
}
