class Solution {
    public boolean isHappy(int n) {
        Map<Integer, Boolean> map = new HashMap<>();
        int calculatedSum = -1;

        while (true) {
            calculatedSum = calculateSum(n);
            n = calculatedSum;

            if (calculatedSum == 1) {
                return true;
            } else if (isSingleDigit(calculatedSum)) {
                if (map.containsKey(calculatedSum))
                    return false;

                map.putIfAbsent(calculatedSum, true);
            }
        }
    }

    private boolean isSingleDigit(int n) {
        return n / 10 == 0;
    }

    private int calculateSum(int num) {
        int sum = 0;
        while (num != 0) {
            int quotient = num / 10;
            int remainder = num % 10;
            sum += remainder * remainder;

            num = quotient;
        }

        return sum;
    }
}
