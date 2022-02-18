/*
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
Input Format:The first and the only argument contains an integer, A.
Output Format:Return a 2-d matrix of size A x A satisfying the spiral order.
Constraints:1 <= A <= 1000
Examples:Input 1:
    A = 3
Output 1:
    [   [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]   ]
Input 2:
    4
Output 2:
    [   [1, 2, 3, 4],
        [12, 13, 14, 5],
        [11, 16, 15, 6],
        [10, 9, 8, 7]   ]
Solution Approach:
This is more of a simulation problem.
You need to maintain state indicating which direction you are traversing to
( left to right, right to left, top to down, down to top ) and then know when to change the directions.
Note that in each direction, either row or column remains constant.
Based on the constant row or column, you can predict when to change the direction.
 */

import java.util.ArrayList;

public class SpiralMatrix {
    public static void main (String[] args) {
        ArrayList<ArrayList<Integer>> generatedmatrix = generateMatrix(3);
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.println("Spiral matrix " +generatedmatrix.get(i).get(j));
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int[][] res = new int[A][A];
        int left=0,right=A-1,top=0,bottom=A-1,num=1;
        //outer condition
        while(left<=right && top<=bottom){
            //for top row
            for(int i=left;i<=right;i++)
                res[top][i] = num++;
            top++;
            //for right column
            for(int i=top;i<=bottom;i++)
                res[i][right] = num++;
            right--;
            // for bottom row
            for(int i=right;i>=left;i--)
                res[bottom][i] = num++;
            bottom--;
            // for left column
            for(int i=bottom;i>=top;i--)
                res[i][left] = num++;
            left++;
        }
        // insert data from 2-d array to arraylist
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<A;i++){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int j=0;j<A;j++){
                tmp.add(res[i][j]);
            }
            ans.add(tmp);
        }
        return ans;
    }
}
