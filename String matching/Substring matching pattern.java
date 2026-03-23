class Solution {
    public boolean hasMatch(String s, String p) {
      int idx = p.indexOf('*');
      int f = s.indexOf(p.substring(0,idx));
      int se = s.indexOf(p.substring(idx+1),f+idx);
      if(f != -1 && se != -1){
        return true;
      }
      return false;
    }
}
