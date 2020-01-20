package sorting;

public class QuickSort {

    static int partition(int arr[], int low, int high)
    {   int pivot = low;
        int l = low + 1 ;
        int r = high;
        while(l <= r){
            if( arr[l] > arr[pivot] && arr[r] < arr[pivot]){
                swap(arr,l,r);
                l++ ;
                r-- ;

            }
            if(arr[l] <= arr[pivot]){
                l++ ;
            }
            if(arr[r] >= arr[pivot]){
                r-- ;
            }
        }
        swap(arr, pivot , r) ;
        return r ;
    }
    static void swap( int arr[] , int i , int j){
        int temp ;
        temp =  arr[i];
        arr[i] = arr[j];
        arr[j]  = temp ;
    }
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {

            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
//        int arr[] = {411, 575 ,686, 364, 887, 183};
        int arr[] = {1, 1 ,1, 0, 1, 0};
        int n = arr.length;
        quickSort(arr,0,n-1);
        System.out.println("sorted array");
        printArray(arr);

    }
}
