package tree;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

// Data structure to store a Binary Search Tree node

class BST
{
    // Function to perform in-order traversal of the tree
    private static void inorder(Node root)
    {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Function to traverse the binary tree and store its keys in a set
    private static void extractKeys(Node root, Set set)
    {
        // base case
        if (root == null) {
            return;
        }

        extractKeys(root.left, set);
        set.add(root.data);
        extractKeys(root.right, set);
    }

    // Function to put back keys in set in their correct order in BST
    // by doing in-order traversal
    private static void convertToBST(Node root, Iterator<Integer> it)
    {
        if (root == null) {
            return;
        }

        convertToBST(root.left, it);
        root.data = it.next();
        convertToBST(root.right, it);
    }

    // main function
    public static void main(String[] args)
    {
		/* Construct below tree
			  8
			/   \
		   /	 \
		  3	   5
		 / \	 / \
		/   \   /   \
	   10	2 4	 6   */

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(10);
        root.left.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(6);

        // traverse the binary tree and store its keys in a set
        Set<Integer> set = new TreeSet<>();
        extractKeys(root, set);

        // put back keys present in set in their correct order in BST
        Iterator<Integer> it = set.iterator();
        convertToBST(root, it);

        // print the BST
        inorder(root);
    }
}