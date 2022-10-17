class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> setOfElements;
        Set<Integer> tempSetOfElements = new TreeSet<>();
        Arrays.stream(nums)
                .filter(element -> element != 0)
                .forEach(
                        (element) -> {
                            tempSetOfElements.add(element);
                        }
                );
        setOfElements = tempSetOfElements;
        int counter = 0;
        while(!setOfElements.isEmpty())
        {
            int minElement = setOfElements.stream()
                    .findFirst()
                    .get();

            setOfElements = setOfElements.stream()
                    .map(element -> element - minElement)
                    .collect(Collectors.toSet());
            counter++;

            // Remove 0 from set
            setOfElements.remove(0);
        }

        return counter;  
    }
}