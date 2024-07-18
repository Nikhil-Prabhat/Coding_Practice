class Solution {

    int[][] memoizedPalindrome;

    public int countSubstrings(String s) {
        memoizedPalindrome = new int[s.length()][s.length()];
        int count = 0;

        for (int[] row : memoizedPalindrome) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                count += isPalindrome(s, i, j);
            }
        }
        
        return  count;
    }

    private int isPalindrome(String str, int fromIndex, int toIndex) {
        if (fromIndex >= toIndex)
            return 1;

        //if (memoizedPalindrome[fromIndex][toIndex] != -1)
        //    return memoizedPalindrome[fromIndex][toIndex];

        return  str.charAt(fromIndex) == str.charAt(toIndex) ? isPalindrome(str, fromIndex + 1, toIndex - 1) : 0;
    }
}