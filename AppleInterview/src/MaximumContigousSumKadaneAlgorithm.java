/*
Kadane's Algorithm is Iterative Dynamic Programming Algorithm
It caluclates the maximum subarray ending at the particualr position by using the maximum sum subarray
ending at a particualr position by using the maximum sum subarray at previous position.
Define two variables maxEndingHere which stores maximum sum ending here and maxSoFar
which stores maximum sum so far.
O(n) Time complexity and O(1) space
 */
public class MaximumContigousSumKadaneAlgorithm {
    public static void main (String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(" Kadane Algorithm result for given array is :" +kadanesAlgorithm(a));
    }
    // Function to find the maximum sum of a contiguous subarray
    // in a given integer array
    public static int kadanesAlgorithm(int[] A) {

        int maxEndingHere = A[0];
        int maxSoFar = A[0];
        for (int i = 1; i < A.length; i++) {
            int num = A[i];
            maxEndingHere = Math.max(maxEndingHere + num , num);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
