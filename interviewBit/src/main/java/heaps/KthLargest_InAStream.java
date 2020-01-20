package heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest_InAStream {

    public static void main(String[] args) {

        int arr[] = new int[]{1 ,2 ,3 ,4 ,5 ,6};
        int n = 6;
        int k = 4;

        findKthLargestStream(arr, n, k);
    }

    private static void findKthLargestStream(int[] arr, int n, int k) {

        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k - 1; i++) {
            pq.add(arr[i]);
            System.out.print("-1 ");
        }
        pq.add(arr[k - 1]);
        System.out.print(pq.peek() + " ");
        for (int i = k; i < n; i++) {
            if (pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
            System.out.print(pq.peek() + " ");
        }
    }
}
