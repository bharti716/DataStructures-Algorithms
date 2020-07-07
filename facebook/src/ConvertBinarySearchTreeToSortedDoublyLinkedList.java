/**
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 * You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list.
 * For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
 * We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to
 * its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.
 * <p>
 * Input: root = [4,2,5,1,3]
 * Output: [1,2,3,4,5]
 */

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    class Node {
        int val;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    private Node first = null;
    private Node last = null;

    private void helper(Node node) {
        if (node != null) {
            // left
            helper(node.left);
            // node
            if (last != null) {
                // link the previous node (last)
                // with the current one (node)
                last.right = node;
                node.left = last;
            }
            else {
                // keep the smallest node
                // to close DLL later on
                first = node;
            }
            last = node;
            // right
            helper(node.right);
        }
    }
    public Node treeToDoublyList(Node root) {

        if (root == null) return null;

        helper(root);
        // close DLL
        last.right = first;
        first.left = last;
        return first;

    }
}
