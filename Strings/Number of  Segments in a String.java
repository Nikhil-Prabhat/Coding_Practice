class Solution {
    public int countSegments(String s) {
        String[] splitStrs = s.split(" ");
        var segmentCounts = 0;

        for (String splitStr : splitStrs) {
            if (!splitStr.isBlank()) {
                segmentCounts++;
            }
        }

        return segmentCounts;
    }
}
