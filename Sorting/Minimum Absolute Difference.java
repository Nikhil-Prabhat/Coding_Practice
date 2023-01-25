class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diffOfTwoElements = arr[i + 1] - arr[i];
            minDiff = diffOfTwoElements < minDiff ? diffOfTwoElements : minDiff;
        }

        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                resultList.add(list);
            }
        }

        return resultList;
    }
}