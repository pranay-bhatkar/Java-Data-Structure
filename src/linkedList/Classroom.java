package linkedList;

import java.util.LinkedList;

public class Classroom {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(1);
        list.addLast(2);
        list.addFirst(0);

        System.out.println(list);

        list.removeLast();
        list.removeFirst();

        System.out.println(list);
    }
}