class Solution {
    // function to get the result of the operation
    int perform(int x, int y, char op) {
        if(op == '+') return x + y;
        if(op == '-') return x - y;
        if(op == '*') return x * y;
        return 0;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<Integer>();
        boolean isNumber = true;

        for(int i = 0; i < expression.length(); i++) {
            // check if current character is an operator
            if(!Character.isDigit(expression.charAt(i))) {

                // if current character is not a digit then
                // exp is not purely a number
                isNumber = false;

                // list of first operands
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));

                // list of second operands
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                // performing operations
                for(int x : left) {
                    for(int y : right) {
                        int val = perform(x, y, expression.charAt(i));
                        results.add(val);
                    }
                }

            }
        }
        if(isNumber) results.add(Integer.valueOf(expression));
        return results;
    }
}