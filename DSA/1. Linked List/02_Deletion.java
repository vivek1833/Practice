class Deletion {
    static ListNode deleteHead(ListNode head) {
        return head == null ? null : head.next;
    }

    static ListNode deleteByValue(ListNode head, int target) {
        if (head == null) return null;
        if (head.val == target) return head.next;
        ListNode curr = head;
        while (curr.next != null && curr.next.val != target) curr = curr.next;
        if (curr.next != null) curr.next = curr.next.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) { 
        this.val = val; 
    }
}