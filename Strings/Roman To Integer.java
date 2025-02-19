class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int finalAnswer = 0;
        int prevInteger = -1;

        for (int i = 0; i < s.length(); i++) {
            int currentInteger = romanMap.get(s.charAt(i));
            int intToAdd = prevInteger != -1 && prevInteger < currentInteger ? currentInteger - (2 * prevInteger) : currentInteger;
            finalAnswer += intToAdd;
            prevInteger = currentInteger;
        }

        return finalAnswer;
    }
}
