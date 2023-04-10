class Solution {
    public int splitNum(int num) {

        List<Integer> numberList = new ArrayList<>();

        // Get each digit and add it in the list
        while (num != 0) {
            int rem = num % 10;
            num = num / 10;
            numberList.add(rem);
        }

        // Sort the list
        Collections.sort(numberList);

        int num1 = 0;
        int num2 = 0;
        boolean numTurn = true;

        for (int i = 0; i < numberList.size(); i++) {

            if (numTurn) {
                num1 = (num1 * 10 + numberList.get(i));
                numTurn = false;
                continue;
            }

            num2 = (num2 * 10 + numberList.get(i));
            numTurn = true;
        }

        int result = num1 + num2;
        return result;

    }
}