package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 23, 12, 9, 30, 2, 50};
        int n = 7;
        int k = 3;

        findKthLargest(arr, n, k);

    }

    private static void findKthLargest(int[] arr, int n, int k) {

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((minheap.size() == k)) {
                if (minheap.peek() < arr[i]) {
                    minheap.poll();
                    minheap.add(arr[i]);
                }
            } else {
                minheap.add(arr[i]);
            }
        }

        while (!minheap.isEmpty()) {
            list.add(minheap.peek());
            minheap.poll();
        }

        for(int i = list.size() - 1; i >= 0; i--)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }
}

