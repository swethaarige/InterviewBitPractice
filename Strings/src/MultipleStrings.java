/*
Given two numbers represented as strings, return multiplication of the numbers as a string.
Note: The numbers can be arbitrarily large and are non-negative.
Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer.
For example, given strings "12", "10", your answer should be “120”.
NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ).
 */
public class MultipleStrings {

    public static void main(String[] args) {
        System.out.println("Multiply two numbers as Strings   "+multiplyStrings("68","26"));
    }

    public static String multiplyStrings(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        int[] d = new int[num1.length()+ num2.length()];
        //multiply each digit and sum at corresponding positions

        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                d[i+j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.length; i++) {
            int mod = d[i] % 10;
            int carry = d[i] / 10;
            if (i + 1 < d.length) {
                d[i + 1] += carry;
            }
            sb.insert(0, mod);
        }
        if (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
