package binarySearchTree;

import java.util.Arrays;
import java.util.List;

public class SmallerOnRight {

    static class TreeNode {

        int key;
        int lessThan;
        TreeNode left;
        TreeNode right;

        private TreeNode(int value, int lessThan) {
            this.key = value;
            this.left = null;
            this.right = null;
            this.lessThan = lessThan;
        }

    }

    private static void countSmaller(int[] nums) {
        TreeNode root = null;
        List<Integer> a1;
        if (nums == null) {
            System.out.println("Array is empty");
        }
        Integer result[] = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, nums[i], i, 0, result);
        }
        a1 = Arrays.asList(result);
        for (Integer key : a1) {
            System.out.print(key + " ");
        }

    }

    private static TreeNode insert(TreeNode root, int value, int index, int sum, Integer[] result) {

        if (root == null) {
            result[index] = sum;
            return new TreeNode(value, 0);
        }
        if (value < root.key) {
            root.lessThan++;
            root.left = insert(root.left, value, index, sum, result);

        } else {
            if (value != root.key) {
                root.right = insert(root.right, value, index, sum + root.lessThan + 1, result);
            } else {
                root.right = insert(root.right, value, index, sum + root.lessThan, result);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{10, 6, 9, 7, 20, 19, 21, 18, 17, 16};
        countSmaller(arr);

    }
}