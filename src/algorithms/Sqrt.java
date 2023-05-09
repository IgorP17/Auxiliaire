package algorithms;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600)); //46340
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(9));
    }

    private static int mySqrt(int x) {
        if (x == 1 || x == 0)
            return x;

        int low = 0;
        int high = x / 2;
        long mid;

        while ((low < high) && ((high - low) != 1)) {
            mid = (low + high) / 2;
            if (mid * mid == x)
                return (int) mid;
            else if (mid * mid > x)
                high = (int) mid;
            else
                low = (int) mid;
        }
        return low;
    }
}
