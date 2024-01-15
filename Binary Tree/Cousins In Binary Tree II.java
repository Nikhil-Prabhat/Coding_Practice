// Accepted Solution
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Map<TreeNode, List<Integer>> map = new HashMap<>();
        root.val = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            map = new HashMap<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                map.put(cur, new ArrayList<>());
                if(cur.left != null) {
                    sum += cur.left.val;
                    q.add(cur.left);
                    map.get(cur).add(cur.left.val);
                }
                if(cur.right != null) {
                    sum += cur.right.val;
                    q.add(cur.right);
                    map.get(cur).add(cur.right.val);
                }
            }
            for(Map.Entry<TreeNode,List<Integer>> entry : map.entrySet()) {
                if(entry.getValue().size() == 2) {
                    int num = entry.getValue().get(0)+entry.getValue().get(1);
                    entry.getKey().left.val = sum - num;
                    entry.getKey().right.val = sum - num;
                } else if(entry.getValue().size() == 1) {
                    if(entry.getKey().left != null) entry.getKey().left.val = sum - entry.getValue().get(0);
                    else if(entry.getKey().right != null) entry.getKey().right.val = sum - entry.getValue().get(0);
                }
            }
        }
        return root;
    }
}

// Tried Solution

class Solution {
    Map<Integer, Integer> parentMap = new HashMap<>();
    Map<Integer, Integer> depthMap = new HashMap<>();
    Map<Integer, Integer> cousinSumMap = new HashMap<>();
    Integer sumOfCousins = 0;

    public TreeNode replaceValueInTree(TreeNode root) {

        findDepthAndParent(root, 0, -1);
        iterateTreeAndGetSumOfCousinsForNode(root, root);

        // Update values
        inOrderTraversal(root);
        return root;
    }

    private void iterateTreeAndGetSumOfCousinsForNode(TreeNode treeNode, TreeNode root) {
        if (Objects.nonNull(treeNode)) {
            iterateTreeAndGetSumOfCousinsForNode(treeNode.left, root);

            sumOfCousins = 0;
            iterateTreeAndFindSumOfCousins(root, depthMap.get(treeNode.val), parentMap.get(treeNode.val));
            cousinSumMap.put(treeNode.val, sumOfCousins);

            iterateTreeAndGetSumOfCousinsForNode(treeNode.right, root);
        }
    }

    private void findDepthAndParent(TreeNode treeNode, int depth, int parent) {
        if (Objects.nonNull(treeNode)) {
            parentMap.put(treeNode.val, parent);
            depthMap.put(treeNode.val, depth);

            findDepthAndParent(treeNode.left, depth + 1, treeNode.val);
            findDepthAndParent(treeNode.right, depth + 1, treeNode.val);
        }
    }

    private void iterateTreeAndFindSumOfCousins(TreeNode treeNode, int currentNodeDepth, int currentNodeParent) {
        if (Objects.nonNull(treeNode) && depthMap.get(treeNode.val) <= currentNodeDepth) {
            iterateTreeAndFindSumOfCousins(treeNode.left, currentNodeDepth, currentNodeParent);

            if (parentMap.get(treeNode.val) != currentNodeParent && depthMap.get(treeNode.val) == currentNodeDepth) {
                sumOfCousins += treeNode.val;
            }

            iterateTreeAndFindSumOfCousins(treeNode.right, currentNodeDepth, currentNodeParent);
        }
    }

    private void inOrderTraversal(TreeNode treeNode) {
        if (Objects.nonNull(treeNode)) {
            inOrderTraversal(treeNode.left);
            treeNode.val = cousinSumMap.get(treeNode.val);
            inOrderTraversal(treeNode.right);
        }

    }
}