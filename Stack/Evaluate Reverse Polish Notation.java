class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operandsStack = new Stack<>();

        IntStream.range(0, tokens.length)
                .forEach(index -> {

                    var element = tokens[index];
                    if(!(element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/"))) {
                        operandsStack.push(Integer.parseInt(element));
                    } else {
                        var secondElement = operandsStack.pop();
                        var firstElement = operandsStack.pop();

                        var intermediateResult = switch (element) {
                            case "+" -> firstElement + secondElement;
                            case "-" -> firstElement - secondElement;
                            case "*" -> firstElement * secondElement;
                            case "/" -> firstElement / secondElement;
                            default -> 0;
                        };

                        operandsStack.push(intermediateResult);
                    }
                });

        return operandsStack.peek();

    }
}
