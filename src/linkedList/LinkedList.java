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
    public static int size;

    // add () -> O(n)
    public void addFirst(int data) {
        // 1. create new node
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }


        // 2. new node's head = next -> linking step
        newNode.next = head;

        // 3. head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        // 1. create a new node
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // 2. tail.next = new node
        tail.next = newNode;

        // 3. tail = new node
        tail = newNode;
    }

    // add middle -> O(n)
    public void addMiddle(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        // 1. create a new node
        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // traverse the LL (print) -> O(n)
    public void print() {
        Node temp = head;

        while (temp != null) {
            if (head == null) {
                System.out.println("LL is empty");
                return;
            }
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
//        l1.head = new Node(1);
//        l1.head.next = new Node(2);

        l1.print();
//         add first
        l1.addFirst(2);
        l1.print();
        l1.addFirst(1);
        l1.print();
//        add last
        l1.addLast(3);
        l1.print();
        l1.addLast(4);
        l1.print();

        l1.addMiddle(2, 9);
        l1.print();

        System.out.println("LL size : " + l1.size);


    }
}