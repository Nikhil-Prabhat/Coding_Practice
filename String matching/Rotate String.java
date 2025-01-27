class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        String combination = s + s;
        return combination.contains(goal);
    }
}
