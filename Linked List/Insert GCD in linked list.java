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
    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode startingNode = head;
        while (Objects.nonNull(startingNode) && Objects.nonNull(startingNode.next)) {
            int firstNumber = startingNode.val;
            int secondNumber = startingNode.next.val;
            int gcdOfTwoNumbers = firstNumber > secondNumber ? findGCD(firstNumber, secondNumber) : findGCD(secondNumber, firstNumber);
            ListNode intermediateNode = new ListNode(gcdOfTwoNumbers);
            ListNode currentNextNode = startingNode.next;
            startingNode.next = intermediateNode;
            intermediateNode.next = currentNextNode;
            startingNode = currentNextNode;
        }

        return head;
    }

    private int findGCD(int a, int b) {
        if (b == 0)
            return a;
        return findGCD(b, a % b);
    }
}