class Solution {
    int MODULO = (int) (1e9 + 7);

    public int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = n / 2 + n % 2;
        return (int) ((getCustomPowerValue(5, even) * getCustomPowerValue(4, odd)) % MODULO);
    }

    private long getCustomPowerValue(long base, long raisedTo) {
        if (raisedTo == 0) {
            return 1;
        }

        long computedValue = getCustomPowerValue(base, raisedTo / 2);
        computedValue *= computedValue;
        computedValue %= MODULO;

        if (raisedTo % 2 == 1) {
            computedValue *= base;
        }

        computedValue %= MODULO;
        return computedValue;
    }
}
