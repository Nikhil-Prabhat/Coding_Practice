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

class Fraction {
    CustomIndex customIndex;
    double fractionValue;

    public Fraction(CustomIndex customIndex, double fractionValue) {
        this.customIndex = customIndex;
        this.fractionValue = fractionValue;
    }

    public CustomIndex getCustomIndex() {
        return customIndex;
    }

    public void setCustomIndex(CustomIndex customIndex) {
        this.customIndex = customIndex;
    }

    public double getFractionValue() {
        return fractionValue;
    }

    public void setFractionValue(double fractionValue) {
        this.fractionValue = fractionValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;
        Fraction fraction = (Fraction) o;
        return Double.compare(getFractionValue(), fraction.getFractionValue()) == 0 && Objects.equals(getCustomIndex(), fraction.getCustomIndex());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomIndex(), getFractionValue());
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "customIndex=" + customIndex +
                ", fractionValue=" + fractionValue +
                '}';
    }
}

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Fraction> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(Fraction::getFractionValue));

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                double fractionValue = (double) arr[i] / (double) arr[j];
                priorityQueue.add(new Fraction(new CustomIndex(arr[i], arr[j]), fractionValue));
            }
        }

        while (--k > 0) {
            priorityQueue.poll();
        }

        Fraction fraction = priorityQueue.poll();
        int[] result = new int[2];
        result[0] = fraction.getCustomIndex().getI();
        result[1] = fraction.getCustomIndex().getJ();

        return result;
    }
}