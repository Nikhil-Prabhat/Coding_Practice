class Solution {
    public int mySqrt(int x) {
        return switch (x) {
            case 0 -> 0;
            case 1 -> 1;
            default -> {
                int finalResult = 0;
                for (long i = 1; i <= x / 2; i++) {

                    if ((i * i <= x) && ((i + 1) * (i + 1)) > x) {
                        finalResult = (int) i;
                        break;
                    }

                }

                yield finalResult;
            }
        };
    }
}
