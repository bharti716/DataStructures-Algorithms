public class power {

    private static long power(int N,int R)
    {
        int C = 1000000007 ;
        if (N == 0)
            return 0;
        if (R == 0)
            return 1;

        // If B is even
        long y;
        if (R % 2 == 0)
        {
            y = power(N, R / 2);
            y = (y * y) % C;
        }

        // If B is odd
        else
        {
            y = N % C;
            y = (y * power(N, R - 1) % C) % C;
        }

        return ((y + C) % C);

    }

    public static void main(String[] args) {
        long res = power(12,21);
        System.out.println(res);
    }
}
