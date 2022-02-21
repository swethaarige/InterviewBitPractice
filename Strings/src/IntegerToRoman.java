/*
Another question which belongs to the category of questions which are intentionally stated vaguely.
Expectation is that you will ask for correct clarification or you will state your assumptions
before you start coding.
Given an integer A, convert it to a roman numeral, and return a string corresponding to its roman
numeral version
Note : This question has a lot of scope of clarification from the interviewer. Please take a moment
to think of all the needed clarifications and see the expected response using “See Expected Output”
For the purpose of this question, https://projecteuler.net/about=roman_numerals has very detailed
explanations.
Input Format :The only argument given is integer A.
Output Format :Return a string denoting roman numeral version of A.
Constraints
1 <= A <= 3999
For Example Input 1: A = 5  Output 1: "V"
Input 2: A = 1 Output 2: "XIV"
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println("Integer To Roman " +intToRoman(419));
        System.out.println("Integer To Roman " +intToRoman(246));
        System.out.println("Integer To Roman " +intToRoman(1066));
    }

    public static String intToRoman(int A) {
        String o[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String t[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String c[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String m[] = {"", "M", "MM", "MMM"};
        return m[A/1000]+c[A%1000/100]+t[A%100/10]+o[A%10];

    }
}
