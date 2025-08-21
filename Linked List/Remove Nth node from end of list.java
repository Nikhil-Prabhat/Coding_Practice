class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int countOfElements = 0;
        ListNode ptr = head;
        ListNode prevPtr = ptr;

        while (Objects.nonNull(ptr)) {
            countOfElements++;
            ptr = ptr.next;
        }

        if (countOfElements == 1 && n == 1) {
            return null;
        }

        int indexToBeRemoved = (countOfElements - n + 1);
        int counter = 1;
        ptr = head;
        prevPtr = ptr;

        while (counter != indexToBeRemoved) {
            prevPtr = ptr;
            ptr = ptr.next;
            counter++;
        }

        if (countOfElements == n) {
            return ptr.next;
        }

        prevPtr.next = ptr.next;
        return head;
    }
}
