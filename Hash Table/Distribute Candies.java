class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> uniqueCandySet = new HashSet<>();

        for (var candy : candyType) {
            uniqueCandySet.add(candy);
        }

        var candyCountAllowed = candyType.length / 2;
        return Math.min(uniqueCandySet.size(), candyCountAllowed);
    }
}
