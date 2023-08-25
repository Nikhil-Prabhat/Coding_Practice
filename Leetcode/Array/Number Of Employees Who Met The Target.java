class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = (int) Arrays.stream(hours)
                .filter(hour -> hour >= target)
                .count();

        return count;
    }
}