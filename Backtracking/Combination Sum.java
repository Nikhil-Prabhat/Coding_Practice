class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        calculateSum(0, candidates, target, resultList, tempList);
        return resultList;
    }

    private void calculateSum(int index, int[] arrOfCandidates, int target, List<List<Integer>> resultList, List<Integer> tempList) {
        if(target == 0) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        if(index == arrOfCandidates.length || target < 0) {
            return;
        }

        // Add the current index element
        tempList.add(arrOfCandidates[index]);
        calculateSum(index, arrOfCandidates, target - arrOfCandidates[index], resultList, tempList);
        
        // Remove the last added element if the calculate sum target is exceeding with previous sum and proceed to next element
        tempList.remove(tempList.size() - 1);
        calculateSum(index+1, arrOfCandidates, target, resultList, tempList);
    }
}