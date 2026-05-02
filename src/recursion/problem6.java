package recursion;

// find the first occurrence of an element in an array
public class problem6 {
    public static int firstOccurrence(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return firstOccurrence(arr, key, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 5, 2};
        int key = 6;
        System.out.println(firstOccurrence(arr, key, 0));
    }
}