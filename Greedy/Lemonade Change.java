class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> lemonadeMap = new HashMap<>();

        for (int bill : bills) {
            if (bill == 5) {
                lemonadeMap.put(5, lemonadeMap.getOrDefault(5, 0) + 1);
            } else if (bill == 10) {
                lemonadeMap.put(10, lemonadeMap.getOrDefault(10, 0) + 1);

                // compute change for $10
                Integer fiveDollarCount = lemonadeMap.getOrDefault(5, 0);
                if (fiveDollarCount > 0) {
                    lemonadeMap.put(5, fiveDollarCount - 1);
                } else {
                    return false;
                }
            } else {
                Integer tenDollarCount = lemonadeMap.getOrDefault(10, 0);
                if (tenDollarCount > 0) {
                    lemonadeMap.put(10, tenDollarCount - 1);
                } else {
                    Integer fiveDollarCount = lemonadeMap.getOrDefault(5, 0);
                    if (fiveDollarCount >= 2) {
                        lemonadeMap.put(5, fiveDollarCount - 2);
                    } else {
                        return false;
                    }
                }

                Integer fiveDollarCount = lemonadeMap.getOrDefault(5, 0);
                if (fiveDollarCount > 0) {
                    lemonadeMap.put(5, fiveDollarCount - 1);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
