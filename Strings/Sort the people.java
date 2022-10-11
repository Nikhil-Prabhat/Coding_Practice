public class LeetCode {

    static int index = 0;
    public static void main(String[] args) {
        LeetCode leetcode = new LeetCode();
        String[] names = {"Alice", "Bob", "Bob"};
        int[] heights = {155, 185, 150};
        String[] result = leetcode.sortPeople(names, heights);

    }

    
	public String[] sortPeople(String[] names, int[] heights) {

        String[] sortedResult = new String[names.length];
        index = names.length - 1;

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        // Third parameter is for merge resolution
        // A merge function that indicates that, in the case of a collision, we keep the existing entry
        // LinkedHashMap is used because it stores the iteration order
        LinkedHashMap<Integer, String> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        sortedMap.entrySet()
                .stream()
                .forEach(
                        (entry) -> {
                            sortedResult[index--] = entry.getValue();
                        }
                );

        return sortedResult;
    }

}