import java.util.ArrayList;
import java.util.List;

/*
You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.
Note: Your algorithm should have a linear runtime complexity. Could you implement it without
using extra memory?Note that in your output A should precede B.
Example:Input:[3 1 2 5 3] Output:[3, 4]
A = 3, B = 4

Solution Approach
    Sum(Actual) = Sum(1...N) + A - B

    Sum(Actual) - Sum(1...N) = A - B.

    Sum(Actual Squares) = Sum(1^2 ... N^2) + A^2 - B^2

    Sum(Actual Squares) - Sum(1^2 ... N^2) = (A - B)(A + B)

    = (Sum(Actual) - Sum(1...N)) ( A + B).
We can use the above 2 equations to get the value of A and B.

 */
public class RepeatAndMissingNumberArray {
    public static void main (String[] args) {
        List<Integer> A = new ArrayList<>(5);
        A.add(3); A.add(1);A.add(2);A.add(5);A.add(3);
        ArrayList<Integer> result = repeatedAndMissingNumbers(A);
        System.out.println("Repating and Missing Integers  " +result.get(0) + " " +  result.get(1));
    }
    public static ArrayList<Integer> repeatedAndMissingNumbers(List<Integer> A) {
        int size = A.size();
        long sumOfSquares = getSumOfSquares(size);
        long sumOfNumbers = getSumOfNumbers(size);
        long differenceOfSquares = getDifferenceOfSquares(A, sumOfSquares);
        long differenceOfNumbers = getDifferenceOfNumbers(A, sumOfNumbers);
        int sumNumber = (int) (differenceOfSquares / differenceOfNumbers);
        int repeatingNumber = (int) ((sumNumber + differenceOfNumbers) / 2);
        int duplicateNumber = sumNumber - repeatingNumber;
        ArrayList<Integer> result = new ArrayList<>(2);
        result.add(repeatingNumber); result.add(duplicateNumber);
        return result;
    }

    public static long getSumOfSquares(int n) {
        return (n * (n + 1) * ( 2*n + 1)) /6;
    }

    public static long getSumOfNumbers(int n) {
        return (n * (n + 1)) / 2;
    }
    public static long getDifferenceOfNumbers(List<Integer> A, long n ) {
        int sum = (int) (n * -1);
        for (Integer num : A) {
            sum += num;
        }
        return sum;
    }
    public static long getDifferenceOfSquares(List<Integer> A, long n) {
        int sum = (int) (n * -1);
        for (Integer num : A) {
            sum += num * num;
        }
        return sum;
    }
}
