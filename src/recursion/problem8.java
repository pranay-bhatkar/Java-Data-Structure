package recursion;

// print x^n
public class problem8 {

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int xnm1 = power(x, n - 1);
        int xn = x * xnm1;

        return xn;
    }

    public static int optimisedPower(int a, int n) {
        if (n == 0) {
            return 1;
        }

        int halfPower = optimisedPower(a, n/2);
        int halfPowerSq = halfPower * halfPower;

        if (n % 2 != 0) {
            return a * halfPowerSq;
        }

        return halfPowerSq;
    }

    public static void main(String[] args) {

        System.out.println(power(2, 3));
        System.out.println(optimisedPower(3, 0));
    }
}