class SwapKthNodeFromStartEnd {
    static ListNode swapNodes(ListNode head, int k) {
        ListNode first = head, fast = head, second = head;
        for (int i = 1; i < k; i++) fast = fast.next;
        first = fast;

        while (fast.next != null) {
            fast = fast.next;
            second = second.next;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
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