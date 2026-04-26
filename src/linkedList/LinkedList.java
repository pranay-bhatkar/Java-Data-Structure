package linkedList;

public class LinkedList {
    // creation of the node
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    // add ()
    public void addFirst(int data) {
        // 1. create new node
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }


        // 2. new node's head = next -> linking step
        newNode.next = head;

        // 3. head = newNode
        head = newNode;
    }

    // remove ()
    //

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
//        l1.head = new Node(1);
//        l1.head.next = new Node(2);

        l1.addFirst(1);
        l1.addFirst(2);

    }
}