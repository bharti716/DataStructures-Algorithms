package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinRoomsRequired {

    public static void main(String[] args) {
        int start[] = new int[]{1, 3, 0, 5, 8, 5};
        int finish[] = new int[]{2, 4, 6, 7, 9, 9};
        int n = 6;

        System.out.println("result is  - " + roomsRequired(start, finish, n));
    }

    static class Meeting implements Comparator<Meeting> {

        int start;
        int finish;

        private Meeting(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public int compare(Meeting o1, Meeting o2) {
            return o1.start - o2.start;
        }
    }

    private static int roomsRequired(int[] start, int[] finish, int n) {
        Meeting interval[] = new Meeting[n];
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.finish));
        for (int i = 0; i < n; i++) {
            interval[i] = new Meeting(start[i], finish[i]);
        }
        Arrays.sort(interval, Comparator.comparingInt(a -> a.start));
        minHeap.add(interval[0]);

        for (int i = 1; i < interval.length; i++) {
            Meeting curr = interval[i];
            Meeting earliest = minHeap.remove();
            if (curr.start >= earliest.finish) {
                earliest.finish = curr.finish;
            } else minHeap.add(curr);

            minHeap.add(earliest);
        }
        return minHeap.size();
    }
}
