public class reverseInteger {

    public static int reverse(int x) {
        int rev = 0 ;
        while ( x !=0) {
            int temp = x % 10 ;
            x /=10 ;
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && temp > 7)) return 0 ;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && temp < -8)) return 0 ;
            rev = rev * 10 + temp ;
        }
        return rev;
    }

    public static void main(String[] args) {
        int result = reverse(651);
        System.out.println("Ans - " + result);
    }

}
