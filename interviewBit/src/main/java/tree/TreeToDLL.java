package tree;


public class TreeToDLL {

    private static void printDLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    private static Node convert(Node root, Node head) {

        if (root == null) {
            return head;
        }

        head = convert(root.right, head);

        root.right = head;

        if (head != null) {
            head.left = root;
        }

        head = root;

        return convert(root.left, head);
    }

    private static Node convert(Node root) {
        Node head = null;
        return convert(root, head);
    }

    public static void main(String[] args) {
	    /* Construct below tree
		          1
		        /   \
		       /     \
		      2       3
		     / \     / \
		    4   5   6   7
	    */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root = convert(root);

        printDLL(root);
    }

}
