class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
      int i = 0, j = 0;
        boolean found = false;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else if (nums1[i] == nums2[j]) {
                found = true;
                break;
            }
        }

        if (found)
            return nums1[i];
        else
            return -1;
  
    }
}