package dynamic_Programming;

public class sumOfSubstrings {
    public static void main(String[] args) {
        String str = "1234" ;
        System.out.println("result is - " + subStringSum(str));
    }

    private static int subStringSum(String str) {
        int sum = 0;
        for(int i = 0 ; i <= str.length() ; i++){
            for(int j = i+1 ; j <= str.length() ; j++){
                sum = sum + Integer.parseInt(str.substring(i,j)) ;
            }
        }
        return sum ;
    }
}
