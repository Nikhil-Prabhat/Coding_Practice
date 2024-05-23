class Solution {
   public int maxRepeating(String sequence, String word) {
        String toAdd = word;
        int count = 0;

        while(sequence.contains(word)) {
            count++;
            word += toAdd;
        }

        return count;
    }
}