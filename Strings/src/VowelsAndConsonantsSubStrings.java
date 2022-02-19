/*
Problem Description
Given a string A consisting of lowercase characters.
You have to find the number of substrings in A which starts with vowel and end with consonants or vice-versa.
Return the count of substring modulo 10 ^9 + 7.(1000000007)

Problem Constraints
1 <= |A| <= 105
A consists only of lower-case characters.
Input Format
First argument is an string A.
Output Format
Return a integer denoting the the number of substrings in A which starts with vowel and end with consonants or vice-versa with modulo 109 + 7.

An efficient solution is to count vowels and consonants in every suffix of string.
After counting these, we traverse string from beginning.
For every consonant, we add number of vowels after it to result. Similarly,
for every vowel, we add number of consonants after it.
Time Complexity:O(|A|)
Space Complexity:O(|A|)


Method-2
Just loop from 1 to	A	and maintain two variables named “vow” and “con” denoting the number of vow
and con seen so far.
If the current character is vowel then do:
vow += 1
numberofSubstring += con //denoting the number of substring start with consonants
and ending with this vowel.
Do similarly for consonants
Time Complexity:O(|A|)
Space Complexity:O(1)
 */
public class VowelsAndConsonantsSubStrings {

    public static void main (String[] args) {
       String s1 = "aba";
       String s2 = "a";
       System.out.println("Vowels and Consonants Substrings are :" +vowelsAndConsonantsSubStrings(s1));
       System.out.println("Vowels and Consonants Substrings are :" +vowelsAndConsonantsSubStrings(s2));
    }

    public static int vowelsAndConsonantsSubStrings(String A) {
        int n = A.length();
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < A.length(); i++) {
            if (isVowel(A.charAt(i))) {
                vowels++;
            } else {
                consonants++;
            }
        }
        return vowels * consonants % 1000000007;
    }
    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
