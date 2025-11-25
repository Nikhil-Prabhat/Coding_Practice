class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Long> ransomNoteMap = ransomNote.chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()));

        Map<Character, Long> magazineMap = magazine.chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()));

        for (int i = 0; i < ransomNote.length(); i++) {
            Long charCountInRansomMap = ransomNoteMap.getOrDefault(ransomNote.charAt(i), 0L);
            Long charCountInMagazineMap = magazineMap.getOrDefault(ransomNote.charAt(i), 0L);


            if (charCountInMagazineMap == 0) {
                return false;
            } else if (!(charCountInMagazineMap != 0 && charCountInRansomMap != 0 && charCountInRansomMap <= charCountInMagazineMap)) {
                return false;
            }
        }

        return true;
    }
}
