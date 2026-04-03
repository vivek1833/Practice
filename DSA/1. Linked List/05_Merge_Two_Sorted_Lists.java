class MergeTwoSortedLists {
    static ListNode mergeIterative(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    static ListNode mergeRecursive(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.val <= b.val) {
            a.next = mergeRecursive(a.next, b);
            return a;
        }
        b.next = mergeRecursive(a, b.next);
        return b;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) { 
        this.val = val; 
    }
}