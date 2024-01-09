class Solution {
    /*
    * CASE 1 : If the val is greater than the current root node, then the entire tree will be the left of the new root
    * CASE 2 : If the val is smaller than the current root node, then the new value will always be added on the right of the root.
    * */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {

        if (Objects.isNull(root)) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            root = newRoot;
            return root;
        }

        if (val < root.val) {
            TreeNode rightNode = insertIntoMaxTree(root.right, val);
            root.right = rightNode;
            return root;
        }

        return null;

    }
}