class Solution {
    public int countKeyChanges(String s) {
       int count = 0;
        Character lastUsedCharacter = null;

        for(int i= 0; i< s.length();i++) {
            if(i == 0)
            {
                lastUsedCharacter =Character.toUpperCase(s.charAt(i));
                continue;
            }
            char currentCharacter = Character.toUpperCase(s.charAt(i));

            if(currentCharacter != lastUsedCharacter)
                count++;

            lastUsedCharacter = currentCharacter;
        }

        return count; 
    }
}