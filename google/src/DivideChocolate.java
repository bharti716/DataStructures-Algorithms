/**
  You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
  You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces using K cuts,
  each piece consists of some consecutive chunks.
  Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
  Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
*/

public class DivideChocolate {

    public int maximizeSweetness(int[] sweetness, int K) {
        int sum = 0 ;
        int min = Integer.MAX_VALUE ;
        for(int n : sweetness){
            sum += n ;
            min = Math.min(min , n);
        }

        int left = min ;
        int right = sum ;
        while(left < right){
            int mid = left + (right - left + 1)/2 ;
            if(canDivide(sweetness, mid , K)){
                left = mid  ;
            }
            else {
                right = mid - 1 ;
            }
        }

        return left ;
    }

    public boolean canDivide(int[] array , int val , int k ){
        int sum = 0 ;
        int count = 1 ;
        for(int n : array){
            sum += n ;
            if(sum >= val){
                count++ ;
                sum = 0 ;
            }
        }
        return count >= k + 1 ;
    }

}
