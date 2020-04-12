
/**
 Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 Input: root = [4,2,5,1,3], target = 3.714286
 Output: 4
 */


public class ClosestBinarySearchTreeValue {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int closestValue(TreeNode root, double target) {
        int val, closest = root.val;
        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root =  target < root.val ? root.left : root.right;
        }
        return closest;
    }
}
