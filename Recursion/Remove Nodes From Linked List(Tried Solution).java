/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode resultList = null;
    public ListNode removeNodes(ListNode head) {

        generateList(head, null, null);
        return resultList;
    }

    private void generateList(ListNode ptr, ListNode prevPtr, ListNode result) {
        if (Objects.nonNull(ptr)) {
            if (Objects.nonNull(prevPtr)) {
                if (ptr.val >= prevPtr.val) {
                    if (Objects.nonNull(result)) {
                        result.next = new ListNode(ptr.val);
                        result = result.next;
                    } else {
                        // Case 1 : When both the values are equal
                        if(ptr.val == prevPtr.val)
                        {
                            result = new ListNode(ptr.val);
                            resultList = result;
                            result.next = new ListNode(prevPtr.val);
                            result = result.next;
                        }
                        // Case 2 : When the next value is greater than the previous value
                        else
                        {
                            result = new ListNode(ptr.val);
                            resultList = result;
                        }
                    }
                }
            }
            generateList(ptr.next, ptr, result);
        }
    }
}