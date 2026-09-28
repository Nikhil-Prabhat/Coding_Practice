class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode ptr = head;
        ListNode linkedListForReversal = getLinkedListForReversal(ptr, left, right);
        ListNode reversedLinkedList = reverseLinkedList(linkedListForReversal);
        var currentIndex = 1;

        while (Objects.nonNull(ptr)) {
            while (currentIndex >= left && currentIndex <= right && Objects.nonNull(ptr)) {
                ptr.val = reversedLinkedList.val;
                reversedLinkedList = reversedLinkedList.next;
                ptr = ptr.next;
                currentIndex++;
            }

            if (Objects.nonNull(ptr)) {
                ptr = ptr.next;
                currentIndex++;
            }
        }

        return head;
    }

    private ListNode getLinkedListForReversal(ListNode fullListNode, int left, int right) {
        ListNode linkedListToConsider = null;
        ListNode headNode = null;
        int currentIndex = 1;
        int linkedListIndex = 0;

        while (Objects.nonNull(fullListNode)) {
            while (currentIndex >= left && currentIndex <= right && Objects.nonNull(fullListNode)) {
                if (linkedListIndex == 0) {
                    linkedListToConsider = new ListNode(fullListNode.val);
                    headNode = linkedListToConsider;
                } else {
                    linkedListToConsider.next = new ListNode(fullListNode.val);
                    linkedListToConsider = linkedListToConsider.next;
                }

                linkedListIndex++;
                currentIndex++;
                fullListNode = fullListNode.next;
            }

            if (Objects.nonNull(fullListNode)) {
                fullListNode = fullListNode.next;
                currentIndex++;
            }
        }

        return headNode;
    }

    private ListNode reverseLinkedList(ListNode listNode) {
        ListNode prevNode = null;
        ListNode currentNode = listNode;

        while (Objects.nonNull(currentNode)) {
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        return prevNode;
    }
}
