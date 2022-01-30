import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Problem Description
Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time
using less than O(n) space and traversing the stream sequentially O(1) times.
Sample Input:[3 4 1 4 1] Sample Output: 1
If there are multiple possible answers ( like in the sample case above ), output any one.
f there is no duplicate, output -1
 */
public class FindDuplicateInArray {
    public static void main (String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(3); A.add(4); A.add(1); A.add(4); A.add(1);
        System.out.println("Duplicate Number is  " +duplicateNumber(A) );
    }
    public static int duplicateNumber(List<Integer> A) {
        Set<Integer> nums = new HashSet<Integer>();
        for (Integer num : A) {
            if (!nums.add(num)) {
                return num;
            }
        }
        return -1;
    }

}
