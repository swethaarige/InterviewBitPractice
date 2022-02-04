import java.util.HashSet;
import java.util.Set;

/*
Find all possible palindromic substrings of a string
The problem differs from the problem of finding the possible palindromic subsequence.
Unlike subsequences, substrings are required to occupy consecutive positions within the original string.
For example, Input:  str = google Output: e l g o oo goog
A simple solution would be to generate all substrings of the given string and print substrings
that are palindromes. The time complexity of this solution would be O(n3), where n is the length
of the input string.
We can solve this problem in O(n2) time and O(1) space. The idea is inspired by the Longest
Palindromic Substring problem. For each character in the given string, consider it as the midpoint
of a palindrome and expand in both directions to find all palindromes that have it as midpoint.
For an even length palindrome, consider every adjacent pair of characters as the midpoint.
We use a set to store all unique palindromic substrings.

For each letter in the input string, start expanding to the left and right while checking for
even and odd length palindromes. Move to the next letter if we know a palindrome doesn’t exist there.
We expand one character to the left and right and compare. If both are equal, we print out
the palindrome substring.
Runtime complexity: Polynomial, O(n^{2})
Memory complexity: Constant, O(1)
 */
public class FindAllPolindromicSubstrings {
    public static Set<String> findPalindromicSubstrings(String str) {
        Set<String> set = new HashSet<>();
        //Base case
        if (str == null) {
            return set;
        }
        for (int i = 0; i < str.length(); i++) {
            // find all odd length palindrome with `str[i]` as a midpoint
            expand(str, i, i, set);
            // find all even length palindrome with `str[i]` and `str[i+1]`
            // as its midpoints
            expand(str, i, i + 1, set);
        }
        // print all unique palindromic substrings
        System.out.print(set);
        return set;
    }
    // Expand in both directions of `low` and `high` to find all palindromes
    public static void expand(String string, int low, int high, Set<String> setOfStrings) {
        // run till `str[low.high]` is not a palindrome
        while (low >= 0 && high < string.length() &&
                string.charAt(low) == string.charAt(high)) {
            setOfStrings.add(string.substring(low, high + 1));
            //Expand In both directions
            low--;
            high++;
        }
    }
    public static void main(String[] args)
    {
        String str = "google";

        findPalindromicSubstrings(str);
    }
}
