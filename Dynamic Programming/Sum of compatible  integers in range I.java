class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        return IntStream.range(Math.max(1, n - k), n + k + 1)
                .filter(num -> Math.abs(n - num) <= k && (n & num) == 0)
                .sum();
    }
}
