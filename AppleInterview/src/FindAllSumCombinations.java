import java.util.ArrayList;

/*
Given a positive integer, target, print all possible combinations of positive integers that
sum up to the target number.
For example, if we are given input ‘5’, these are the possible sum combinations.
The output will be in the form a list of lists or an array of arrays.
Each element in the list will be another list containing a possible sum combination.
Recursion Two lists
Runtime Complexity Exponential.
Memory Complexity Linear, O(n).
Solution Breakdown:
1. Here we will recursively go through all possible sum combinations. Whenever the running sum equals
the target, we will print that combination.
The algorithm will recursively check all the numbers which can sum up to the target.
2.In each recursive call, there is a for loop which runs from start to target. start is initially 1.
The current_sum is the variable that is incremented in every recursive call.
3.Here is the logic of the code; every time a value is added to the current_sum, it is also added
to the result list which is the sum combination for that particular call. Whenever current_sum
becomes equal to target, we can be sure that the result list contains a possible combination for
target. This list is appended to the final output list.
4.Base condition of recursion:
if current_sum equals target print the output contents
Before each recursive call, an element is added to result. However, after each call,
this element is also removed from the list in order to reset the list.
 */
public class FindAllSumCombinations {
    public static ArrayList<ArrayList<Integer>> printAllCombinationsToSum(int target) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        printAllCombinationsRecursion(target, 0, 1, output, result);
        return output;
    }
    public static void printAllCombinationsRecursion(int target,
                                                     int currentSum, int start,
                                                     ArrayList<ArrayList<Integer>> output,
                                                     ArrayList<Integer> result) {
        if (target == currentSum) {
            output.add((ArrayList)result.clone());
        }
        for (int i = start; i < target; i++) {
            int tempSum = currentSum + i;
            if (tempSum <= target) {
                result.add(i);
                printAllCombinationsRecursion(target, tempSum, i, output, result);
                result.remove(result.size() - 1);
            } else {
                return;
            }
        }
    }

    static ArrayList<ArrayList<Integer>> print_all_sum(int target) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        printAllCombinationsRecursion(target, 0, 1, output, result);
        return output;
    }
    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> result = print_all_sum(n);
        System.out.println (result);
    }

}
