class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;

        for (int i = 0; i < fruits.length; i++) {
            int j = 0;
            for (; j < baskets.length; j++) {
                if (fruits[i] <= baskets[j]) {
                    baskets[j] = -1;
                    break;
                }
            }

            if (j == baskets.length) {
                count++;
            }
        }

        return count;
    }
}
