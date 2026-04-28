package linkedList.pratice;

import java.util.LinkedList;

public class Sample {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3,8);
        list.addFirst(4);
        list.addLast(0);


        for(int val : list){
            System.out.print(val + " -> ");
        }
        System.out.println("null");

        System.out.println(list.getLast());
        System.out.println(list.getFirst());
        System.out.println(list.get(5));
    }
}