package recursion;

// print sum of first n natural numbers

public class problem3 {

    public static int calculateSum(int n) {
        if (n == 1) {
            return 1;
        }

        int snm1 = calculateSum(n - 1);
        int sn = n + snm1;
        return sn;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(calculateSum(n));
    }

}