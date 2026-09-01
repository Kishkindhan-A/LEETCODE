class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head;

        while (curr != null) {
            if (head.val == val) {
                head = head.next;
                curr = head;
                prev = head;
            } 
            else if (curr.val != val) {
                prev = curr;
                curr = curr.next;
            } 
            else {
                prev.next = curr.next;
                curr = curr.next;
            }
        }

        return head;
    }
}