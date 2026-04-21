class Solution {
    public int calculate(String s) {
        Stack<Integer> evaluateStack = new Stack<>();
        Character operator = '+';
        Integer currentNumIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                currentNumIndex++;
                continue;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                operator = s.charAt(i);
                currentNumIndex++;
                continue;
            }

            int extractedNum = extractNumber(s, currentNumIndex);
            if (extractedNum == -1) {
                break;
            }

            switch (operator) {
                case '+' -> evaluateStack.push(extractedNum);
                case '-' -> evaluateStack.push(-extractedNum);
                case '/' -> evaluateStack.push(evaluateStack.pop() / extractedNum);
                case '*' -> evaluateStack.push(evaluateStack.pop() * extractedNum);
            }

            currentNumIndex += (extractedNum + "").length();
            i = (currentNumIndex - 1);
        }

        return evaluateStack.size() > 1 ? getSumOfStack(evaluateStack) : evaluateStack.pop();

    }

    private int getSumOfStack(Stack<Integer> stack) {
        int finalResult = 0;
        while (!stack.isEmpty()) {
            finalResult += stack.pop();
        }

        return finalResult;
    }

    private int extractNumber(String s, int startIndex) {
        String finalNumber = "";
        for (int i = startIndex; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }

            finalNumber += s.charAt(i);
        }

        return Integer.parseInt(finalNumber.isEmpty() ? "-1" : finalNumber);
    }
}
