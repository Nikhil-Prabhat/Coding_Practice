class Solution {
    public int fillCups(int[] amount) {
       int seconds = 0;
        Arrays.sort(amount);

        // First deplete the maximum cups till only one cup is left
        while(amount[2] > 0 && amount[1] > 0)
        {
            amount[2]--;
            amount[1]--;
            seconds++;
            Arrays.sort(amount);
        }

        // Add the time of remaining cups
        seconds += amount[2];
        return seconds; 
    }
}