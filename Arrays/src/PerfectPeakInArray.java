import java.util.ArrayList;

/*
Problem Description
Given an integer array A of size N.
You need to check that whether there exist a element which is strictly greater than all
the elements on left of it and strictly smaller than all the elements on right of it.
If it exists return 1 else return 0.
NOTE:Do not consider the corner elements i.e A[0] and A[N-1] as the answer.
Problem Constraints
3 <= N <= 105
1 <= A[i] <= 109
Input Format
First and only argument is an integer array A containing N integers.
Output Format
Return 1 if there exist a element that is strictly greater than all the elements on left of it
and strictly  smaller than all the elements on right of it else return 0.
Example Input :Input 1: A = [5, 1, 4, 3, 6, 8, 10, 7, 9]
Input 2:A = [5, 1, 4, 4]
Example Output : Output 1: 1
Output 2: 0
Example Explanation Explanation 1:
A[4] = 6 is the element we are looking for.All elements on left of A[4] are smaller than it and all
elements on right are greater.
Explanation 2:No such element exits.
An Efficient Solution can solve this problem in O(N) time using O(N) extra space.
Below is detailed solution.
Create two arrays leftMax[] and rightMin[].
1. Traverse input array from left to right and fill leftMax[] such that leftMax[i] contains maximum element
from 0 to i-1 in input array.
2. Traverse input array from right to left and fill rightMin[] such that rightMin[i] contains minimum element
from to N-1 to i+1 in input array.
3. Traverse input array. For every element A[i], check if A[i] is greater than leftMax[i] and smaller than
rightMin[i]. If yes, return 1.
If loops exits and no such element found return 0
 */
public class PerfectPeakInArray {
    public static void main (String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(5); A.add(1); A.add(4); A.add(3); A.add(6); A.add(8); A.add(10); A.add(7); A.add(9);
        System.out.println("Perfect Peak is " +perfectPeak(A));

    }
    public static int perfectPeak(ArrayList<Integer> A) {
        int n = A.size();
        int max[] = new int[n];
        int min[] = new int[n];
        max[0] = A.get(0);
        min[n - 1] = A.get(n - 1);
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], A.get(i));
        }
        for (int j = n - 2; j >= 0; j--) {
            min[j] = Math.min(min[j + 1], A.get(j));
        }
        for (int i = 1; i < n - 1; i++) {
            if (A.get(i) > max[i - 1] && A.get(i) < min[i + 1]) {
                return 1;
            }
        }
        return 0;
    }
}
