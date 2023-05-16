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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode parentListNode = list1;
        ListNode terminalListNode = null;
        boolean foundA = false;
        boolean foundB = false;
        int counter = 0;

        while (Objects.nonNull(list1.next)) {
            // Mark the flag when the a or b is found in the listnode
            if (counter == a) {
                foundA = true;
            }
            if (counter == b) {
                foundB = true;
                terminalListNode = list1.next;
            }

            // Set parent only when a or b is not encountered
            if (!foundA)
                parentListNode = list1;

            list1 = list1.next;
            counter++;

            // If both the ends are found, adjust the listnode 2
            if (foundA && foundB) {
                parentListNode.next = list2;
                while (Objects.nonNull(list2.next)) {
                    list2 = list2.next;
                }

                list2.next = terminalListNode;

                // It should be executed only once
                foundA = false;
                foundB = false;
            }

            continue;
        }

        return head;
    }
}