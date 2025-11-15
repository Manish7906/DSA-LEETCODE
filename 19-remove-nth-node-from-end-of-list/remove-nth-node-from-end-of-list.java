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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // First pass: count total nodes
        int count = 0;
        ListNode temp = head;
        
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // If we remove the head node
        if (count == n) {
            return head.next;
        }

        // Find the node before the one we want to remove
        int steps = count - n;
        temp = head;

        for (int i = 1; i < steps; i++) {
            temp = temp.next;
        }

        // Remove the nth node from end
        temp.next = temp.next.next;

        return head;
    }
}
