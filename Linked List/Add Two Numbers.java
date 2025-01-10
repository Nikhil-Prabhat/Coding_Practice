import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String firstNumber = "";
        String secondNumber = "";
        ListNode finalListNode = null;
        ListNode tempPtr = null;

        while (Objects.nonNull(l1)) {
            firstNumber = l1.val + firstNumber;
            l1 = l1.next;
        }

        while (Objects.nonNull(l2)) {
            secondNumber = l2.val + secondNumber;
            l2 = l2.next;
        }

        String resultSum = new BigInteger(firstNumber).add(new BigInteger(secondNumber)).toString();
        String[] resultSumArray = resultSum.split("");

        for (int i = resultSumArray.length - 1; i > -1; i--) {
            if (Objects.isNull(finalListNode)) {
                finalListNode = new ListNode(Integer.valueOf(resultSumArray[i]));
                tempPtr = finalListNode;
                continue;
            }

            tempPtr.next = new ListNode(Integer.valueOf(resultSumArray[i]));
            tempPtr = tempPtr.next;
        }

        return finalListNode;
    }
}
