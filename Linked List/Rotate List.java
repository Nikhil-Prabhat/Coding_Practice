class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(Objects.nonNull(head)) {
            int sizeOfListNode = findLengthOfLinkedList(head);
            int revisedRotationCount = k >= sizeOfListNode ? k % sizeOfListNode : k;

            while (revisedRotationCount-- > 0) {
                head = singleRightRotate(head);
            }
        }
        return head;
    }

    private ListNode singleRightRotate(ListNode currentListNode) {
        ListNode headNode;
        ListNode prevListNode;
        ListNode tempListNode = null;

        while (Objects.nonNull(currentListNode.next)) {
            prevListNode = currentListNode;
            currentListNode = currentListNode.next;

            if (Objects.isNull(tempListNode)) {
                tempListNode = new ListNode(prevListNode.val);
            } else {
                addToListNode(tempListNode, prevListNode);
            }
        }

        headNode = new ListNode(currentListNode.val);
        headNode.next = tempListNode;

        return headNode;
    }

    private void addToListNode(ListNode resultNode, ListNode listNode) {
        while (Objects.nonNull(resultNode.next)) {
            resultNode = resultNode.next;
        }

        resultNode.next = new ListNode(listNode.val);
    }

    private int findLengthOfLinkedList(ListNode listNode) {
        int size = 0;
        while (Objects.nonNull(listNode)) {
            size++;
            listNode = listNode.next;
        }

        return size;
    }
}
