class CustomTuple {
    int key;
    int value;

    public CustomTuple(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomTuple{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

}

class Solution {
    public int[] frequencySort(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        PriorityQueue<CustomTuple> priorityQueue = new PriorityQueue<>(new Comparator<CustomTuple>() {
            @Override
            public int compare(CustomTuple o1, CustomTuple o2) {
                // If frequency same, then sort in descending order as per key , else sort in ascending order as per value
                if (o1.value == o2.value)
                    return o2.key - o1.key;
                else
                    return o1.value - o2.value;
            }
        });

        map.entrySet().stream().forEach(
                m -> priorityQueue.add(new CustomTuple(m.getKey(), m.getValue()))
        );

        int[] result = new int[nums.length];
        int counter = 0;

        while (!priorityQueue.isEmpty()) {
            CustomTuple customTuple = priorityQueue.poll();
            int element = customTuple.key;
            int count = customTuple.value;

            for (int i = 0; i < count; i++)
                result[counter++] = element;

        }

        return result;  
    }
}