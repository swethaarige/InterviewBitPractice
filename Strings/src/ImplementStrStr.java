/*
Implement strStr().
strstr - locate a substring ( needle ) in a string ( haystack ).
Try not to use standard library string functions for this question.
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
NOTE: String A is haystack, B is needle.
Good clarification questions:
What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases.
 */
public class ImplementStrStr {
    public static void main (String[] args) {
      System.out.println(" Str Str is  :" +implementStrStr("haystack", "needle"));
    }
    public static int implementStrStr(String A, String B) {
        if (A.length() == 0 || B.length() == 0) {
            return -1;
        }
        if (A.length() < B.length()) {
            return -1;
        }
        int n = A.length();
        int m = B.length();

        for (int i = 0; i <= n - m; i++) {
            String s = A.substring(i, i + m);

            if (s.equals(B)) {
                return i;
            }
        }
        return -1;
    }

}
