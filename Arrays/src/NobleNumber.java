import java.util.ArrayList;
import java.util.Collections;

/*
Given an integer array A, find if an integer p exists in the array such that the number of
integers greater than p in the array equals to p.
Input Format
First and only argument is an integer array A.
Output Format
Return 1 if any such integer p is found else return -1.
Example Input
Input 1: A = [3, 2, 1, 3]
Input 2: A = [1, 1, 3, 3]
Example Output
Output 1: 1
Output 2: -1
Example Explanation
Explanation 1: For integer 2, there are 2 greater elements in the array. So, return 1.
Explanation 2: There is no such integer exists.
 */
public class NobleNumber {
    public static void main (String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3); A.add(2); A.add(1); A.add(3);
        System.out.println(" Noble Number in the given array is  " +solve(A));
        ArrayList<Integer> B = new ArrayList<>();
        B.add(1); B.add(1); B.add(3); B.add(3);
        System.out.println(" Noble Number in the given array is  " +solve(B));
    }

     public static int solve(ArrayList<Integer> A) {
         // Total runtime: O(n log n) due to sort
        Collections.sort(A);
        for (int i = 0; i < A.size(); i++) {
            // Handle duplicates (only check for rightmost duplicate), skip others
            if (i < A.size() - 1 && A.get(i) == A.get(i + 1)) {
                continue;
            }
            // Check if the remaining values to the right are equal to the current value
            if (A.size() - i - 1 == A.get(i)) {
                return 1;
            }
        }
        return  -1;
    }
}
