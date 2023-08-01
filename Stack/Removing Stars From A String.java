class Solution {
    public String removeStars(String s) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)))
                stringBuilder.append(s.charAt(i));
            else {
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }

        return stringBuilder.toString(); 
    }
}