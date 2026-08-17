class Solution {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int[] errorArr = new int[2];

        Arrays.stream(nums)
                .forEach(
                        num -> {
                            if (Objects.nonNull(numMap.get(num))) {
                                errorArr[0] = num;
                            } else {
                                numMap.put(num, 1);
                            }
                        });

        int updatedNum = IntStream.rangeClosed(1, nums.length)
                .filter(num -> Objects.isNull(numMap.get(num)))
                .findFirst()
                .getAsInt();

        errorArr[1] = updatedNum;
        return errorArr;
    }
}
