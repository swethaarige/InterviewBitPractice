import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Given a list of non negative integers, arrange them such that they form the largest number.
For example: Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
Note: The result may be very large, so you need to return a string instead of an integer.
1.Sorting all numbers in descending order is the simplest solution that occurs to us. But this doesn’t work.
For example, 548 is greater than 60, but in the output, 60 comes before 548. As a second example,
98 is greater than 9, but 9 comes before 98 in the output.
2. The solution is to use any comparison based sorting algorithm. Thus, instead of using the
default comparison, write a comparison function myCompare() and use it to sort numbers.
3.Given two numbers X and Y, how should myCompare() decide which number to put first –
we compare two numbers XY (Y appended at the end of X) and YX (X appended at the end of Y).
If XY is larger, then, in the output, X should come before Y, else Y should come before X.
For example, let X and Y be 542 and 60. To compare X and Y, we compare 54260 and 60542.
Since 60542 is greater than 54260, we put Y first.
 */
public class LargestNumber {
    public static void main(String[] args) {
        List<Integer> largestNumberList=new ArrayList<>(5);
        largestNumberList.add(3);largestNumberList.add(30);largestNumberList.add(34);largestNumberList.add(5);largestNumberList.add(9);
        String largestNum= largestNumber(largestNumberList);
        System.out.println("Largest Number"+largestNum);

    }
    //O(nlogn) Time and O(n) space
    public static String largestNumber(final List<Integer> A) {
        String[] arr = new String[A.size()];
        for (int i = 0; i < A.size(); i++) {
            arr[i] = String.valueOf(A.get(i));
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
       if (sb.charAt(0) == '0') { //Checking if all the Zeroes are there
            return String.valueOf(0);
        }
        return sb.toString();

    }
}
