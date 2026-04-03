class MiddleOfLinkedList {
    static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val; 
    }
}