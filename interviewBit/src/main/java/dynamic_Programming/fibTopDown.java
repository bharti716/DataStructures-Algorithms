package dynamic_Programming;

public class fibTopDown {

    static int cache[] = new int[100];

    private static int fibonacci(int n) {
        if (cache[n] == 0) {
            if (n <= 1) {

                cache[n] = n;

            } else {
                cache[n] = fibonacci(n - 1) + fibonacci(n - 2);
            }
        }
        return cache[n];
    }

    public static void main(String[] args) {

        int n = 9;
        cache[0] = 0;
        cache[1] = 1;

        System.out.println("result is - " + fibonacci(n));
    }
}
