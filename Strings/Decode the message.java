class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> keyMap = new HashMap<>();
        char startingCharacter = 'a';

        for (int i = 0; i < key.length(); i++) {

            if (Character.compare(key.charAt(i), ' ') == 0)
                continue;
            
            if (!keyMap.containsKey(key.charAt(i))) {
                keyMap.put(key.charAt(i), startingCharacter);
                startingCharacter++;
            }
        }

        // Adding empty space
        keyMap.put(' ', ' ');

        String result = "";
        for (int i = 0; i < message.length(); i++) {
            result += keyMap.get(message.charAt(i));
        }

        return result;
    }
}