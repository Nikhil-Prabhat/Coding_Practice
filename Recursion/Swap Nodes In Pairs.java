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
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = null;
        ListNode ptr = head;
        ListNode prevPtr = null;

        while (Objects.nonNull(ptr)) {
            ListNode listNode1 = null;
            ListNode listNode2 = null;
            listNode1 = ptr;
            ptr = ptr.next;

            if (Objects.nonNull(ptr)) {
                listNode2 = ptr;
                ptr = ptr.next;
            }

            ListNode nodesAfterSwapping = swap(listNode1, listNode2);
            if (Objects.isNull(newHead)) {
                newHead = nodesAfterSwapping;
            } else {
                prevPtr.next = nodesAfterSwapping;
            }

            prevPtr = nodesAfterSwapping.next;


        }

        return newHead;
    }


    private ListNode swap(ListNode listNode1, ListNode listNode2) {
        if (Objects.isNull(listNode2)) {
            return listNode1;
        } else if (Objects.nonNull(listNode1) && Objects.nonNull(listNode2)) {
            ListNode tempNextReference = listNode2.next;
            listNode2.next = listNode1;
            listNode1.next = tempNextReference;
            return listNode2;
        }
        return null;
    }
}


// Another Solution

class Solution {
  int cnt = 0;

  public ListNode swapPairs(ListNode node) {
    if (node == null) return null;

    cnt++;
    var ret = swapPairs(node.next);

    if (cnt % 2 == 1 && ret != null) {
      // node -> the first (left) node in each pair
      node.next = ret.next;
      ret.next = node;
    } else {
      // node -> the second (right) node in each pair
      node.next = ret;
      ret = node;
    }
    cnt--;
    return ret;
  }
}