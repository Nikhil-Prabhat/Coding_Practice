class CustomIndex {

    int i;
    int j;

    public CustomIndex(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomIndex)) return false;
        CustomIndex that = (CustomIndex) o;
        return getI() == that.getI() && getJ() == that.getJ();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getI(), getJ());
    }

    @Override
    public String toString() {
        return "CustomIndex{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}

class Solution {

    Map<CustomIndex, Integer> stoneMap = new HashMap<>();

    public boolean stoneGame(int[] piles) {
        stoneMap.clear();
        int sumOfPiles = Arrays.stream(piles).sum();
        Integer aliceTotal = iterateSubArray(piles, 0, piles.length - 1);

        if (aliceTotal > (sumOfPiles / 2))
            return true;
        else
            return false;

    }

    // Maximum Alice Total if everyone plays optimally
    private Integer iterateSubArray(int[] piles, int startIndex, int endIndex) {
        int leftChoice = 0;
        int rightChoice = 0;

        if (startIndex > endIndex)
            return 0;

        CustomIndex customIndex = new CustomIndex(startIndex, endIndex);
        if (stoneMap.containsKey(customIndex)) {
            return stoneMap.get(customIndex);
        }

        // Only the even turn will be Bob's turn
        // Update left and right choice when there is bob's turn
        if ((endIndex - startIndex) % 2 == 0) {
            leftChoice = piles[startIndex];
            rightChoice = piles[endIndex];
        }

        int optimalChoice = Math.max(iterateSubArray(piles, startIndex + 1, endIndex) + leftChoice,
                iterateSubArray(piles, startIndex, endIndex - 1) + rightChoice);
        stoneMap.put(customIndex, optimalChoice);

        return optimalChoice;
    }
}