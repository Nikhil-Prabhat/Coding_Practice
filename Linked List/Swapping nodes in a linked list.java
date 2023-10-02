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
    public ListNode swapNodes(ListNode head, int k) {
         List<Integer> nodeList = new ArrayList<>();
        ListNode ptr = head;

        while (Objects.nonNull(ptr)) {
            nodeList.add(ptr.val);
            ptr = ptr.next;
        }

        int len = nodeList.size();
        for (int i = 0; i < len; i++) {
            if (i == k - 1) {
                int temp = nodeList.get(i);
                nodeList.set(i, nodeList.get(len - i - 1));
                nodeList.set(len - i - 1, temp);
                break;
            }
        }


        ListNode newHead = new ListNode(nodeList.get(0));
        head = newHead;
        ListNode newPtr = newHead;

        for (int i = 1; i < nodeList.size(); i++) {
            newPtr.next = new ListNode(nodeList.get(i));
            newPtr = newPtr.next;
        }

        return head;
    }
}