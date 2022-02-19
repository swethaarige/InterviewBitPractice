/*
Problem Description
Given a string A and integer B, remove all consecutive same characters that have length exactly B.
Problem Constraints
1 <= |A| <= 100000
1 <= B <= |A|
Input Format
First Argument is string A.
Second argument is integer B.
Output Format
Return a string after doing the removals.
Example Input
Input 1:
A = "aabcd"
B = 2
Input 2:
A = "aabbccd"
B = 2
Example Output
Output 1:
"bcd"
Output 2:
"d"
Solution Approach
You need to maintain a counter of the count of the present character.
If it is exactly B and a new charcter comes next, you need to remove this block
of B characters. This can be done just by maintaing a seperate answer string and
appending to it when the length is not B.

 */
public class RemoveConsecutiveCharacters {
    public static void main (String[] args) {
        String s1 = "aabcd";
        String s2 = "aabbccd";
        System.out.println("Result of the question is  :" +removeConsecutiveCharacters(s1, 2));
        System.out.println("Result of the question is  :" +removeConsecutiveCharacters(s2, 2));
    }
    public static String removeConsecutiveCharacters(String A, int B) {
        String ans = "";
        for (int i = 0; i < A.length(); i++) {
            int j = i + 1;
            while (j < A.length() && A.charAt(i) == A.charAt(j)) {
                j++;
            }
            if (j - i != B) {
                ans += A.substring(i, j);
            }
            i = j - 1;
        }
        return ans;
    }
}
