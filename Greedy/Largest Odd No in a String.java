class Solution {
    public String largestOddNumber(String num) {
        int length = num.length();
        if((num.charAt(length-1)-'0') % 2 == 1)
            return num;
        else
        {
            int i;
            for(i=length-1;i>=0;i--)
            {
                if((num.charAt(i)-'0') % 2 == 1)
                    break;

            }

            return num.substring(0,i+1);
        }


    }
}