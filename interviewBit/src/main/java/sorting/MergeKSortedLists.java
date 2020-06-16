package sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 SEE THIS VIDEO AS WELL - https://www.youtube.com/watch?v=ihTwVc7L-Ls
 */

public class MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode(0);
        ListNode p = head;
        PriorityQueue<ListNode> minheap = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));

        for (ListNode list : lists) {
            if (list != null)
                minheap.offer(list);
        }

        while (!minheap.isEmpty()) {
            ListNode n = minheap.poll();
            p.next = n;
            p = p.next;

            if (n.next != null) {
                minheap.add(n.next);
            }
        }

        return head.next;
    }
}
