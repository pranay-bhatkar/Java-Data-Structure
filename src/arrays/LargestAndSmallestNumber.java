package dayone.arrays;

public class LargestAndSmallestNumber {

    public static int getLargest(int[] numbers) {
        int largest = Integer.MIN_VALUE; // -infinity - lowest value

        for (int i = 0; i < numbers.length; i++) {
            if (largest < numbers[i]) {
                largest = numbers[i];
            }
        }

        return largest;
    }

    public static int getSmallest(int[] numbers) {
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (smallest > numbers[i]) {
                smallest = numbers[i];
            }
        }

        return smallest;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 8, 3, 9, 2, 5, 6};

        int largest = getLargest(numbers);
        System.out.println("largest number : " + largest);

        int smallest = getSmallest(numbers);
        System.out.println("smallest number : " + smallest);


    }
}