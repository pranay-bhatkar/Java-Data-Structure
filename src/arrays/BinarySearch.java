package dayone.arrays;

public class BinarySearch {

    public static int binarySearch(int[] numbers, int key) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (numbers[mid] == key) {
                return mid;
            } else if (numbers[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 9, 3, 5, 6, 7, 1, 8};
        int key = 0;
        if (binarySearch(numbers, key) == -1) {
            System.out.print("Not Found");
        } else {
            System.out.print("index found at : " + binarySearch(numbers, key));
        }

    }
}