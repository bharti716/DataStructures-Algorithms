import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.  (The values of the nodes may still be duplicates.)
 * Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
 * The right-most node is also defined by the same way with left and right exchanged.
 * <p>
 * Input:
 * 1
 * \
 * 2
 * / \
 * 3  4
 * <p>
 * Ouput:
 * [1, 3, 4, 2]
 */

public class BoundaryofBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        left(root.left, res);
        leaves(root.left, res);
        leaves(root.right, res);
        right(root.right, res);
        return res;
    }

    private void left(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) return;
        res.add(root.val);
        if (root.left == null)
            left(root.right, res);
        else
            left(root.left, res);
    }

    private void right(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.right == null)
            right(root.left, res);
        else
            right(root.right, res);
        res.add(root.val);
    }

    private void leaves(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            res.add(root.val);
        leaves(root.left, res);
        leaves(root.right, res);
    }
}
