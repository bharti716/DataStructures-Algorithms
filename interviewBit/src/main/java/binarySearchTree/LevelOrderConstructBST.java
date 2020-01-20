package binarySearchTree;

/* check why queue solution given does not work */
public class LevelOrderConstructBST {

    private static BST root = null;

    static class BST {
        int data;
        BST left;
        BST right;

        BST(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{7, 4, 12, 3, 6, 8, 1, 5, 10};
        BST root = constructBST(arr);
        System.out.print( "PreOrder Traversal: ");
        preOrder(root);
    }
    private static BST insert(BST root, int data) {

        if (root == null) {
            root = new BST(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
    private static void preOrder(BST root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    private static BST constructBST(int[] arr) {

        root = new BST(arr[0]);

        for(int i = 1 ; i < arr.length ; i++){
            root = insert(root,arr[i]);
        }
        return root ;
    }
}
