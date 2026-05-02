package recursion;

// find the last occurrence of an element in an array

public class problem7 {

    public static int lastOccurrence(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }

        int isFound = lastOccurrence(arr, key, i + 1);

        if (isFound != -1) {
            return isFound;
        }

        if (arr[i] == key) {
            return i;
        }

        return isFound;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 1, 5, 1};
        int key = 1;
        System.out.println(lastOccurrence(arr, key, 0));
    }
}