class Solution {
    
    StringBuilder longestCommonPrefix = new StringBuilder();

    public String longestCommonPrefix(String[] strs) {
        List<String> sortedStringList = Arrays.stream(strs)
                .sorted(Comparator.comparing((String::length)))
                .collect(Collectors.toList());

        longestCommonPrefix.append(sortedStringList.get(0));
        sortedStringList.stream()
                .skip(1)
                .forEach(
                        str -> {
                            int prefixIndex = 0;
                            for (int i = 0; i < str.length(); i++) {
                                if ((longestCommonPrefix.length() != 0 && prefixIndex < longestCommonPrefix.length()) && longestCommonPrefix.charAt(prefixIndex) != str.charAt(i)) {
                                    longestCommonPrefix = new StringBuilder(longestCommonPrefix.substring(0, prefixIndex));
                                    break;
                                }

                                ++prefixIndex;
                            }
                        }
                );

        return longestCommonPrefix.toString();
    }
}
