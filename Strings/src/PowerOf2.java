/*
Find if Given number is power of 2 or not.
More specifically, find if given number can be expressed as 2^k where k >= 1.
Input: number length can be more than 64, which mean number can be greater than 2 ^ 64
(out of long long range)
Output: return 1 if the number is a power of 2 else return 0
Example: Input : 128 Output : 1
 */
public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println("Is Power Of Two Integers  "+isPowerOfTwo(4));
        System.out.println("Is Power Of Two Integers  "+isPowerOfTwo(3));

    }

    public static boolean isPowerOfTwo(int A) {

        if (A == 1 || A == 2) return true;

        for (int i = 2; i * i <= A; i++) {
            int p = A;
            while (p % i == 0) {
                p /= i;
            }
            if (p == 1) {
                return true;
            }
        }
        return false;
    }
}
