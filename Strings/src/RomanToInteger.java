/*
Given a string A representing a roman numeral.
Convert A into integer.
A is guaranteed to be within the range from 1 to 3999.
NOTE: Read more details about roman numerals at Roman Numeric System
Input Format The only argument given is string A.
Output Format Return an integer which is the integer verison of roman numeral string.
For Example Input 1: A = "XIV" Output 1: 14
Input 2: A = "XX" Output 2: 20
 */
public class RomanToInteger {

    public static void main(String[] args){
        System.out.println("Roman To Integer  "+romanToInt("XIV"));
    }

    public static int romanToInt(String str) {
        int l = str.length();
        if (l == 0) return 0;
        int sum = 0;
        for (int i = 0; i < l - 1; i++) {
            char c = str.charAt(i);
            char cn = str.charAt(i + 1);
            int valc = valueOf(c);
            int valcn = valueOf(cn);
            if (valc == 0) continue;
            if (valc == 0 || valc >= valcn) {
                sum += valc;
            } else {
                sum -= valc;
            }
        }
        sum += valueOf(str.charAt(l - 1));
        return sum;
    }

    public static int valueOf(char c) {
        if (c == 'I') return 1;
        else if (c == 'V') return 5;
        else if (c == 'X') return 10;
        else if (c == 'L') return 50;
        else if (c == 'C') return 100;
        else if (c == 'D') return 500;
        else if (c == 'M') return 1000;
        return 0;
    }
}
