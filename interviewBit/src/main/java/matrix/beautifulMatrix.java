package matrix;

public class beautifulMatrix {

    private static int findMinOperation(int n, int mat[][]) {
        //Your code here
        return n;
    }

    public static void main(String[] args) {
        int minOperation = findMinOperation(3, new int[][]{
                {1, 2, 3},
                {4, 2, 3},
                {3, 2, 1}
        });

        System.out.println(minOperation);
    }
}
