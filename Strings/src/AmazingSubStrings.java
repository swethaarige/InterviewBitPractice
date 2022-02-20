/*
You are given a string S, and you have to find all the amazing substrings of S.
Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
Input Only argument given is string S.
Output Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.
Constraints
1 <= length(S) <= 1e6
S can have special characters
Example Input ABEC Output 6
Explanation
Amazing substrings of given string are : 1. A 2. AB 3. ABE 4. ABEC 5. E 6. EC
here number of substrings are 6 and 6 % 10003 = 6.

Solution: The main idea to solve this problem is to traverse the string and when you encounter a vowel,
add ( length(string) - position_of_curr_char ) to the answer
 */
public class AmazingSubStrings {

    public static void main (String[] args) {
       System.out.println("Amazing Strings Count is : " +amazingStringsCount("ABEC"));
    }

    public static int amazingStringsCount(String A) {
        int result = 0;
        for (int i = 0; i < A.length(); i++) {
            if (isVowel(A.charAt(i))) {
                result += A.length() - i;
            }
        }
        return result % 10003;
    }

    public static boolean isVowel(char c) {
        char[] vowels = new char[] {'a', 'e', 'i','o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] == c) {
                return true;
            }
        }
        return false;
    }
}
