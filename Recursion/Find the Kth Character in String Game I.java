class Solution {
    public char kthCharacter(int k) {
        String finalResult = "a";

        while (finalResult.length() < k) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] finalResultArray = finalResult.toCharArray();
            for (char c : finalResultArray) {
                if (Character.compare(c, 'z') == 0) {
                    stringBuilder.append('a');
                } else {
                    stringBuilder.append((char) (c + 1));
                }
            }

            finalResult += stringBuilder.toString();
        }

        return finalResult.charAt(k - 1);
    }
}
