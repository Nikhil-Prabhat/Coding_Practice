class Solution {
    public int nthUglyNumber(int n) {
        int ithUglyNumber = 1;
        int count = 1;

        while (count < n) {
            ithUglyNumber++;
            if (isUgly(ithUglyNumber)) {
                count++;
            }
        }

        return ithUglyNumber;
    }

    private int maximumDivideByDivisor(int dividend, int divisor) {
        while (dividend % divisor == 0) {
            dividend = dividend / divisor;
        }

        return dividend;
    }

    private boolean isUgly(int number) {
        number = maximumDivideByDivisor(number, 2);
        number = maximumDivideByDivisor(number, 3);
        number = maximumDivideByDivisor(number, 5);

        return number == 1;
    }
}
