package dayone.arrays;

public class SubArrays {
    public static void printSubarrays(int[] numbers) {
        int tp = 0; // total subarrays = n(n+1) / 2
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(numbers[k] + " ");
                    sum = sum + numbers[k];
                }

                System.out.print(" | subarray sum = " + sum);

                if (sum > maxSum) {
                    maxSum = sum;
                }
                if (sum < minSum) {
                    minSum = sum;
                }
                tp++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("total pairs : " + tp);
        System.out.println("Maximum subarray sum is : " + maxSum);
        System.out.println("Minimum subarray sum is : " + minSum);
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10};
        printSubarrays(numbers);

    }
}