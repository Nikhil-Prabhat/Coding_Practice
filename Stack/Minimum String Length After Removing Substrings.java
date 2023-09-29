class Solution {
    public int minLength(String s) {
        StringBuilder str = new StringBuilder(s);

        while(true) {
            boolean noFurthurAB = false;
            boolean noFurthurCD = false;

            int indexOfAB = str.indexOf("AB");
            if(indexOfAB != -1) {
                str.delete(indexOfAB, indexOfAB+2);
                noFurthurAB = true;
            }

            int indexOfCD = str.indexOf("CD");
            if(indexOfCD != -1) {
                str.delete(indexOfCD, indexOfCD + 2);
                noFurthurCD = true;
            }

            if(!noFurthurAB && !noFurthurCD)
                break;
        }

        return str.length();
    }
}