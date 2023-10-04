class Solution {
    
    List<String> happyStringList = new ArrayList<>();
    String lettersAvailable = "abc";

    public String getHappyString(int n, int k) {
        frameHappyString( n, "");
        return happyStringList.size() >= k ? happyStringList.get(k - 1) : "";
    }

    public void frameHappyString(int expectedSizeBracket, String currentString) {
        if (currentString.length() == expectedSizeBracket) {
            happyStringList.add(currentString);
            return;
        }

        for (int i = 0; i < lettersAvailable.length(); i++) {
            if (currentString.isEmpty()) {
                frameHappyString(expectedSizeBracket, currentString + lettersAvailable.charAt(i));
                continue;
            }

            if (currentString.charAt(currentString.length() - 1) == lettersAvailable.charAt(i))
                continue;

            frameHappyString(expectedSizeBracket, currentString + lettersAvailable.charAt(i));
        }
    }
}