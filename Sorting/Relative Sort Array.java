class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
       int[] finalArray = new int[arr1.length];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // Sort the first array and add the index of first distinct element of arr2 in map
        Arrays.sort(arr1);
        for (int i = 0; i < arr2.length; i++)
            for (int j = 0; j < arr1.length; j++)
                if (arr1[j] == arr2[i] && !map.containsKey(arr2[i]))
                    map.put(arr2[i], j);

        // First sort the arr1 as per the relative ordering of elements of arr2
        for (int i = 0; i < arr2.length; i++) {
            int localIndex = map.get(arr2[i]);
            for (; localIndex < arr1.length && arr1[localIndex] == arr2[i]; localIndex++) {
                finalArray[index++] = arr1[localIndex];
            }
        }

        // Element not present in arr2 should be appended at the end of the array in sorted order
        for (int i = 0; i < arr1.length; i++) {
            if (!map.containsKey(arr1[i]))
                finalArray[index++] = arr1[i];
        }

        return finalArray; 
    }
}