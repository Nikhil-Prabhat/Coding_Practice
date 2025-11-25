class Solution {
    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        String result = "";
        int vowelIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            if(isVowel(s.charAt(i))) {
                vowels.add(s.charAt(i));
            }
        }

        Collections.reverse(vowels);

        for(int i = 0;i<s.length();i++) {
            if(isVowel(s.charAt(i))){
                result += vowels.get(vowelIndex++);
                continue;
            }

            result += s.charAt(i);
        }

        return result;
    }

    private boolean isVowel(Character character) {
        if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u' || character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U')
            return true;

        return false;
    }
}
