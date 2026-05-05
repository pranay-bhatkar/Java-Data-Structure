package daytwo.arrays;

public class KadansSum {

    public static void kadansSum(int[] arr){
//        int minSum = arr[0];
//        int currentSum = arr[0];
//
//        for(int i =0;i< arr.length;i++){
//            currentSum = Math.min(arr[i] , currentSum+ arr[i]);
//            minSum = Math.min(minSum, currentSum);
//        }
//        System.out.println(minSum);

        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for(int i =0; i<arr.length;i++){
            cs = cs + arr[i];
            if(cs < 0 ) {
                cs  = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println("max sum = "+ ms);
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 6, -1, 3};
        kadansSum(arr);
    }
}