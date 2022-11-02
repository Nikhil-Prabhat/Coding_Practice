class Solution {
    
    public static int count = 0;
    public static int sum = 0;
    public List<Integer> list = new ArrayList<>();
    
    public int averageOfSubtree(TreeNode root) {
        inOrder(root);
        int tempCount = count;
        count = 0;
        return tempCount;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            calculateSum(root);
            list.stream().forEach(
                    num -> {
                        sum += num;
                    }
            );
            int avg = (int) Math.floor(sum / list.size());
            if (avg == root.val)
                count++;
            list.clear();
            sum=0;
            inOrder(root.left);
            inOrder(root.right);
        }
    }

    public void calculateSum(TreeNode root) {
        if (root != null) {
            calculateSum(root.left);
            list.add(root.val);
            calculateSum(root.right);
        }
    }
}