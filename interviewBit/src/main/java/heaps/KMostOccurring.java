package heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostOccurring {
    public static void main(String[] args) {

        int arr[] = new int[]{3, 1, 4, 4, 3, 1, 6, 1, 4, 4, 5};
        int n = 11;
        int k = 3;

        findK_MostOccur(arr, n, k);
    }

    static class Pair {
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

    }

    static class PairComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.freq == o2.freq) {
                return Integer.compare(o2.num, o1.num);
            }

            if (o1.freq < o2.freq) return -1;
            return 1;
        }
    }

    private static void findK_MostOccur(int[] arr, int n, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>(new PairComparator());

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            int number = mp.getKey();
            int frequency = mp.getValue();
            if (queue.size() == k) {
                if (frequency > queue.peek().freq) {
                    queue.poll();
                    queue.add(new Pair(number, frequency));
                }
            } else queue.add(new Pair(number, frequency));

        }
        for(int i = 0 ; i < k ; i++) {
            System.out.println("result is - " + queue.peek().num + " , " + queue.peek().freq);
            queue.remove();
        }

    }

}
