package recursion;

// print factorial of a number n

public class problem2 {
    public static int fact(int n) {
        if (n < 0) {
            return -1;
        }

        if (n == 0) {
            return 1;
        }

        int fnm1 = fact(n - 1);
        int fn = n * fact(n - 1);
        return fn;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("factorial of " + n + " is " + fact(n));
    }
}