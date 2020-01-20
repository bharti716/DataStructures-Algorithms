package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianInAStream {


    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap  = new PriorityQueue<>(Comparator.reverseOrder());

    private static void addNum(int num) {

        minHeap.add(num);
        maxHeap.add(minHeap.poll());

        if(minHeap.size() < maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }

    private static void findMedian() {
        if(minHeap.size() > maxHeap.size()){
            System.out.println("median is - " + minHeap.peek()) ;
        }else {
            System.out.println("median is - " + (minHeap.peek()+maxHeap.peek())/2.0 ) ;
        }
    }
    public static void main(String[] args) {
        addNum(5);
        addNum(10);
        findMedian();
        addNum(15);
        findMedian();
    }


}
