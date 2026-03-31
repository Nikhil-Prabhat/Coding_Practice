// Tried Solution
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNumberList = new ArrayList<>();
        int mask = 0;
        for (int num : nums) {
            mask |= (1 << (num - 1));
        }

        for (int i = 1; i <= nums.length; i++) {
            if ((mask & (1 << (i - 1))) == 0) {
                disappearedNumberList.add(i);
            }
        }

        return disappearedNumberList;
    }
}

// Passed Solution
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        BitSet flaggedBitsForNumbers = new BitSet(nums.length);

        for (int num : nums) {
            flaggedBitsForNumbers.set(num - 1);
        }

        return IntStream.rangeClosed(1, nums.length)
                .filter(num -> !flaggedBitsForNumbers.get(num - 1))
                .boxed()
                .collect(Collectors.toList());
    }
}

// Solution 2.0
public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> result = new ArrayList<>();

    int n = nums.length;

    // Each int holds 32 bits
    int[] bitset = new int[(n / 32) + 1];

    // Step 1: Mark numbers
    for (int num : nums) {
        int index = (num - 1) / 32;       // which bucket
        int pos = (num - 1) % 32;         // which bit

        bitset[index] |= (1 << pos);
    }

    // Step 2: Find missing numbers
    for (int i = 1; i <= n; i++) {
        int index = (i - 1) / 32;
        int pos = (i - 1) % 32;

        if ((bitset[index] & (1 << pos)) == 0) {
            result.add(i);
        }
    }

    return result;
}
