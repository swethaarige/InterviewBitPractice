import java.util.ArrayList;
/*
Problem Description : Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
Example:Input:
1 2 3
4 5 6
7 8 9
Return the following:
[
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]
Solution Approach:
Lets look at how the co-ordinates change when you move from one element to the other in the anti-diagonal.
With every movement, row increases by one, and the column decreases by one ( or in other words (1, -1)
gets added to the current co-ordinates ).
Now, all we need to know is the start ( or the first element ) in each diagonal.
Can you figure out which elements qualify as the first elements in each diagonal ?
 */
public class AntiDiagonals {
    public static void main (String[] args) {
        ArrayList<ArrayList<Integer>> A=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> element1=new ArrayList<>();
        element1.add(1);element1.add(2);element1.add(3);
        A.add(element1);
        ArrayList<Integer> element2=new ArrayList<>();
        element2.add(4);element2.add(5);element2.add(6);
        A.add(element2);
        ArrayList<Integer> element3=new ArrayList<>();
        element3.add(7);element3.add(8);element3.add(9);
        A.add(element3);
        ArrayList<ArrayList<Integer>> antiDioganalsresult= getAntiDiagonals(A);
        for (int i=0;i<antiDioganalsresult.size();i++){
            System.out.println("AntiDiagonals"+antiDioganalsresult.get(i));
        }
    }
    public static ArrayList<ArrayList<Integer>> getAntiDiagonals(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int dimension = A.size();
        for (int i = 0; i < 2 * dimension - 1; i++) {
            result.add(getDiagonal(i, A));
        }
        return result;
    }
    public static ArrayList<Integer> getDiagonal(int layer, ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= layer; i++) {
            int j = layer - i;
            if (i < A.size() && j < A.size()) {
                result.add(A.get(i).get(j));
            }
        }
        return result;
    }
}
