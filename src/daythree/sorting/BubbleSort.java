package daythree.sorting;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int turn = 0; turn < n - 1; turn++) {
            int swaped =0;
            for (int j = 0; j < n - 1 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaped++;
                }
            }
            if(swaped == 0){
                break;
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

        bubbleSort(arr);
        printArr(arr);
    }
}