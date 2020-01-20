package binarySearchTree;


public class minDiff {

    private static BinarySTree root = null;
    private static int min_diff = Integer.MAX_VALUE;
    private static int min_diff_key = -1;

    static class BinarySTree {

        int key;
        BinarySTree left;
        BinarySTree right;

        private BinarySTree(int value) {
            this.key = value;
            this.left = null;
            this.right = null;
        }

    }

    private static BinarySTree insert(BinarySTree root, int data) {

        if (root == null) {
            root = new BinarySTree(data);
            return root;
        }

        if (data < root.key) {
            root.left = insert(root.left, data);
        } else if (data > root.key) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{9, 4, 3, 6, 5, 7, 17, 22, 20};
        int k = 18;
        for (int anArr : arr) {
            root = insert(root, anArr);
        }
        maxDiffUtil(root, k);
        System.out.println("Minimum absolute difference of a node with given target value K is : " + Math.abs(min_diff_key - k));
    }


    private static void maxDiffUtil(BinarySTree ptr, int k) {
        if (ptr == null)
            return;

        if (ptr.key == k) {
            min_diff_key = k;
            return;
        }
        if (min_diff > Math.abs(ptr.key - k)) {
            min_diff = Math.abs(ptr.key - k);
            min_diff_key = ptr.key;
        }

        if (k < ptr.key)
            maxDiffUtil(ptr.left, k);
        else
            maxDiffUtil(ptr.right, k);
    }
}
