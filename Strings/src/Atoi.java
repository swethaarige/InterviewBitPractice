/*
There are certain questions where the interviewer would intentionally frame the question vague.
The expectation is that you will ask the correct set of clarifications or state your assumptions
before you jump into coding.
Implement atoi to convert a string to an integer.
Example : Input : "9 2704"  Output : 9
Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.
Questions:
Q1. Does string contain whitespace characters before the number? A. Yes
Q2. Can the string have garbage characters after the number? A. Yes. Ignore it.
Q3. If no numeric character is found before encountering garbage characters, what should I do? A. Return 0.
Q4. What if the integer overflows?A. Return INT_MAX if the number is positive, INT_MIN otherwise.
Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.

 */

public class Atoi {
    public static void main(String[] args) {
        System.out.println("ATOI  "+atoi("927 04"));
        System.out.println("ATOI  "+atoi("9 27 04"));
    }
    public static int atoi(String A) {
        if (A == null || A.length() == 0) {
            return 0;
        }
        String B = A.trim();
        char flag = '+';
        int i = 0;
        if (B.charAt(0) == '-') {
            flag = '-';
            i++;
        }
        else if (B.charAt(0) == '+') {
            i++;
        }
        double result = 0;
        while (i < B.length() && B.charAt(i) >= '0' && B.charAt(i) <= '9') {
            result = result * 10 + (B.charAt(i) - '0');
            i++;
        }
        if (flag == '-') {
            result = - result;
        }
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }
        return (int) result;
    }

}
