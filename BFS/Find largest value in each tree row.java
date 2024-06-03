class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        if (Objects.isNull(root))
            return resultList;

        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            int maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currentNode = queue.poll();
                maxValue = Math.max(maxValue, currentNode.val);

                if (Objects.nonNull(currentNode.left)) {
                    queue.add(currentNode.left);
                }

                if (Objects.nonNull(currentNode.right)) {
                    queue.add(currentNode.right);
                }
            }

            resultList.add(maxValue);
        }

        return resultList;
    }
}