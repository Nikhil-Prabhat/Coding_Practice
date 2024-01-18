class CustomTuple {
    Character key;
    Character value;

    public CustomTuple(Character key, Character value) {
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
    public int[] maxDepthAfterSplit(String seq) {
        Stack<CustomTuple> parenthesesStack = new Stack<>();
        int[] resultDepthArray = new int[seq.length()];

        for (int i = 0; i < seq.length(); i++) {
            CustomTuple tuple = null;
            char charAtIndex = seq.charAt(i);

            // When the stack is empty
            if (parenthesesStack.isEmpty()) {
                if (charAtIndex == '(') {
                    tuple = new CustomTuple('(', 'A');
                    parenthesesStack.push(tuple);
                    resultDepthArray[i] = 0;
                    continue;
                }
            }

            // When the stack is not empty and the character is (
            if (charAtIndex == '(') {
                // If top of the stack is A, then make the next element as B
                // Else A
                if (parenthesesStack.peek().value == 'A') {
                    tuple = new CustomTuple('(', 'B');
                    parenthesesStack.push(tuple);
                    resultDepthArray[i] = 1;
                } else {
                    tuple = new CustomTuple('(', 'A');
                    parenthesesStack.push(tuple);
                    resultDepthArray[i] = 0;
                }

                continue;
            }

            // When the stack is not empty and the character is )
            if(charAtIndex == ')') {
                // if top of the stack is A, then mark it 1
                // else 0
                tuple = parenthesesStack.pop();
                if(tuple.value == 'A')
                    resultDepthArray[i] = 0;
                else
                    resultDepthArray[i] = 1;

            }
        }

        return resultDepthArray;
    }
}