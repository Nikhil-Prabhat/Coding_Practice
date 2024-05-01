class Solution {
    public ListNode reorderList(ListNode head) {
        List<Integer> tempNodeList = new ArrayList<>();
        ListNode ptr = head;
        ListNode tempResultPtr = null;

        while (Objects.nonNull(ptr)) {
            tempNodeList.add(ptr.val);
            ptr = ptr.next;
        }

        int sizeOfNodeList = tempNodeList.size();

        for (int i = 0; i <= sizeOfNodeList / 2; i++) {

            if(Objects.isNull(tempResultPtr)) {
                tempResultPtr = new ListNode(tempNodeList.get(i));
                tempResultPtr.next = new ListNode(tempNodeList.get(sizeOfNodeList - i - 1));
                head = tempResultPtr;
                tempResultPtr = tempResultPtr.next;
                continue;
            }

            tempResultPtr.next = new ListNode(tempNodeList.get(i));

            if(!(i == (sizeOfNodeList-i-1))) {
                tempResultPtr.next.next = new ListNode(tempNodeList.get(sizeOfNodeList - i - 1));
                tempResultPtr = tempResultPtr.next.next;
            }
        }

        return head;
    }
}