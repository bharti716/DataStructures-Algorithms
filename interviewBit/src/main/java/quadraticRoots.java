public class quadraticRoots {

    public static int exactly3Divisors(int N)
    {
        if(N <= 1 ){
            return 0 ;
        }

        int count = 0;
        for(int i = 2 ; i <= N ; i++){
            if( (isPerfect(i)) && (isPrime((int) Math.sqrt(i)))){
                count++ ;
            }
        }
        return count ;
    }

    private static boolean isPerfect(int k){
        double res = Math.sqrt(k);
        return res-Math.floor(res) == 0 ;
    }

    private static boolean isPrime(int i) {

        if(i == 2){
            return true ;
        }
        for(int j = 2 ; j*j <= i ; j++) {
            if(i%j == 0) {
                return false;
            }
        }
        return true ;
    }

    public static void main(String[] args) {
        int re = exactly3Divisors(999999);
        System.out.println(re);
    }
}
