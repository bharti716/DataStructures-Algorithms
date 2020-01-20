package heaps;

import java.util.PriorityQueue;

public class MinCostOfRopes {

    public static void main(String[] args) {

        int arr[] = new int[]{4 ,2 ,7 ,6 ,9};
        int n = 5;
        minCost(arr, n);
    }

    private static void minCost(int[] arr, int n) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            pq.add(arr[i]);
        }

        Long cost = new Long("0");
        while(pq.size()!=1)
        {
            int x = pq.poll();
            int y = pq.poll();
            cost += x+y;
            pq.add(x+y);
        }
        System.out.println("result is - " + cost);
    }
}
