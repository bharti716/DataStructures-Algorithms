import java.util.PriorityQueue;

/**
 * Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
 * The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.
 * A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).
 * <p>
 * Input: [[5,4,5],[1,2,6],[7,4,6]]
 * Output: 4
 * Explanation:
 * The path with the maximum score is highlighted in yellow.
 */

public class PathWithMaximumMinimumValue {

    class Node {
        int x;
        int y;
        int val;

        Node(int _x, int _y, int _val) {
            x = _x;
            y = _y;
            val = _val;
        }
    }

    public int maximumMinimumPath(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) return 0;
        int m = A.length, n = A[0].length;
        int min = Math.min(A[0][0], A[m - 1][n - 1]);

        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.val - a.val);
        int i = 0, j = 0;
        visited[i][j] = true;
        while (i != m - 1 || j != n - 1) {
            for (int[] dir : dirs) {
                int dx = i + dir[0];
                int dy = j + dir[1];
                if (dx >= 0 && dx < m && dy >= 0 && dy < n && !visited[dx][dy]) {
                    if (i == m - 1 && j == n - 1) return min;
                    visited[dx][dy] = true;
                    queue.offer(new Node(dx, dy, A[dx][dy]));
                }
            }
            Node next = queue.poll();
            min = Math.min(min, next.val);
            i = next.x;
            j = next.y;
        }
        return min;
    }
}
