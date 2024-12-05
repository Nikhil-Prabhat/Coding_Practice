class Solution {
    int count = 0;
    
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        Arrays.stream(g).forEach(
                elG -> {
                    for (int i = 0; i < s.length; i++) {
                        if(elG <= s[i]) {
                            count++;
                            s[i] = -1;
                            break;
                        }
                    }
                }
        );
        return count;
    }
}
