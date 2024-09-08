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
        ListNode[] list = new ListNode[k];

        ListNode curr = head;

        // --------------
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        if (count <= k) {
            curr = head;
            int idx = 0;
            while (curr != null) {
                list[idx++] = new ListNode(curr.val);
                curr = curr.next;
            }
            return list;
        }

        int f_parts = count % k;
        int rem = ( count / k );

        curr = head;
        ListNode prev = null;

        for (int i = 0; i < k; i++) {
            list[i] = curr;

            int partSize = rem + (f_parts > 0 ? 1 : 0);
            f_parts--;
            
            for (int c = 0; c < partSize; c++) {
                prev = curr;
                if (curr != null) {
                    curr = curr.next;
                }
            }

            if (prev != null) {
                prev.next = null;
            }
        }

        return list;
    }
}