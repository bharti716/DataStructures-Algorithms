public class dsa {

    private  static boolean isReverse(int N,int R){

        if((int) (Math.log10(N) + 1) != (int) (Math.log10(R) + 1)){
            return false ;
        }
        String number = Integer.toString(N);
        String reverse = Integer.toString(R);
        int length = number.length() ;
        int i = 0 ;
        while (length > 0) {
            if(number.charAt(length-1) != reverse.charAt(i)){
                return false ;
            }
            length-- ;
            i++ ;
        }
        return true;
    }

    private static int power(int N,int R)
    {
        if(isReverse(N, R)){
            System.out.println("MATCH !!");
        }
        else System.out.println("DON'T MATCH !!");

        return 0 ;
    }

    public static void main(String[] args) {
        int power = power(1231,2113);
        System.out.println(power);
    }
}
