class Solution {
   public int countSubstrings(String s, String t) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                int x = i;
                int y = j;
                int differenceBetweenCharacters = 0;

                while (x < s.length() && y < t.length()) {
                    if (s.charAt(x) != t.charAt(y))
                        differenceBetweenCharacters++;

                    if (differenceBetweenCharacters == 1)
                        ans++;
                    if (differenceBetweenCharacters == 2)
                        break;

                    x++;
                    y++;

                }
            }
        }

        return ans;
    }
}