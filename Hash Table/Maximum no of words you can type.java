class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
       String[] splitText = text.split(" ");
        int countOfWords = 0;

        for(String str : splitText)
        {
            boolean isFound = false;
            for(int i=0;i<brokenLetters.length();i++)
            {
                if(str.contains(brokenLetters.charAt(i)+""))
                {
                    isFound = true;
                }
            }

            if(!isFound)
                countOfWords++;

        }

        return countOfWords; 
    }
}