class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> patternMatchList = new ArrayList<>();

        for (var query : queries) {
            int patternIndex = 0;
            boolean isPatternFound = true;

            for (var currentChar : query.toCharArray()) {
                if (patternIndex < pattern.length() && currentChar == pattern.charAt(patternIndex)) {
                    patternIndex++;
                    continue;
                }

                if (Character.isUpperCase(currentChar)) {
                    if (patternIndex >= pattern.length() || currentChar != pattern.charAt(patternIndex)) {
                        isPatternFound = false;
                        break;
                    }
                }
            }

            isPatternFound = isPatternFound && patternIndex == pattern.length();
            patternMatchList.add(isPatternFound);
        }

        return patternMatchList;
    }
}
