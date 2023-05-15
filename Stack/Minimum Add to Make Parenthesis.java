class Solution {
    public int minAddToMakeValid(String s) {
      // Initialisation of stack
        Stack<Character> parenthesisStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character bracket = s.charAt(i);

            // Pop out all the valid parenthesis from the stack
            Character topBracket = !parenthesisStack.isEmpty() ? parenthesisStack.peek() : null;
            if (Objects.nonNull(topBracket)) {
                if ((Character.compare(bracket, ')') == 0 && Character.compare(topBracket, '(') == 0)) {
                    parenthesisStack.pop();
                    continue;
                }
            }

            // Insert the bracket in the stack
            parenthesisStack.add(bracket);
        }

        return parenthesisStack.size();  
    }
}