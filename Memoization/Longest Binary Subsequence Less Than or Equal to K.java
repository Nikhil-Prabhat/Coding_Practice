class Solution {
    public int longestSubsequence(String s, int k) {
        int answer = 0;
        int value = 0;
        int power = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                answer++;
            } else {
                if (power <= k && value + power <= k) {
                    value += power;
                    answer++;
                }
            }

            if (power <= k) {
                power *= 2;
            }
        }
        
        return answer;
    }
}
