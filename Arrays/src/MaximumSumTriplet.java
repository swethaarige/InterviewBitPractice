/*
Given an array A containing N integers.
You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.
If no such triplet exist return 0.
Problem Constraints
3 <= N <= 105.
1 <= A[i] <= 108.
Input Format
First argument is an integer array A.
Output Format
Return a single integer denoting the maximum sum of triplet as described in the question.
Example Input Input 1: A = [2, 5, 3, 1, 4, 9]
Input 2:A = [1, 2, 3] Example Output
Output 1:16
Output 2:6
Example Explanation Explanation 1: All possible triplets are:-
    2 3 4 => sum = 9
    2 5 9 => sum = 16
    2 3 9 => sum = 14
    3 4 9 => sum = 16
    1 4 9 => sum = 14
Maximum sum = 16
Explanation 2:All possible triplets are:- 1 2 3 => sum = 6  Maximum sum = 6
 */

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaximumSumTriplet {
    public static void main (String[] args) {
        int[] array = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7 };
        ArrayList<Integer> list = IntStream.of(array)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        int resultsum = threeLargest(list);
        System.out.println("Three largest Numbers in the given array are : "
                +resultsum);
    }
   public static int threeLargest(ArrayList<Integer> list) {
       int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
       for (int num : list) {
           updateLargest(threeLargest, num);
       }
       int sum = threeLargest[0] + threeLargest[1] + threeLargest[2];
       return sum;
   }
    public static void updateLargest(int[] threeLargest, int num) {
        if (num > threeLargest[2]) {
            updateAndShift(threeLargest, num, 2);
        }
        else if (num > threeLargest[1]) {
            updateAndShift(threeLargest, num, 1);
        }
        else if (num > threeLargest[0]) {
            updateAndShift(threeLargest, num , 0);
        }
    }

    public static void updateAndShift(int[] array, int num, int index) {
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                array[i] = num;
            }
            else {
                array[i] = array[i + 1];
            }
        }
    }
}
