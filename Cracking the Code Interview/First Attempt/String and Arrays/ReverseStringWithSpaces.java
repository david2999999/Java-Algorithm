package Interview;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseStringWithSpaces {
    public static void main(String[] args) {
        System.out.println(reverseString("Hello  here   i  am hello"));
    }


    private static String reverseString(String str) {
        if (str.length() == 0) return "";

        Stack<String> words = new Stack<>();
        ArrayList<Integer> spaces = new ArrayList<>();

        generateSpaceAndWordMap(str, spaces, words);

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (!words.isEmpty()) {
            sb.append(words.pop());

            int s = spaces.get(index) != null ? spaces.get(index): 0;
            if (index < spaces.size() - 1) {
                index++;
            }
            for (int i = 0; i < s; i++) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    private static void generateSpaceAndWordMap(String str, ArrayList<Integer> spaces, Stack<String> words) {

        StringBuilder sb = new StringBuilder();
        int spaceCount = 0;

        for (char c: str.toCharArray()) {
            if (c == ' ') {
                spaceCount++;

                if (sb.length() != 0) { // check if there is a word or letter
                    words.push(sb.toString());  // add the string into the stack
                    sb.setLength(0); // clear the string builder
                }
            } else {
                sb.append(c);   // if it is a character

                if (spaceCount != 0) {
                    spaces.add(spaceCount); // add it to arraylist
                    spaceCount = 0; // reset space count
                }
            }
        }


        if (sb.length() > 0) {  // add remaining word
            words.push(sb.toString());
        }
    }
}
