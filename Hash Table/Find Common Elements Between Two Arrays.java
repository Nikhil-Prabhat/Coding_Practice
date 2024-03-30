class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
         Map<Integer, Boolean> nums1Map = new HashMap<>();
        Map<Integer, Boolean> nums2Map = new HashMap<>();

        Arrays.stream(nums1).forEach(
                num -> nums1Map.putIfAbsent(num, Boolean.TRUE)
        );

        Arrays.stream(nums2).forEach(
                num -> nums2Map.putIfAbsent(num, Boolean.TRUE)
        );

        int countNums1 = Arrays.stream(nums1)
                .filter(num -> nums2Map.containsKey(num))
                .reduce(0, (subtotal, element) -> ++subtotal);

        int countNums2 = Arrays.stream(nums2)
                .filter(num -> nums1Map.containsKey(num))
                .reduce(0, (subtotal, element) -> ++subtotal);

        return new int[]{countNums1, countNums2};
    }
}