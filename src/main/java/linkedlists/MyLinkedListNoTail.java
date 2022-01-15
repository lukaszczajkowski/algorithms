package linkedlists;

public class MyLinkedListNoTail {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    private Node head;

    public void addValue(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }


    // assuming we're not removing the first nor the last element and the idx exists
    public void removeAtIdx(int idx) {
        int currentIdx = 0;
        Node current = head;

        while (currentIdx < idx - 1) {
            current = current.next;
            currentIdx++;
        }

        current.next = current.next.next;
    }

    public void insertHead(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }
}
