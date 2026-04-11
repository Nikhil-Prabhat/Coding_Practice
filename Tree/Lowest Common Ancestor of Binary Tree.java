class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (Objects.isNull(root)) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftSubTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSubTree = lowestCommonAncestor(root.right, p, q);

        if (Objects.nonNull(leftSubTree) && Objects.nonNull(rightSubTree)) {
            return root;
        }

        return Objects.isNull(leftSubTree) ? rightSubTree : leftSubTree;
    }
}
