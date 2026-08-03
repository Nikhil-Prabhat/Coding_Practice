class Solution {
    public ListNode partition(ListNode head, int x) {
        List<Integer> numLessThanXList = new ArrayList<>();
        List<Integer> numGreaterThanXList = new ArrayList<>();
        ListNode ptr = head;
        ListNode tempPtr = null;
        ListNode resultPtr = null;
        int startIndexForFirstList = -1;
        int startIndexForSecondList = -1;
        boolean ifStartedWithFirstList = true;

        while (Objects.nonNull(ptr)) {
            if (ptr.val < x) {
                numLessThanXList.add(ptr.val);
            } else {
                numGreaterThanXList.add(ptr.val);
            }

            ptr = ptr.next;
        }

        // Generate the final listnode
        if (!numLessThanXList.isEmpty()) {
            resultPtr = new ListNode(numLessThanXList.get(0));
            tempPtr = resultPtr;
        } else if (!numGreaterThanXList.isEmpty()) {
            resultPtr = new ListNode(numGreaterThanXList.get(0));
            tempPtr = resultPtr;
            ifStartedWithFirstList = false;
        }
        
        startIndexForFirstList = ifStartedWithFirstList ? 1 : 0;
        startIndexForSecondList = ifStartedWithFirstList ? 0 : 1;

        for (; !numLessThanXList.isEmpty() && startIndexForFirstList < numLessThanXList.size(); startIndexForFirstList++) {
            tempPtr.next = new ListNode(numLessThanXList.get(startIndexForFirstList));
            tempPtr = tempPtr.next;
        }

        for (; !numGreaterThanXList.isEmpty() && startIndexForSecondList < numGreaterThanXList.size(); startIndexForSecondList++) {
            tempPtr.next = new ListNode(numGreaterThanXList.get(startIndexForSecondList));
            tempPtr = tempPtr.next;
        }

        return resultPtr;
    }
}
