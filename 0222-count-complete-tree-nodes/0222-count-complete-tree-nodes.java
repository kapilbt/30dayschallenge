class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lh = 0, rh = 0;
        for (TreeNode l = root; l != null; l = l.left) lh++;
        for (TreeNode r = root; r != null; r = r.right) rh++;
        if (lh == rh) return (1 << lh) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}