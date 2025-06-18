class Solution {
    public int lengthOfLastWord(String s) {
        String trimmedStr = s.trim();
        String[] strArr = trimmedStr.split(" ");
        return strArr[strArr.length - 1].length();
    }
}
