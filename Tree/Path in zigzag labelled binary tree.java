class Solution {
    /*
     *  Since the tree is zig-zag, so the parent of a node in the zig-zag tree will be the parent of the complement of the node
     *  To find the complement of a node : ( 3 * lastLevelValue - label - 1 )
     *  Way to derive this formula : https://www.youtube.com/watch?v=2Hn_dhDbHRE
     * */
    public List<Integer> pathInZigZagTree(int label) {

        List<Integer> finalList = new ArrayList<>();

        // Find the current level of the node
        int lastLevelValue = 1;
        int currentLevelValue = 0;

        while (currentLevelValue < label) {
            currentLevelValue += lastLevelValue;
            lastLevelValue *= 2;
        }

        lastLevelValue /= 2;

        // Implement the formula to get the path
        while (label != 1) {
            finalList.add(label);
            int complement = (3 * lastLevelValue - label - 1);
            int parent = (int) Math.floor(complement / 2);
            label = parent;
            lastLevelValue /= 2;
        }

        finalList.add(1);
        Collections.reverse(finalList);
        return finalList;
    }
}