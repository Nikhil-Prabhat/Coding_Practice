class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = null;
        ListNode resultHead = null;
        Map<Integer, Boolean> duplicateMap = new HashMap<>();

        while (Objects.nonNull(ptr1)) {
            duplicateMap.compute(ptr1.val, (key, val) -> Objects.nonNull(val));
            ptr1 = ptr1.next;
        }

        ptr1 = head;
        while (Objects.nonNull(ptr1)) {
            if (!duplicateMap.get(ptr1.val)) {
                if (Objects.isNull(ptr2)) {
                    ptr2 = new ListNode(ptr1.val);
                    ptr1 = ptr1.next;
                    resultHead = ptr2;
                    continue;
                }

                ptr2.next = new ListNode(ptr1.val);
                ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }

        return resultHead;
    }
}
