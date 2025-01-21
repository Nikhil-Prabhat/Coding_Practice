class Solution {

    List<Integer> treeSortedList = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorderTraversal(root);

        List<List<Integer>> finalResultList = queries.stream()
                .map(this::findClosestNodeForEachQuery)
                .toList();

        return finalResultList;
    }

    private List<Integer> findClosestNodeForEachQuery(Integer nodeToSearch) {
        var startIndex = 0;
        var endIndex = treeSortedList.size() - 1;

        while (startIndex <= endIndex) {
            var midIndex = startIndex + (endIndex - startIndex) / 2;
            var midIndexElement = treeSortedList.get(midIndex);

            if (midIndexElement == nodeToSearch) {
                return List.of(midIndexElement, midIndexElement);
            }

            if (midIndexElement < nodeToSearch) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }

        // Handling extreme condition
        // The indices are inverted here for min and max
        var minElement = endIndex < 0 ? -1 : treeSortedList.get(endIndex);
        var maxElement = startIndex >= treeSortedList.size() ? -1 : treeSortedList.get(startIndex);
        return List.of(minElement, maxElement);
    }

    private void inorderTraversal(TreeNode treeNode) {
        if (Objects.nonNull(treeNode)) {
            inorderTraversal(treeNode.left);
            treeSortedList.add(treeNode.val);
            inorderTraversal(treeNode.right);
        }
    }
}

// Accepted Solution

class Solution {

    TreeMap<Integer, Boolean> treeMap = new TreeMap<>();
    
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        treeTraversal(root);
        return queries.stream()
                .map(
                        query -> {
                            Integer minValue = Optional.ofNullable(treeMap.floorKey(query)).orElse(-1);
                            Integer maxValue = Optional.ofNullable(treeMap.ceilingKey(query)).orElse(-1);
                            return List.of(minValue, maxValue);
                        })
                .toList();
    }

    private void treeTraversal(TreeNode treeNode) {
        if (Objects.nonNull(treeNode)) {
            treeMap.put(treeNode.val, true);

            treeTraversal(treeNode.left);
            treeTraversal(treeNode.right);
        }
    }
}
