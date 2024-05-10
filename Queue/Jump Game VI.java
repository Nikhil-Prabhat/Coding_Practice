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
    public int maxResult(int[] nums, int k) {
       PriorityQueue<CustomIndex> priorityQueue = new PriorityQueue<>(new Comparator<CustomIndex>() {
            @Override
            public int compare(CustomIndex o1, CustomIndex o2) {
                return o2.getI() - o1.getI();
            }
        });

        int sum = nums[0];

        for (int i = 1; i < nums.length; ) {
            for (int j = i; j < (i + k); j++) {
                if (j >= nums.length) {
                    break;
                }

                priorityQueue.add(new CustomIndex(nums[j], j));
            }

            CustomIndex topElementOfQueue = !priorityQueue.isEmpty() ? priorityQueue.poll() : null;
            sum += Objects.nonNull(topElementOfQueue) ? topElementOfQueue.getI() : 0;
            priorityQueue.clear();
            i = (topElementOfQueue.getJ() + 1);
        }

        return sum;
    }
}