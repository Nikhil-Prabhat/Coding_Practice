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
class Solution {
    TreeNode head = null;

    public TreeNode insertIntoBST(TreeNode root, int val) {
       if (Objects.isNull(head))
            head = root;

        if(Objects.isNull(head) && Objects.isNull(root))
        {
            root = new TreeNode(val);
            head = root;
        }

        if (root != null) {

            if (root.val > val && root.left != null)
                insertIntoBST(root.left, val);
            else if (root.val > val && root.left == null) {
                TreeNode treeNode = new TreeNode(val);
                root.left = treeNode;
            } else if (root.val < val && root.right != null)
                insertIntoBST(root.right, val);
            else if (root.val < val && root.right == null) {
                TreeNode treeNode = new TreeNode(val);
                root.right = treeNode;
            }

        }

        return head;

    }
}