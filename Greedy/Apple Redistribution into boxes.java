class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sumOfApples = Arrays.stream(apple).sum();
        int sumOfCapacity = 0;
        int count = 0;

        // Sort the capacity
        Arrays.sort(capacity);

        for (int i = capacity.length - 1; i >= 0 && (sumOfCapacity < sumOfApples); i--) {
            sumOfCapacity += capacity[i];
            count++;
        }

        return count;
    }
}