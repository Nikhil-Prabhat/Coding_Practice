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
   public TreeNode pruneTree(TreeNode root) {

        TreeNode treeNode = checkIfTheSubtreeContainsNodeAs0(root);
        return treeNode;
    }

    public TreeNode checkIfTheSubtreeContainsNodeAs0 (TreeNode treeNode){

        // If the node is null
        if(Objects.isNull(treeNode))
            return null;

        // If the node is 1, no need to check
        // apply constraints for the node 0
        if(Objects.nonNull(treeNode)) {
            TreeNode leftSubTree = checkIfTheSubtreeContainsNodeAs0(treeNode.left);
            TreeNode rightSubTre = checkIfTheSubtreeContainsNodeAs0(treeNode.right);

            if(treeNode.val == 0 && Objects.isNull(leftSubTree) && Objects.isNull(rightSubTre))
                return null;
            else {
                TreeNode intermediateTreeNode = new TreeNode();
                intermediateTreeNode.val = treeNode.val;
                intermediateTreeNode.left = leftSubTree;
                intermediateTreeNode.right = rightSubTre;
                return intermediateTreeNode;
            }
        }

        return null;
    }
}