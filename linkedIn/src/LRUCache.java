import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 ) -- 2 is capacity
 * <p>
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(key);
            addHead(key, node.val);
            return node.val;
        } else return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(key);
            addHead(key, value);
        } else {
            addHead(key, value);
        }
    }

    private void remove(int key) {
        Node cur = map.get(key);
        Node prev = cur.prev;
        Node next = cur.next;
        prev.next = next;
        next.prev = prev;
        size--;
        map.remove(key);
    }

    private void addHead(int key, int val) {
        Node node = new Node(key, val);
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
        map.put(key, node);
        size++;
        if (size > capacity) {
            Node preTail = tail.prev;
            remove(preTail.key);
        }
    }

}
