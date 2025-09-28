package dayone.arrays;

public class PairsInAnArray {
    public static void printPairs(int[] numbers){
        // total pairs = n(n-1) / 2

        int tp = 0;
        for(int i=0; i< numbers.length; i++){
            int current = numbers[i];
            for(int j= i+1;j< numbers.length;j++){
                System.out.print("(" + current + "," + numbers[j] + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.print("total pairs : " + tp );
    }


    public static void main(String[] args) {
        int[] numbers = {2,4,6,8,10};
        printPairs(numbers);
    }
}