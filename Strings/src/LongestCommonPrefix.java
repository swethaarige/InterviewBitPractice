import java.util.ArrayList;

/*
Given the array of strings A, you need to find the longest string S which is the prefix of ALL
the strings in the array.Longest common prefix for a pair of strings S1 and S2 is the longest
string S which is the prefix of both S1 and S2.
For Example: longest common prefix of "abcdefgh" and "abcefgh" is "abc".
Input Format
The only argument given is an array of strings A.
Output Format
Return the longest common prefix of all strings in A.
Example Input
Input 1: A = ["abcdefgh", "aefghijk", "abcefgh"] Example Output Output 1:"a"
Longest common prefix of all the strings is "a".
Input 2:A = ["abab", "ab", "abcd"];Example Output Output 1:"ab"
Longest common prefix of all the strings is "ab".
 */
public class LongestCommonPrefix {

    public static void main (String[] args) {

        ArrayList<String> listOfStrings = new ArrayList<>(3);
        listOfStrings.add("abcdefgh");
        listOfStrings.add("aefghijk");
        listOfStrings.add("abcefgh");
        String commonPrefix = commonPrefix(listOfStrings);
        System.out.println("Common prefix " +commonPrefix);

    }

    public static String commonPrefix(ArrayList<String> A) {

        StringBuilder sb = new StringBuilder();
        if (A == null || A.size() == 0) return null;
        int minLen = Integer.MAX_VALUE;
        for (String S : A) {
            if (S.length() < minLen) {
                minLen = S.length();
            }
        }
        for (int j = 0; j < minLen; j++) {
            int count = 0;
            char c = A.get(0).charAt(j);
            for (int i = 0; i < A.size(); i++) {
                if (A.get(i).charAt(j) != c) {
                    break;
                }
                count++;
            }
            if (count != A.size()) return sb.toString();
            sb.append(c);
        }
        return sb.toString();
    }
}
