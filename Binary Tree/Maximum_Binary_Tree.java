class Solution {
   
    class CustomTuple  {
    int key;
    int value;

    public CustomTuple(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomTuple{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

}

    
   public TreeNode constructMaximumBinaryTree(int[] nums) {

        TreeNode treeNode = constTree(nums);
        return treeNode;
    }

    private TreeNode constTree(int[] nums)
    {
        TreeNode treeNode = null;
        if(nums.length != 0)
        {
            treeNode = new TreeNode();
            CustomTuple maxTuple = findMaximum(nums);
            treeNode.val = maxTuple.key;
            treeNode.left = constTree(Arrays.copyOfRange(nums,0,maxTuple.value));
            treeNode.right = constTree(Arrays.copyOfRange(nums,maxTuple.value+1,nums.length));
        }

        return treeNode;
    }


    private CustomTuple findMaximum(int[] nums)
    {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i=0;i<nums.length;i++)
        {
            if(max < nums[i])
            {
                max = nums[i];
                index = i;
            }
        }

        return new CustomTuple(max,index);
    }
}