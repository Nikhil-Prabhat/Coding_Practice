class Solution {
    public int countAsterisks(String s) {
      boolean isFound = Boolean.FALSE;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.compare(s.charAt(i), '|') == 0)
                isFound = !isFound ? Boolean.TRUE : Boolean.FALSE;

            if (!isFound)
                if (Character.compare(s.charAt(i), '*') == 0)
                    count++;
        }
        return count;  
    }
}