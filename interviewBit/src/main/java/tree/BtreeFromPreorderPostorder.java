package tree;

public class BtreeFromPreorderPostorder {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return construct(pre, 0, pre.length - 1, post, 0, pre.length - 1);
    }

    private TreeNode construct(int[] pre, int i1, int i2, int[] post, int j1, int j2) {
        if (i1 > i2 || j1 > j2) return null;
        if (i1 == i2) return new TreeNode(pre[i1]);
        int rootVal = pre[i1];
        TreeNode root = new TreeNode(rootVal);
        int leftVal = pre[i1 + 1];
        int leftIndex = 0;
        for (int i = j2 - 1; i >= j1; i--) {
            if (post[i] == leftVal) {
                leftIndex = i;
                break;
            }
        }
        root.left = construct(pre, i1 + 1, i1 + 1 + leftIndex - j1, post, j1, leftIndex);
        root.right = construct(pre, i1 + 2 + leftIndex - j1, i2, post, leftIndex + 1, j2 - 1);
        return root;
    }
}
