class Solution {
    public boolean isAcronym(List<String> words, String s) {
        String acronym = "";
        for (int i = 0; i < words.size(); i++) {
            acronym += words.get(i).charAt(0);
        }

        return acronym.equalsIgnoreCase(s);
    }
}