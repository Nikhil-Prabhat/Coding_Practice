class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Integer> num1Map = new HashMap<>();
        Map<Integer, Integer> num2Map = new HashMap<>();

        Arrays.stream(nums1).forEach(
                num1 -> num1Map.put(num1, 0)
        );

        Arrays.stream(nums2).forEach(
                num2 -> num2Map.put(num2, 0)
        );


        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> resultList1 = new ArrayList<>();
        List<Integer> resultList2 = new ArrayList<>();

         Arrays.stream(nums1)
                .filter(num1 -> !num2Map.containsKey(num1) && !resultList1.contains(num1))
                .forEach(
                        num1 -> resultList1.add(num1)
                );

        Arrays.stream(nums2)
                .filter(num2 -> !num1Map.containsKey(num2) && !resultList2.contains(num2))
                .forEach(
                        num2 -> resultList2.add(num2)
                );

        resultList.add(resultList1);
        resultList.add(resultList2);

        return resultList;
    }
}