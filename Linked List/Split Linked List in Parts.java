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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int countOfElements = 0;
        ListNode ptr = head;
        ListNode[] splitListNodes = new ListNode[k];
        int[] sizeOfIndividualPart = new int[k];

        while (Objects.nonNull(ptr)) {
            countOfElements++;
            ptr = ptr.next;
        }

        int equalSizeOfEachPart = countOfElements / k;
        Arrays.fill(sizeOfIndividualPart, equalSizeOfEachPart);

        int remainingSize = countOfElements % k;
        for(int i=0;i<k;i++) {
            if(remainingSize != 0) {
                sizeOfIndividualPart[i]++;
                remainingSize--;
            }
        }

        int countOfPart = 0;
        ListNode iteratorNode = head;

        while (countOfPart < k) {
            iteratorNode = insertElementsInLinkedListAndReturnLastNodeOfLinkedList(sizeOfIndividualPart[countOfPart], splitListNodes, countOfPart, iteratorNode);
            countOfPart++;
        }

        return splitListNodes;
    }

    private ListNode insertElementsInLinkedListAndReturnLastNodeOfLinkedList(int sizeOfPart, ListNode[] splitListNodes, int countOfPart, ListNode head) {
        int countIndex = 0;
        ListNode tempPtr = head;
        ListNode newLinkedList = null;

        for (countIndex = 0; countIndex < sizeOfPart; countIndex++) {
            if (Objects.nonNull(tempPtr) && Objects.isNull(newLinkedList)) {
                newLinkedList = new ListNode(tempPtr.val);
                splitListNodes[countOfPart] = newLinkedList;
            } else if (Objects.nonNull(tempPtr) && Objects.nonNull(newLinkedList)) {
                ListNode listNode = new ListNode();
                listNode.val = tempPtr.val;
                newLinkedList.next = listNode;
                newLinkedList = newLinkedList.next;
            } else if (Objects.isNull(tempPtr)) {
                continue;
            }

            tempPtr = tempPtr.next;
        }

        return tempPtr;
    }
}