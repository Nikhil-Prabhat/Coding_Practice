class Solution {
    public boolean isPerfectSquare(int num) {
       double sqrtOfNum = Math.sqrt(num);
       return sqrtOfNum == Math.floor(sqrtOfNum) ? true : false; 
    }
}