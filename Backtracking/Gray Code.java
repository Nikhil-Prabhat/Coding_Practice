class Solution {
    public List<Integer> grayCode(int n) {
        String binaryString = initBinaryStr(n);
        Map<String, Boolean> binaryMap = new LinkedHashMap<>();
        backtrackBinaryStr(binaryString, binaryMap, new StringBuilder().append(binaryString));
        return binaryMap.keySet()
                .stream()
                .map(binaryStr -> Integer.parseInt(binaryStr, 2))
                .collect(Collectors.toList());
    }

    private void backtrackBinaryStr(String binaryString, Map<String, Boolean> binaryMap,
            StringBuilder intermediateStr) {
        // Base Case
        if ((intermediateStr.length() == binaryString.length())
                && Objects.isNull(binaryMap.get(intermediateStr.toString()))) {
            binaryMap.put(intermediateStr.toString(), true);
        } else if (Objects.nonNull(binaryMap.get(intermediateStr.toString()))) {
            return;
        }

        for (int i = 0; i < binaryString.length(); i++) {
            char currentChar = intermediateStr.charAt(i);
            char toReplaceChar = (currentChar == '1' ? '0' : '1');
            intermediateStr.replace(i, i + 1, toReplaceChar + "");
            backtrackBinaryStr(binaryString, binaryMap, intermediateStr);
            intermediateStr.replace(i, i + 1, currentChar + "");
        }
    }

    private String initBinaryStr(int number) {
        String binaryStr = "";
        for (int i = 0; i < number; i++) {
            binaryStr += "0";
        }

        return binaryStr;
    }
}
