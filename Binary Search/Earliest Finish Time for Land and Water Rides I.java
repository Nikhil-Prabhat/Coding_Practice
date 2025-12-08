class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int earliestFinishTime = Integer.MAX_VALUE;
        int landCount = landStartTime.length;
        int waterCount = waterStartTime.length;

        for (int i = 0; i < landCount; i++) {
            var landElStartTime = landStartTime[i];
            var landElDuration = landDuration[i];

            for (int j = 0; j < waterCount; j++) {
                var waterElStartTime = waterStartTime[j];
                var waterElDuration = waterDuration[j];

                // Case 1 : Land -> Water
                var landEnd = landElStartTime + landElDuration;
                var waterStart = Math.max(landEnd, waterElStartTime);
                var finishTime1 = waterStart + waterElDuration;

                // Case 2 : Water -> Land
                var waterEnd = waterElStartTime + waterElDuration;
                var landStart = Math.max(waterEnd, landElStartTime);
                var finishTime2 = landStart + landElDuration;

                earliestFinishTime = Math.min(earliestFinishTime, Math.min(finishTime1, finishTime2));
            }
        }

        return earliestFinishTime;
    }
}
