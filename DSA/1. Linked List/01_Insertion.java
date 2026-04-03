class Insertion {
    static ListNode insertAtHead(ListNode head, int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        return node;
    }

    static ListNode insertAtTail(ListNode head, int val) {
        ListNode node = new ListNode(val);
        if (head == null) return node;

        ListNode curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = node;

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