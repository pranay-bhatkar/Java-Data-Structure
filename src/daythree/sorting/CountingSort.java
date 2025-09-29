package daythree.sorting;

public class CountingSort {
    public static void countingSort(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int[] count = new int[largest + 1];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // sorting
        int j=0;
        for (int i = 0; i <count.length; i++) {
            if(count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

    }

    public static void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 3, 2};
        countingSort(arr);
        printArr(arr);
    }
}