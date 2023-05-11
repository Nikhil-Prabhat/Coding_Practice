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
   public TreeNode removeLeafNodes(TreeNode root, int target) {

        int heightOfTheTree = findHeightOfTree(root);
        while (heightOfTheTree-- > 0) {
            int heightOfUpdatedTree = findHeightOfTree(root);
            if(heightOfUpdatedTree == 1 && root.val == target)
                root = null;
            else
                inOrderDeletionOfLeafTarget(root, target, null, "root");
        }

        return root;

    }


    /* Delete the target node in the tree */
    private void inOrderDeletionOfLeafTarget(TreeNode currentNode, int target, TreeNode parentNode, String direction) {
        if (Objects.nonNull(currentNode)) {
            if (currentNode.val == target && Objects.isNull(currentNode.left) && Objects.isNull(currentNode.right)) {
                if (Objects.nonNull(parentNode)) {
                    if (direction.equals("left"))
                        parentNode.left = null;
                    else if (direction.equals("right"))
                        parentNode.right = null;
                }
            }
            inOrderDeletionOfLeafTarget(Objects.nonNull(currentNode) ? currentNode.left : null, target, currentNode, "left");
            inOrderDeletionOfLeafTarget(Objects.nonNull(currentNode) ? currentNode.right : null, target, currentNode, "right");
        }
    }

    /* Check if the two trees are identical */
    private boolean checkIdenticalTrees(TreeNode treeNode1, TreeNode treeNode2) {
        if (Objects.isNull(treeNode1) && Objects.isNull(treeNode2))
            return true;
        else if (Objects.nonNull(treeNode1) && Objects.nonNull(treeNode2)) {
            // Check for all the nodes in the same symmetry
            return treeNode1.val == treeNode2.val && checkIdenticalTrees(treeNode1.left, treeNode2.left) && checkIdenticalTrees(treeNode1.right, treeNode2.right);
        }
        return false;
    }

    /* Find Height of the Tree */
    private int findHeightOfTree(TreeNode treeNode) {
        if (Objects.isNull(treeNode))
            return 0;
        else {
            int leftHeight = 0;
            int rightHeight = 0;

            // Calculate left height
            leftHeight = findHeightOfTree(treeNode.left);

            // Calculate right height
            rightHeight = findHeightOfTree(treeNode.right);

            // Return the height maximum of the two subtrees
            int maxHeightOfTwoSubtrees = leftHeight < rightHeight ? rightHeight : leftHeight;
            return maxHeightOfTwoSubtrees + 1;
        }
    }
}