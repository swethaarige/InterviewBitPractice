/*
Given an index k, return the kth row of the Pascal's triangle.
Pascal's triangle: To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.
Example: Input : k = 3 Return : [1,3,3,1] Note: k is 0 based. k = 0, corresponds to the row [1].
Note: Could you optimize your algorithm to use only O(k) extra space?
Solution Approach:
Did you account for base cases like numRows = 0, numRows = 1 ?
Take a look at how we can approach this problem.
Notice that the first and last numbers in each row ( for row >= 2 ) are 1 and 1.
For all the other numbers:
num at position i = number at position i in prev row + number at position (i + 1) in previous row.
 */

import java.util.ArrayList;

public class KthRowOfPascalTriangle {
    public static void main (String[] args) {
        ArrayList<Integer> result = new ArrayList<>();
        result = getRow2ndApproach(2);
        for (Integer num : result) {
            System.out.println("Pascal Traingle Row 2 is " + num);
        }
        ArrayList<Integer> result2 = new ArrayList<>();
        result2 = getRow2ndApproach(3);
        for (Integer num : result2) {
            System.out.println("Pascal Traingle Row 3 is " + num);
        }
        ArrayList<Integer> result3 = new ArrayList<>();
        result3 = getRow2ndApproach(4);
        for (Integer num : result3) {
            System.out.println("Pascal Traingle Row 4 is " + num);
        }

    }
    public static ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i <= A; i++) {
            int num = ( A + 1 - i) * result.get(i - 1)/i ;
            result.add(num);
        }
        return result;
    }

    public static ArrayList<Integer> getRow2ndApproach(int a) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= a; i++) {
            final ArrayList<Integer> tempAns = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if(j==0||j==i)
                    tempAns.add(1);
                else
                    tempAns.add(ans.get(j-1) + ans.get(j));
            }
            ans = tempAns;
        }
        return ans;
    }
}
