class Solution {
    
    Stack<Boolean> stack = new Stack<>();
    
    public boolean evaluateTree(TreeNode root) {
         // Execute dfs operation
        dfs(root);

        // Pop out the final result of the stack
        return stack.pop();
    }
    
    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            dfs(root.right);
            if (root.val == 0 || root.val == 1) {
                stack.push(root.val == 0 ? Boolean.FALSE : Boolean.TRUE);
            } else if (root.val == 2 || root.val == 3) {
                boolean topVariable = stack.pop();
                boolean secondTopVariable = stack.pop();
                boolean resultOfOperation = root.val == 2 ? topVariable || secondTopVariable : topVariable && secondTopVariable;
                stack.push(resultOfOperation);
            }
        }
    }
}