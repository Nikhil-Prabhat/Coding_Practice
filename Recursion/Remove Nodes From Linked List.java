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
    
    public ListNode removeNodes(ListNode head) {

        if (Objects.nonNull(head) && Objects.nonNull(head.next)) {
            ListNode newHead = removeNodes(head.next);
            if (newHead.val > head.val) return newHead;
            head.next = newHead;
        }
        return head;
    }
}