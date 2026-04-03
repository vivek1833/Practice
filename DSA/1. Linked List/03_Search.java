class Search {
    static boolean contains(ListNode head, int key) {
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == key) return true;
            curr = curr.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) { 
        this.val = val; 
    }
}