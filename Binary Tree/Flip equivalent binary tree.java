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
    
    Map<Integer, Set<Integer>> firstTreeMap = new HashMap<>();
    Map<Integer, Set<Integer>> secondTreeMap = new HashMap<>();

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        iterateTree(root1, firstTreeMap);
        iterateTree(root2, secondTreeMap);

        if(firstTreeMap.size() != secondTreeMap.size()) {
            return false;
        }

        return checkFlipEquivalent(firstTreeMap, secondTreeMap);
    }

    private void iterateTree(TreeNode treeNode, Map<Integer, Set<Integer>> map) {
        if (Objects.nonNull(treeNode)) {

            // Adding children into respective map
            if (Objects.nonNull(treeNode.left)) {
                Set<Integer> valuesSet = map.getOrDefault(treeNode.val, new HashSet<>());
                valuesSet.add(treeNode.left.val);
                map.put(treeNode.val, valuesSet);
            }

            if (Objects.nonNull(treeNode.right)) {
                Set<Integer> valuesSet = map.getOrDefault(treeNode.val, new HashSet<>());
                valuesSet.add(treeNode.right.val);
                map.put(treeNode.val, valuesSet);
            }

            if(Objects.isNull(treeNode.left) && Objects.isNull(treeNode.right)) {
                map.put(treeNode.val, new HashSet<>());
            }

            iterateTree(treeNode.left, map);
            iterateTree(treeNode.right, map);
        }
    }

    private boolean checkFlipEquivalent(Map<Integer, Set<Integer>> mapToIterate, Map<Integer, Set<Integer>> mapToCompare) {
        for (Map.Entry<Integer, Set<Integer>> map : mapToIterate.entrySet()) {
            Integer firstMapKey = map.getKey();
            Set<Integer> firstMapValues = map.getValue();
            Set<Integer> secondMapValues = mapToCompare.get(firstMapKey);
            if (!firstMapValues.equals(secondMapValues))
                return false;
        }

        return true;
    }
}