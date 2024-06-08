class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushStackIndex = 0;
        int popStackIndex = 0;
        int elementToPop = popped[popStackIndex++];

        while (true) {
            try {
                if (pushStackIndex < pushed.length) {
                    while (pushed[pushStackIndex] != elementToPop) {
                        stack.push(pushed[pushStackIndex++]);
                    }
                    stack.push(pushed[pushStackIndex++]);

                    // When the pushed and popped element are same

                    while (stack.peek() == elementToPop) {
                        stack.pop();

                        if (popStackIndex >= popped.length) {
                            break;
                        }

                        elementToPop = popped[popStackIndex++];
                    }
                }
            } catch (Exception ex) {
            }

            if (stack.isEmpty() && pushStackIndex >= pushed.length) {
                return true;
            } else if (!stack.isEmpty() && pushStackIndex >= pushed.length) {
                return false;
            }
        }
    }
}