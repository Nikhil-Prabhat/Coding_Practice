class Solution {
    public boolean isPrefixString(String s, String[] words) {
        String intermediateResult = "";
        for(String word : words) {
            intermediateResult += word;
            if(intermediateResult.equals(s)) {
                return true;
            }
        }

        return false;
    }
}
