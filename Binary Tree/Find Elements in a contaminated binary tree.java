/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {

    TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;
        if (root != null) {
            root.val = 0;
            preOrderTraversal(root);
        }
    }

    public boolean find(int target) {

        return inOrder(root, target);

    }

    public void preOrderTraversal(TreeNode node) {
        if (node != null) {
            if (node.left != null)
                node.left.val = 2 * node.val + 1;
            if (node.right != null)
                node.right.val = 2 * node.val + 2;

            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public boolean inOrder(TreeNode treeNode, int target) {
        if (treeNode != null) {
            if (treeNode.val == target)
                return true;

            // If found in left, no need to go furthur
            boolean leftFound = inOrder(treeNode.left, target);
            if (leftFound)
                return true;

            // If not found in left, then check for right subtree
            boolean rightFound = inOrder(treeNode.right, target);
            return rightFound;

        } else
            return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */