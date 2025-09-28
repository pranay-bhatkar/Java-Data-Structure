package dayone.arrays;

public class Basic {

    public static void update(int[] marks) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("====== Array Learning ======");

        int[] marks = {91, 96, 98};
        update(marks);

        for (int arr : marks) {
            System.out.print(arr + " ");
        }
    }
}