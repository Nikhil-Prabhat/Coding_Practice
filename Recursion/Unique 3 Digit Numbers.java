class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> numberSet = new HashSet<>();
        int lenOfDigits = digits.length;

        for (int i = 0; i < lenOfDigits; i++) {
            if (digits[i] == 0) {
                continue;
            }

            for (int j = 0; j < lenOfDigits; j++) {
                if (i == j) {
                    continue;
                }

                for (int k = 0; k < lenOfDigits; k++) {
                    if (k == i || k == j) {
                        continue;
                    }

                    if (digits[k] % 2 == 0) {
                        var number = digits[i] * 100 + digits[j] * 10 + digits[k];
                        numberSet.add(number);
                    }
                }
            }
        }

        return numberSet.size();
    }
}
