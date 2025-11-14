/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;           // slow moves 1 step
            fast = fast.next.next;      // fast moves 2 steps
            if (slow == fast) {         // they meet inside cycle
                return true;
            }
        }
        return false; // fast reached null → no cycle
    }
}
