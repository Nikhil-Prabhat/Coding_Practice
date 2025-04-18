class Solution {
    public int countArrangement(int n) {
        List<List<Integer>> permutationList = new ArrayList<>();
        Boolean[] numIfVisitedArr = new Boolean[n + 1];

        List<Integer> numberList = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toList());

        numberList.forEach(
                currentNum -> {
                    Arrays.fill(numIfVisitedArr, false);
                    List<Integer> currentList = new ArrayList<>();
                    currentList.add(currentNum);
                    numIfVisitedArr[currentNum] = true;
                    generatePermutation(permutationList, currentNum, currentList, numberList, numIfVisitedArr);
                }
        );

        int countOfBeautifulArrangement = (int) permutationList.stream().filter(numList -> isBeautifulArrangement(numList)).count();
        return countOfBeautifulArrangement;
    }

    private void generatePermutation(List<List<Integer>> permutationList, int currentNum, List<Integer> currentList, List<Integer> numberList, Boolean[] numIfVisitedArr) {
        if (currentList.size() == numberList.size()) {
            permutationList.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = 0; i < numberList.size(); i++) {
            var currItem = numberList.get(i);
            if (currItem == currentNum) {
                continue;
            }

            if (!numIfVisitedArr[currItem]) {
                currentList.add(currItem);
                numIfVisitedArr[currItem] = true;
                generatePermutation(permutationList, currItem, currentList, numberList, numIfVisitedArr);
                currentList.remove(currItem);
                numIfVisitedArr[currItem] = false;
            }
        }

    }

    private Boolean isBeautifulArrangement(List<Integer> numList) {
        for (int i = 0; i < numList.size(); i++) {
            if ((numList.get(i) % (i + 1) != 0) && ((i + 1) % numList.get(i) != 0)) {
                return false;
            }
        }

        return true;
    }
}
