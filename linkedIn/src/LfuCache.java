import java.util.HashMap;
import java.util.Map;

public class LfuCache {

    class Node {
        int key, val;
        int cnt;
        Node prev, next;
        public Node(int k, int v) {
            key = k;
            val = v;
            cnt = 1;
        }
    }

    class DLList {
        Node head, tail;
        int len;
         DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            len = 0;
        }

         void addHead(Node node) {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
            map.put(node.key, node);
            len++;
        }

         void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            len--;
            map.remove(node.key);
        }

         void removeTail() {
            Node prevTail = tail.prev;
            remove(prevTail);
        }
    }

    private Map<Integer, Node> map;
    private Map<Integer, DLList> freq;
    private int size, capacity;
    private int maxFreq;

    public LfuCache(int capacity) {
        map = new HashMap<>();
        freq = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        maxFreq = 0;
    }

    private int get(int key) {
        if (map.get(key) == null) return -1;

        Node node = map.get(key);
        int prevFreq = node.cnt;
        DLList prevList = freq.get(prevFreq);
        prevList.remove(node);

        int curFreq = prevFreq + 1;
        maxFreq = Math.max(maxFreq, curFreq);
        DLList curList = freq.getOrDefault(curFreq, new DLList());
        node.cnt++;
        curList.addHead(node);

        freq.put(prevFreq, prevList);
        freq.put(curFreq, curList);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (map.get(key) != null) {
            map.get(key).val = value;
            get(key);
            return;
        }

        Node node = new Node(key, value);
        DLList curList = freq.getOrDefault(1, new DLList());
        curList.addHead(node);
        size++;

        if (size > capacity) {
            if (curList.len > 1) {
                curList.removeTail();
            } else {
                for (int i = 2; i <= maxFreq; i++) {
                    if (freq.get(i) != null && freq.get(i).len > 0) {
                        freq.get(i).removeTail();
                        break;
                    }
                }
            }

            size--;
        }

        freq.put(1, curList);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
