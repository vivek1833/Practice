class DoublyLinkedListBasics {
    static Node insertAtHead(Node head, int val) {
        Node node = new Node(val);
        node.next = head;
        if (head != null) head.prev = node;
        return node;
    }

    static Node insertAtTail(Node head, int val) {
        if (head == null) return new Node(val);
        Node curr = head;

        while (curr.next != null) curr = curr.next;

        Node node = new Node(val);
        curr.next = node;
        node.prev = curr;

        return head;
    }

    static Node deleteAtPosition(Node head, int pos) {
        if (head == null || pos <= 0) return head;
        if (pos == 1) {
            Node newHead = head.next;
            if (newHead != null) newHead.prev = null;
            return newHead;
        }

        Node curr = head;
        for (int i = 1; curr != null && i < pos; i++) curr = curr.next;

        if (curr == null) return head;
        if (curr.prev != null) curr.prev.next = curr.next;
        if (curr.next != null) curr.next.prev = curr.prev;
        
        return head;
    }
}

class Node {
    int val;
    Node next, prev;
    Node(int val) {
        this.val = val;
    }
}