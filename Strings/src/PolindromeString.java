
/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Example:
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
/*
This is a fairly simple question.
You need to maintain 2 pointers, one from the beginning and one from the end.
At every iteration, after skipping the non alphanumeric characters, both the characters should match.
Have you considered empty strings?
Empty strings are palindromes. This is however, a nice question for clarification from the interviewer.
Note:
Are you correctly skipping the non alphanumeric characters?
Are you correctly handling whitespaces?
 */
public class PolindromeString {

    public static void main (String[] args) {
       String s = "A man, a plan, a canal: Panama";
       System.out.println(" Given String is  :" +isPolindrome(s));
    }

    public static int isPolindrome(String A) {
        if (A == null || A.length() == 0) return 0;
        A = A.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != A.charAt(A.length() - 1)) {
                return 0;
            }
        }
        return 1;
    }
}
