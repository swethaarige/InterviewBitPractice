/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11. 11 is read off as two 1s or 21.
21 is read off as one 2, then one 1 or 1211.
Given an integer n, generate the nth sequence.
Note: The sequence of integers will be represented as a string.
Example: if n = 2, the sequence is 11.
 */
public class CountAndSay {

    public static void main (String[] args) {
        System.out.println("Count And Say " +countAndSay(3));
        System.out.println("Count And Say " +countAndSay(4));
        System.out.println("Count And Say " +countAndSay(5));
        System.out.println("Count And Say " +countAndSay(5));
        System.out.println("Count And Say " +countAndSay(6));
        System.out.println("Count And Say " +countAndSay(7));
        System.out.println("Count And Say " +countAndSay(8));
        System.out.println("Count And Say " +countAndSay(9));
    }

    public static String countAndSay(int n) {

        if (n == 1) return "1";
        if (n == 2) return "11";
        String str = "11";
        for (int i = 3; i <= n; i++) {
            str += "$";
            int len = str.length();
            String temp = "";
            int count = 1;
            char[] arr = str.toCharArray();

            for (int j = 1; j < len; j++) {
                if (arr[j] != arr[j - 1]) {
                    temp += count + 0;
                    temp += arr[j - 1];
                    count = 1;
                } else {
                    count++;
                }
            }
            str = temp;
        }
        return str;
    }
}
