class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        var poisionedDuration = 0;
        var poisionedIndex = 0;
        var durationDelta = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i == 0) {
                poisionedDuration += duration;
                poisionedIndex = (timeSeries[i] + duration) - 1;
                continue;
            }

            if (poisionedIndex >= timeSeries[i]) {
                durationDelta = (poisionedIndex - timeSeries[i]) + 1;
                poisionedDuration -= durationDelta;
            }

            poisionedDuration += duration;
            poisionedIndex = (timeSeries[i] + duration) - 1;
        }

        return poisionedDuration;
    }
}
