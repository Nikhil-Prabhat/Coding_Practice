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
    public int pairSum(ListNode head) {

        List<Integer> integerList = new ArrayList<>();
        ListNode ptr = head;

        while (ptr != null) {
            integerList.add(ptr.val);
            ptr = ptr.next;
        }

        int twinSum = Integer.MIN_VALUE;
        int n = integerList.size();
        for (int i = 0; i < n / 2; i++) {
            int sum = integerList.get(i) + integerList.get(n - i - 1);
            twinSum = sum > twinSum ? sum : twinSum;
        }

        return twinSum;
        
    }
}