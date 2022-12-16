import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int arrVal : arr) {
            map.put(arrVal, map.getOrDefault(arrVal, 0) + 1);
        }

        Collection<Integer> valuesList =  map.values();
        Set<Integer> valuesSetList = new HashSet<>(valuesList);

        return valuesList.size() == valuesSetList.size() ? Boolean.TRUE : Boolean.FALSE;
    }
}