class Solution {
    int index = 0;
    public int[] separateDigits(int[] nums) {

        List<Integer> resultList = new ArrayList<>();
        Arrays.stream(nums).forEach(
                num -> {
                    Stack<Integer> stack = getSeperateDigits(num);
                    while (!stack.isEmpty())
                        resultList.add(stack.pop());
                }
        );
        
        int[] finalResultArray = new int[resultList.size()];
        resultList.stream().forEach(
                num -> {
                    finalResultArray[index++] = num;
                }
        );

        return finalResultArray;

    }

    private Stack<Integer> getSeperateDigits(int num) {
        Stack<Integer> stack = new Stack<>();
        while (num / 10 != 0) {
            stack.add(num % 10);
            num = num / 10;
        }
        
        stack.add(num);
        return stack;
    }
}