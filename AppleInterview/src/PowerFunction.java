/*
Efficiently implement power function – Iterative and Recursive
Given two integers, x and n, where n is non-negative, efficiently compute the power function pow(x, n).
1. Naive Iterative Solution
A simple solution to calculate pow(x, n) would multiply x exactly n times.
We can do that by using a simple for loop.
2. Using Divide and Conquer
We can recursively define the problem as:
power(x, n) = power(x, n / 2) × power(x, n / 2);        // otherwise, n is even
power(x, n) = x × power(x, n / 2) × power(x, n / 2);    // if n is odd
 */
public class PowerFunction {
    public static void main(String[] args)
    {
        float x = 2;
        int y = -3;
        System.out.printf("%f", power(x, y));
    }
    public static float power(float x, int y) {
        float temp;
        if (y == 0) return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0) return temp * temp;

        else {
            if (y > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }


}
