class Solution {
    public String maximumOddBinaryNumber(String s) {
        Map<Character, Integer> characterCountMap = new HashMap<>();

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '1') {
                characterCountMap.put('1', characterCountMap.getOrDefault('1',0) + 1);
            } else {
                characterCountMap.put('0', characterCountMap.getOrDefault('0', 0) + 1);
            }
        }

        String resultString = "";
        int oneCount = characterCountMap.get('1');
        int zeroCount = characterCountMap.containsKey('0') ? characterCountMap.get('0') : 0;
        
        while(--oneCount > 0)
            resultString += "1";

        while (--zeroCount >= 0)
            resultString += "0";

        resultString += "1";

        return resultString;
    }
}