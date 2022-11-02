class Solution {
    
    public int sumOfEvenGrandparent = 0;

    public int sumEvenGrandparent(TreeNode root) {

        calculateSumOfEvenGrandparent(root, null, null);
        return sumOfEvenGrandparent;
    }

    private void calculateSumOfEvenGrandparent(TreeNode current, TreeNode parent, TreeNode grandparent) {
        if (current == null)
            return;
        if (grandparent != null && grandparent.val % 2 == 0)
            sumOfEvenGrandparent += current.val;
        calculateSumOfEvenGrandparent(current.left, current, parent);
        calculateSumOfEvenGrandparent(current.right, current, parent);
    }
}