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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        
        boolean l = isSubPath(head, root.left);

        if (root.val == head.val) {
            boolean res = havePath(head, root);
            if (res) {
                return true;
            }
        }

        boolean r = isSubPath(head, root.right);

        if (r || l) {
            return true;
        }
        else {
            return false;
        }
    
    }

    public boolean havePath(ListNode head, TreeNode root) {

        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (head.val == root.val) {
            boolean r_res = havePath(head.next, root.right);
            boolean r_left = havePath(head.next, root.left);

            if (r_res || r_left) {
                return true;
            }
        }

        return false;
    }
}