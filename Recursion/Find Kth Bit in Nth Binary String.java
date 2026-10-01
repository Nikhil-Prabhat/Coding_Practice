class Solution {
    public char findKthBit(int n, int k) {
        String finalStr = computeFinalStr(n);
        return finalStr.charAt(k - 1);
    }

    private String computeFinalStr(int strLen) {
        if (strLen == 1) {
            return "0";
        }

        return computeFinalStr(strLen - 1) + "1" + reverseString(invertString(computeFinalStr(strLen - 1)));
    }

    private String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private String invertString(String str) {
        StringBuilder invertedStringBuilder = new StringBuilder();

        for (char ch : str.toCharArray()) {
            invertedStringBuilder.append(ch == '0' ? '1' : '0');
        }

        return invertedStringBuilder.toString();
    }
}
