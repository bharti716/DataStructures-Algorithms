package binarySearchTree;

import java.util.HashSet;
import java.util.Set;

public class BST {

    private static Node root = null;
    private static Set < Integer > set = new HashSet();

    static class Node {

        int key;
        Node left;
        Node right;

        private Node(int value) {
            this.key = value;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {
        int arr[] = new int[]{15, 10, 20, 8, 12, 16, 25, 18, 19, 30};
        for (int anArr : arr) {
            root = insert(root, anArr);
        }
        inorder(root);
        Node result = LCA(root, 16, 30);
        System.out.println("LCA of 16 and 30 - " + result.key);

        boolean res = findSumPair(root, 13, set);
        System.out.println("Is sum Pair Present - " + res);
    }

    private static boolean findSumPair(Node root, int k, Set< Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.key))
            return true;
        set.add(root.key);
        return findSumPair(root.left, k, set) || findSumPair(root.right, k, set);
    }

    private static boolean search(Node root, int x) {

        if (root == null)
            return false;

        if (root.key == x)
            return true;

        if (x > root.key) {
            return search(root.right, x);
        } else
            return search(root.left, x);
    }

    private static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    private static Node insert(Node root, int data) {

        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.key) {
            root.left = insert(root.left, data);
        } else if (data > root.key) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    private static Node LCA(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }

        if (node.key > n1 && node.key > n2) {
            return LCA(node.left, n1, n2);
        }

        if (node.key < n1 && node.key < n2) {
            return LCA(node.right, n1, n2);
        }

        return node;
    }
}
