import java.util.ArrayList;
import java.util.List;

/**
 On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D coordinate on this grid.
 Our goal is to assign a bike to each worker. Among the available bikes and workers, we choose the (worker, bike) pair
 with the shortest Manhattan distance between each other, and assign the bike to that worker.
 (If there are multiple (worker, bike) pairs with the same shortest Manhattan distance, we choose the pair with the
 smallest worker index; if there are multiple ways to do that, we choose the pair with the smallest bike index).
 We repeat this process until there are no available workers.
 The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
*/
public class CampusBikes {

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        int[] res = new int[n];
        boolean[] assigned = new boolean[n];
        boolean[] occupied = new boolean[m];
        List<int[]>[] list = new List[2001];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int dist = dist(workers[i], bikes[j]);

                if (list[dist] == null) {
                    list[dist] = new ArrayList<>();
                }

                list[dist].add(new int[]{i, j});
            }
        }

        for (int i = 0; i < 2001; i++) {
            if (list[i] == null) continue;
            int size = list[i].size();
            for (int j = 0; j < size; j++) {
                int w = list[i].get(j)[0];
                int b = list[i].get(j)[1];

                if (!assigned[w] && !occupied[b]) {
                    res[w] = b;
                    assigned[w] = true;
                    occupied[b] = true;
                }
            }
        }

        return res;
    }

    private int dist(int[] w, int[] b) {
        return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);

    }
}
