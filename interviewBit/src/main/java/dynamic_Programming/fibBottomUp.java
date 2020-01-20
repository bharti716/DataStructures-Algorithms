package dynamic_Programming;

public class fibBottomUp {

    static int fib[] = new int[100];
    public static void main(String[] args) {

        int n = 9 ;
        fib[0] = 0 ;
        fib[1] = 1 ;
        fib[2] = 1 ;
        System.out.println("result is - " + fibonacci(n));
    }

    private static int fibonacci(int n) {

        if(fib[n] > 0 ){
            return fib[n];
        }
        for(int i = 3 ; i <= n ; i++){
            fib[i] = fib[i-1] + fib[i-2] ;
        }
        return fib[n] ;
    }
}
