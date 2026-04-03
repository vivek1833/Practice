class ReverseNodesInKGroup {
    static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode curr = head;

        for (int i = 0; i < k; i++) {
            if (curr == null) return head;
            curr = curr.next;
        }

        ListNode prev = null, node = head;
        for (int i = 0; i < k; i++) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        
        head.next = reverseKGroup(node, k);
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) { this.val = val; }
}