
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode result = null;
        ListNode headOfResult = null;
        int sumOfIntermediateNodes = 0;
        while(head != null)
        {
            if(head.val == 0) {
                // Addition of new nodes in result only in case sumOfIntermediateNodes is not 0
                if (sumOfIntermediateNodes != 0) {
                    if (result != null) {
                        result.next = new ListNode(sumOfIntermediateNodes);
                        result = result.next;
                    }
                    else {
                        // When the head is null
                        result = new ListNode(sumOfIntermediateNodes);
                        headOfResult = result;
                    }
                }
                sumOfIntermediateNodes = 0;
            }
            else
                sumOfIntermediateNodes += head.val;
            head = head.next;
        }
        return headOfResult;
    }
}