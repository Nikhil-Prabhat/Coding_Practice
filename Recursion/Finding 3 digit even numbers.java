class Solution {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> evenNumberList = new ArrayList<>();

        int[] availableFrequenceyArr = new int[10];
        for(int digit: digits) {
            availableFrequenceyArr[digit]++;
        }

        IntStream.range(100, 999)
                .filter(num -> num % 2 == 0)
                .forEach(num -> {
                    int digitAtHundred = num / 100;
                    int digitAtTen = (num / 10) % 10;
                    int digitAtUnit = num % 10;

                    int[] neededFreqArr = new int[10];
                    neededFreqArr[digitAtHundred]++;
                    neededFreqArr[digitAtTen]++;
                    neededFreqArr[digitAtUnit]++;

                    boolean isValid = checkIfFrequencyIsValid.test(neededFreqArr, availableFrequenceyArr);
                    if(isValid) {
                        evenNumberList.add(num);
                    }
                });

        int[] resultArr = evenNumberList
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
        
        Arrays.sort(resultArr);
        return resultArr;
    }

    private BiPredicate<int[], int[]> checkIfFrequencyIsValid = (needFreqArr, availableFreqArr) -> IntStream.range(0, 10)
            .allMatch(index -> needFreqArr[index] <= availableFreqArr[index]);
}
