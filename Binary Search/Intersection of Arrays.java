 public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersectionList = new ArrayList<>();
        Arrays.sort(nums1);
        for(int num : nums2)
        {
            if(checkIfNumberIsPresent(nums1,num))
                intersectionList.add(num);
        }

        int[] array = intersectionList.stream().mapToInt(i->i)
                .toArray();

        return array;
    }

    private boolean checkIfNumberIsPresent(int[] nums, int toSearch)
    {
        int low = 0;
        int high = nums.length-1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;

            // If the element is found
            if(nums[mid] == toSearch) {
                nums[mid] = -1;
                return Boolean.TRUE;
            }

            // If the element is bigger than the mid element, then search right side of the mid element in the array.
            // If the element is lesser than the mid element, then search left side of the mid element in the array.
            if(nums[mid] < toSearch)
                low = mid +1;
            else
                high = mid -1;
        }

        // If element not found in the array, then return -1;
        return Boolean.FALSE;
    }