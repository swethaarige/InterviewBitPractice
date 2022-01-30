/*
Problem Description
You're given a read only array of n integers. Find out if any integer occurs
more than n/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.
If there are multiple solutions, return any one.
Example:
Input: [1 2 3 1 1]
Output: 1
1 occurs 3 times which is more than 5/3 times.
Solution Approach:
O(n) Time and O(1) Space
 */

import java.util.*;

public class NBy3RepeatingNumber {
    public static void main (String[] args) {
       List<Integer> list = new ArrayList<>();
       list.add(1); list.add(1); list.add(1); list.add(2); list.add(3);list.add(5);list.add(7);
       int repeatedNumber = repeatedNumber(list);
       System.out.println("Repeated Number is :" +repeatedNumber);

    }
    public static int repeatedNumber( List<Integer> a) {
        Map<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            if (values.containsKey(a.get(i))) {
                values.put(a.get(i), values.get(a.get(i)) + 1);
            } else {
                values.put(a.get(i), 1);
            }
        }
        int count = a.size() / 3;
        System.out.println("Count is " + count);
        int result  = -1;
        for (Integer key : values.keySet()) {
            System.out.println("Value key count is " +key  + "is" + values.get(key));
            if (values.get(key) > count) {
                result = key;
            }
        }
        return result;
    }

}
