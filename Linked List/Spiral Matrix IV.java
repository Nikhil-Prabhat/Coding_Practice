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
   public int[][] spiralMatrix(int m, int n, ListNode head) {

        // Initialise 2D matrix and fill with default value
        int[][] spiralMatrix = new int[m][n];
        List<Integer> integerList = new ArrayList<>();

        Arrays.stream(spiralMatrix).forEach(
                arr -> Arrays.fill(arr, -1)
        );

        // Get all the elements in the list from Linked List
        while (head != null) {
            integerList.add(head.val);
            head = head.next;
        }

        int counter = 0;
        String direction = "right";
        int i = 0, j = 0;
        spiralMatrix[0][0] = integerList.get(0);

        while (++counter < integerList.size()) {
            try {
                if (direction.equals("right")) {
                    ++j;

                    if (spiralMatrix[i][j] == -1)
                        spiralMatrix[i][j] = integerList.get(counter);
                    else
                        throw new Exception("Element present at right !!");

                }

                if (direction.equals("down")) {
                    ++i;
                    if (spiralMatrix[i][j] == -1)
                        spiralMatrix[i][j] = integerList.get(counter);
                    else
                        throw new Exception("Element present at down !!");

                }

                if (direction.equals("left")) {
                    --j;
                    if (spiralMatrix[i][j] == -1)
                        spiralMatrix[i][j] = integerList.get(counter);
                    else
                        throw new Exception("Element present at left !!");

                }

                if (direction.equals("up")) {
                    --i;
                    if (spiralMatrix[i][j] == -1)
                        spiralMatrix[i][j] = integerList.get(counter);
                    else
                        throw new Exception("Element present at up !!");

                }

            } catch (Exception ex) {
                if (direction.equals("right")) {
                    --j;
                    direction = "down";
                } else if (direction.equals("down")) {
                    --i;
                    direction = "left";
                } else if (direction.equals("left")) {
                    ++j;
                    direction = "up";
                } else if (direction.equals("up")) {
                    ++i;
                    direction = "right";
                }

                --counter;
            }
        }

        return spiralMatrix;
    }
}