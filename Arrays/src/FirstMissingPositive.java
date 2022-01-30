import java.util.ArrayList;

/*
Given an unsorted integer array, find the first missing positive integer.
Example:
Given [1,2,0] return 3,
[3,4,-1,1] return 2,
[-8, -7, -6] returns 1
Your algorithm should run in O(n) time and use constant space.
SOLUTION APPROACH ::
Note: numbers A[i]<=0 and A[i]>N ( N being the size of the array ) is not important to us
since the missing positive integer will be in the range [1, N+1].
The answer will be N+1 only if all of the elements of the array are exact one occurrence of [1, N].
Creating buckets would have been an easy solution if using extra space was allowed.
An array of size N initialized to 0 would have been created.
For every value A[i] which lies in the range [1, N], its count in the array would have been incremented.
Finally, traversing the array would help to find the first array position with value 0 and that will be
our answer.
However, usage of buckets is not allowed, can we use the existing array as bucket somehow?
Now, since additional space is not allowed either, the given array itself needs to be used to track it.
It may be helpful to use the fact that the size of the set we are looking to track is [1, N]
which happens to be the same size as the size of the array.
This means we can use the array to track these elements.
We traverse the array and if A[i] is in [1,N] range, we try to put in the index of same value in the array.
 */
public class FirstMissingPositive {
    public static void main (String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1); A.add(2); A.add(0);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(3); B.add(4); B.add(-1);B.add(1);
        ArrayList<Integer> C = new ArrayList<>();
        C.add(-8); C.add(-7); C.add(-6);
        System.out.println("A   " +firstMissingPositive(A));
        System.out.println("B   " +firstMissingPositive(B));
        System.out.println("C   " +firstMissingPositive(C));

    }
    public static int firstMissingPositive(ArrayList<Integer> A) {
        int mx = 1;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == mx) {
                mx = mx + 1;
            }
        }
        return mx;
    }
}
