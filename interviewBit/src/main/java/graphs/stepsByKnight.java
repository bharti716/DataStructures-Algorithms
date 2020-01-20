package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class stepsByKnight {

    public static class Cell {
        int x;
        int y;
        int dis;

        public Cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public static void main(String[] args) {


        try (Scanner scan = new Scanner(System.in)) {
            int t = scan.nextInt();

            for (int i = 0; i < t; i++) {
                int n = scan.nextInt();
                int k1 = scan.nextInt() - 1;
                int k2 = scan.nextInt() - 1;
                int t1 = scan.nextInt() - 1;
                int t2 = scan.nextInt() - 1;

                Cell tt = new Cell(t1, t2, 0);
                Cell k = new Cell(k1, k2, 0);

                boolean[][] visited = new boolean[n][n];
                visited[k1][k2] = true;

                System.out.println(check(tt, k, visited));
            }
        }
    }

    private static boolean isInside(int x, int y, int n) {
        if (x >= 0 && x < n && y >= 0 && y < n) {
            return true;
        }
        return false;
    }

    private static int check(Cell t, Cell k, boolean[][] visited) {
        int[] xl = {-2, -2, 2, 2, -1, -1, 1, 1};
        int[] yl = {-1, 1, -1, 1, 2, -2, 2, -2};

        Queue<Cell> queue = new LinkedList<>();
        queue.offer(k);
        while (!queue.isEmpty()) {
            Cell temp = queue.poll();
            if(temp.x == t.x && temp.y == t.y){
                return temp.dis ;
            }
            for(int i=0;i<8;i++) {
                int xc = temp.x + xl[i];
                int yc = temp.y + yl[i];

                if(isInside(xc, yc, visited.length) && !visited[xc][yc]) {
                    visited[xc][yc] = true;
                    queue.offer(new Cell(xc, yc, temp.dis+1));
                }
            }
        }
        return 1;
    }
}
