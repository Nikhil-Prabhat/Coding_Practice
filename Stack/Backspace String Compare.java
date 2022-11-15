public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        if(s.length() > t.length())
        {
            addToStack(stack,s);
            compareWithOtherString(stack,t);
        }
        else
        {
            addToStack(stack,t);
            compareWithOtherString(stack,s);
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    private void addToStack(Stack<Character> stack,String str)
    {
        for(int i=0;i<str.length();i++)
        {
            if(Character.compare('#',str.charAt(i)) == 0 && !stack.isEmpty())
                stack.pop();
            else
                stack.push(str.charAt(i));
        }
    }

    private void compareWithOtherString(Stack<Character> stack, String str)
    {
        for(int i=str.length()-1;i>=0;i--)
        {
            if( !stack.isEmpty() && Character.compare(str.charAt(i),stack.peek()) == 0)
                stack.pop();
            else
                break;
        }
    }