class Solution {
    public boolean isValid(String s) {
        StringBuffer str = new StringBuffer(s);
        String intermediateStr = str.toString();
        int indexOfValidCheckStr = intermediateStr.indexOf("abc");

        while(!intermediateStr.isEmpty() && indexOfValidCheckStr != -1) {
            StringBuffer updatedStr = str.delete(indexOfValidCheckStr, indexOfValidCheckStr + 3);
            intermediateStr = updatedStr.toString();
            indexOfValidCheckStr = intermediateStr.indexOf("abc");
        }

        return intermediateStr.isEmpty() ? true : false;
    }
}
