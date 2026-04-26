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

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // prev : i = size - 2;
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;

    }

    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthFromLast(int n) {
        // cal size
        int size = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (n == size) {
            head = head.next; // removeFirst
            return;
        }

        // size - n
        int i = 1;
        int iToFind = size - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // slow - fast approach
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2

        }
        return slow; // slow is my middle node;
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. find mid
        Node midNode = findMid(head);

        // 2. reverse 2n half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // RH head
        Node left = head; // LH head

        // 3. check left half & right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
//        l1.head = new Node(1);
//        l1.head.next = new Node(2);
//
//        l1.print();
////         add first
//        l1.addFirst(2);
//        l1.print();
//        l1.addFirst(1);
//        l1.print();
////        add last
//        l1.addLast(3);
//        l1.print();
//        l1.addLast(4);
//        l1.print();
//
//        l1.addMiddle(2, 9);
//        l1.print();
//
//        System.out.println("LL size : " + l1.size);
//        l1.removeFirst();
//        l1.print();
//
//        l1.removeLast();
//        l1.print();
//        System.out.println(l1.size);
//
//        System.out.println(l1.itrSearch(3));
//        System.out.println(l1.itrSearch(10));
//
//        System.out.println(l1.recSearch(9));
//
////        l1.reverse();
////        l1.print();
//        l1.deleteNthFromLast(2);
//        l1.print();
//
//        l1.addFirst(1);
//        l1.addFirst(8);
//


        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(1);
        l1.print();

        System.out.println(l1.isPalindrome());

    }
}