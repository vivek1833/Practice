class KthNodeFromEnd {
    static int kthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) throw new IllegalArgumentException("k is larger than list size");
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow.val;
    }
}

class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }