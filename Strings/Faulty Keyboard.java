class Solution {
    public String finalString(String s) {
        StringBuffer strCreated = new StringBuffer();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == 'i') {
                strCreated.reverse();
                continue;
            }

            strCreated.append(s.charAt(i));
        }

        return strCreated.toString();

    }
}