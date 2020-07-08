package tree;

class TreeNode {
    private int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class BtreeFromInoderPostorder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode helper(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        if (l1 == r1) {
            return new TreeNode(inorder[l1]);
        }
        TreeNode node = new TreeNode(postorder[r2]);
        int idx = l1;
        for (int i = l1; i <= r1; i++) {
            if (inorder[i] == postorder[r2]) {
                idx = i;
                break;
            }
        }
        node.left = helper(inorder, l1, idx-1, postorder, l2, l2+idx-1-l1);
        node.right = helper(inorder, idx+1, r1, postorder, l2+idx-l1, r2-1);
        return node;
    }
}
