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

    List<Integer> listOfIntegers = new ArrayList<>();
    
    public int kthSmallest(TreeNode root, int k) {

        inOrder(root);
        return listOfIntegers.get(k - 1);
    }

    private void inOrder(TreeNode treeNode) {
        if (Objects.nonNull(treeNode)) {
            inOrder(treeNode.left);
            listOfIntegers.add(treeNode.val);
            inOrder(treeNode.right);
        }
    }
}


// Another Solution With Recursion
class Solution {
    static int count;
    static int res;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        res = 0;
        inorder(root,k);
        return res;
    }
    private void inorder(TreeNode root, int k){
        if(root == null)
            return;
        
        inorder(root.left,k);
        count++;
        if(count == k){
            res = root.val;
            return;
        }
        inorder(root.right,k);
    }
}