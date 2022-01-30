import java.util.ArrayList;

/*
Given numRows, generate the first numRows of Pascal's triangle.
Pascal's triangle : To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.
Example:Given numRows = 5,
Return
[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
Constraints:
0 <= numRows <= 25
Solution Approach :
num at position i = number at position i in prev row + number at position (i + 1) in previous row.
Now, note that to calculate num at position i, we need the numbers in previous row. Which means it
makes sense to create rows in order.
Create a 2D matrix where Matrix[r] denotes row r.Now process the rows starting from row number 1.
Row number 1 is obviously just 1.
For Row i, Row[i][0] = Row[i][i] = 1. And Row[i][j] = Row[i-1][j] + Row[i-1][j-1], when j belongs to [1, i)
 */
public class PascalTriangle {

    public static void main (String[] args){
        ArrayList<ArrayList<Integer>> pascalTriangle = generatePascalTraingle(5);
        for (int i = 0;i < 5; i++){
            System.out.println("Pascal Trainagle "+pascalTriangle.get(i));
        }
    }

    public static ArrayList<ArrayList<Integer>> generatePascalTraingle(int A){
       ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(A==0)
            return result;
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for (int i = 1; i <= A; i++) {
            result.add(new ArrayList<>());
            result.get(i).add(1);
            for (int j = 0; j < i - 1; j++) {
                int num = result.get(i - 1).get(j) + result.get(i - 1).get(j + 1);
                result.get(i).add(num);
            }
            result.get(i).add(1);
        }
        return result;
    }

}
