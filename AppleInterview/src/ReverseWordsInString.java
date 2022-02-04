import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInString {
    public static void main (String args[]) {
        String str = "Algoexpert is the best!";
        String result = reverseWordsInString(str);
        System.out.println(" Result of the given problem is " + result);
    }
    public static String reverseWordsInString(String string) {
        int startOfWord = 0;
        List<String> words = new ArrayList<>();
        for (int idx = 0; idx < string.length(); idx++) {
            if (string.charAt(idx) == ' ') {
                words.add(string.substring(startOfWord, idx));
                startOfWord = idx;
            }
            else if (string.charAt(startOfWord) == ' ') {
                words.add(string.substring(startOfWord, idx));
                startOfWord = idx;
            }
        }
        words.add(string.substring(startOfWord));
        Collections.reverse(words);
        return String.join("", words);

    }

}
