package heaps;


import java.util.PriorityQueue;

public class NearlySorted {

    public static void main(String[] args) {

        int arr[] = new int[]{6 ,5 ,3 ,2 ,8 ,10 ,9};
        int n = 7;
        int k = 3 ;
        OptimalSort(arr, n, k);
    }

    private static void OptimalSort(int[] arr, int n, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < k+1 ; i++){
            pq.add(arr[i]);
        }

        for(int j = k+1 ; j < n ; j++){
            System.out.print(pq.poll() + " ");
            pq.add(arr[j]);
        }

        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }
    }
}
