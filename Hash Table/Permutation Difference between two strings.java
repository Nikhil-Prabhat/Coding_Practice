class Solution {
    public int findPermutationDifference(String s, String t) {
       int permutationDifference = 0;

        for (int i = 0; i < s.length(); i++) {
            int anotherIndex = t.indexOf(s.charAt(i));
            permutationDifference += Math.abs(i - anotherIndex);
        }

        return permutationDifference; 
    }
}