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
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;

        while (curr.next != null) {
            int num1 = curr.val;
            int num2 = curr.next.val;

            int gcd = gcd(num1, num2);
            ListNode newNode = new ListNode(gcd);
            newNode.next = curr.next;
            curr.next = newNode;

            curr = curr.next.next;
        }
        return head;
    }
}