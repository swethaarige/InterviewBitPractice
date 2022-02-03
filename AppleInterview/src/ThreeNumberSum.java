/*
Problem statement: Given an array of integers and a value, determine if
there are any three integers in the array whose sum equals the given value.
Consider this array and the target sums.3 7 1 2 8 4 5

/*
METHOD 1. Naive approach: Use three for loops
The naive approach is to just use three nested for loops and check if the sum of any three elements
in the array is equal to the given target.
class ThreeSum {

  // Time complexity: O(n^3)
  private static List<Integer[]> findThreeSum_BruteForce(int[] nums, int target) {
    List<Integer[]> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[i] + nums[j] + nums[k] == target) {
            result.add(new Integer[] { nums[i], nums[j], nums[k] });
          }
        }
      }
    }
    return result;
  }
 */

/*
METHOD 2. Use Sorting along with the two-pointer approach
Another approach is to first sort the array, then -

Iterate through each element of the array and for every iteration,
Fix the first element (nums[i])
Try to find the other two elements whose sum along with nums[i] gives target.
This boils down to the two sum problem.
Time complexity: O(n^2)
Memory Complexity: Constant, O(1)
 */


import java.util.ArrayList;
import java.util.Collections;

public class ThreeNumberSum {
    public static void main (String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3); list.add(7); list.add(1); list.add(2); list.add(8); list.add(4); list.add(5);
        System.out.println("Find Sum of Three is  " + findSumOfThree(list, 20));
        System.out.println("Find Sum of Three is  " + findSumOfThree(list, 21));
    }
    public static boolean findSumOfThree(ArrayList<Integer> list, int targetSum) {
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            int leftIdx = i + 1;
            int rightIdx = list.size() - 1;
             while (leftIdx < rightIdx) {
                 int actualSum = list.get(i) + list.get(leftIdx) + list.get(rightIdx);
                 if (actualSum == targetSum) {
                     return true;
                 } else if (actualSum < targetSum) {
                     leftIdx++;
                 } else {
                     rightIdx--;
                 }
             }
        }
        return false;

    }
}
