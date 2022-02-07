package AppleInterview;

public class ValidPalindromewithRemoval {
    public static void main(String[] args) {

        String str = "abecbea";
        String str2 = "abcba";
        String str3 = "foobof";
        System.out.println(" 1st One result " + possiblePolindromeByRemovingOneChar(str));
        System.out.println(" 1st One result " + possiblePolindromeByRemovingOneChar(str2));
        System.out.println(" 1st One result " + possiblePolindromeByRemovingOneChar(str3));
        System.out.println(" 1st One result " + possiblePolindromeByRemovingOneChar("abccab"));
        //int idx = possiblePolindromeByRemovingOneChar(str3);

       /* if (idx == -1)
            System.out.println("Not Possible");
        else if (idx == -2)
            System.out.println("Possible without " +
                    "removing any character");
        else
            System.out.println("Possible by removing" +
                    " character at index " + idx);
*/
    }
    //Utility method to check if string from low to high is Polindrome or not
    public static boolean isPolindrome(String inputStr, int low, int high) {
        while (low < high) {
            if (inputStr.charAt(low) != inputStr.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }
    // This method returns -1 if it is not possible to make string a palindrome.
    // It returns -2 if string is already a palindrome.
    // Otherwise it returns index of character whose removal can Make the whole string palindrome.
    public static boolean possiblePolindromeByRemovingOneChar(String str) {
        int low = 0;
        int high = str.length() - 1;

         // loop until low and
        // high cross each other
        while (low < high) {
            // If both characters are equal then
            // move both pointer towards end
            if (str.charAt(low) == str.charAt(high)) {
                low++;
                high--;
            } else {
                /*
                 * If removing str[low] makes the
                 * whole string palindrome. We basically
                 * check if substring str[low+1..high]
                 * is palindrome or not.
                 */
                if (isPolindrome(str, low + 1, high)) {
                    return true;
                }
                /*
                 * If removing str[high] makes the whole string
                 * palindrome. We basically check if substring
                 * str[low+1..high] is palindrome or not.
                 */
                if (isPolindrome(str, low, high - 1)) {
                    return true;
                }
                return false;
            }

        }
        // We reach here when complete string
        // will be palindrome if complete string
        // is palindrome then return mid character
        return true;
    }
}
