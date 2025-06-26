class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] firstStrCharArray = s.toCharArray();
        char[] secondStrCharArray = t.toCharArray();

        Arrays.sort(firstStrCharArray);
        Arrays.sort(secondStrCharArray);

        for (int i = 0; i < firstStrCharArray.length; i++) {
            if (firstStrCharArray[i] != secondStrCharArray[i]) {
                return false;
            }
        }

        return true;
    }
}
