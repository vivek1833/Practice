class CopyListWithRandomPointer {
    static Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        Node dummy = new Node(-1), copyTail = dummy;
        curr = head;
        while (curr != null) {
            Node clone = curr.next;
            curr.next = clone.next;
            copyTail.next = clone;
            copyTail = clone;
            curr = curr.next;
        }
        
        return dummy.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}