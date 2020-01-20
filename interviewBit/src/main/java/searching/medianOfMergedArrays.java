package searching;

import java.util.Arrays;

public class medianOfMergedArrays {

    public static void main(String[] args) {
        int result = findMedian(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 6, 7, 8});
        System.out.println("ANSWER is : " + result);
    }

    private static int findMedian(int[] arr1, int[] arr2) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        int[] newArray = new int[l1 + l2];
        int i = 0 , j = 0 , k = 0;

        while(i < l1 && j < l2){

            if(arr1[i] <= arr2[j]){
                newArray[k++] = arr1[i];
                i++ ;
            }
            else if(arr1[i] > arr2[j]) {
                newArray[k++] = arr2[j];
                j++ ;
            }
        }
        if(i != l1) {
            while ( i < l1 ) {
                newArray[k++] = arr1[i];
                i++ ;
            }
        }
        else if( j != l2){
            while( j < l2){
                newArray[k++] = arr2[j];
                j++ ;
            }
        }
        Arrays.stream(newArray).forEach(x-> System.out.print( x + " "));
        int n = newArray.length ;
        return n%2 == 0 ? (newArray[n/2]+newArray[n/2-1])/2 : newArray[n/2] ;
    }
}
