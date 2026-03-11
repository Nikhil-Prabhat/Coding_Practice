class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        while (k-- > 0 && Objects.nonNull(head)) {
            head = singleRightRotate(head);
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
}
