package daytwo.arrays;

public class MaxSubArraySum {
    public static void maxSubarraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + (arr[j]);
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("max sum = " + maxSum);
    }

    public static void minSubarraySum(int[] arr) {
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];

                if (sum < minSum) {
                    minSum = sum;
                }
            }
        }

        System.out.println("Min sum = " + minSum);
    }


    // optimised approach => prefix sum


    public static void main(String[] args) {
        int[] arr = {1, -2, 6, -1, 3};
//        int[] arr = {2 , 4, 6, 8, 10};

        maxSubarraySum(arr);
        minSubarraySum(arr);
    }
}