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
    int ind = 0;
   public TreeNode bstFromPreorder(int[] preorder) {
        return createBST(preorder,Integer.MAX_VALUE);
    }

    private TreeNode createBST(int[] A, int bound)
    {
        if(ind == A.length || A[ind] > bound)
            return null;

        TreeNode treeNode = new TreeNode(A[ind++]);
        treeNode.left = createBST(A,treeNode.val);
        treeNode.right = createBST(A,bound);

        return treeNode;
    }
}