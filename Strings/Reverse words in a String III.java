class Solution {
    public String reverseWords(String s) {

        String[] splitStrings = s.split(" ");
        for (int i = 0; i < splitStrings.length; i++) {
            splitStrings[i] = reverseEachWord(splitStrings[i]);
        }

        String reversedString = Arrays.stream(splitStrings).collect(Collectors.joining(" "));
        return reversedString;
    }

    private String reverseEachWord(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        return stringBuffer.reverse().toString();
    }
}