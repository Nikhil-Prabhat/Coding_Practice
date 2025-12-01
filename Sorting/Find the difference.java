class Solution {
    public char findTheDifference(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        if (sCharArray.length == 0) {
            return tCharArray[0];
        }

        for (int i = 0; i < tCharArray.length; i++) {
            if (i < s.length() && tCharArray[i] != sCharArray[i]) {
                return tCharArray[i];
            }
        }

        return tCharArray[tCharArray.length - 1];
    }
}
