package VBox;

import java.util.HashMap;
import java.util.Map;

public class VegenereDecodeWith1Key {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = generateAlphabetMap();
        String encrypted = "QZZJAHLCUQGMSAOIBXZFCWWF";
        char[] charArray = encrypted.toCharArray();
        char[] firstKey = {'B','L', 'U', 'E'};
        int[] fourLetterWords = new int[4];

        for (int i = 4; i < charArray.length - 3; i++) {
            System.out.println(charArray[i]);
            for (int j = 0; j < firstKey.length; j++) {
                fourLetterWords[j] = map.get(charArray[j + i]) - map.get(firstKey[j]);

                if (fourLetterWords[j] <= 0) {
                    fourLetterWords[j] += 26;
                }
                System.out.print(fourLetterWords[j] + " ");

            }
            System.out.println();
            System.out.println(retrieveStringWithNumbers(fourLetterWords));
        }
    }

    private static HashMap<Character, Integer> generateAlphabetMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        int value = 1;

        for (char c = 'A'; c <= 'Z'; c++ ) {
            map.put(c, value++);
        }
        return map;
    }

    private static Character getCharacterFromIndex(Integer index, HashMap<Character, Integer> map) {
        for (Map.Entry entry: map.entrySet()) {
            if (index == entry.getValue()) {
                Character letter = (Character) entry.getKey();
                return letter;
            }
        }

        return null;
    }

    private static String retrieveStringWithNumbers(int[] numArray) {

        StringBuilder sb = new StringBuilder();
        for (int num: numArray) {
            sb.append(getCharacterFromIndex(num, generateAlphabetMap()));
        }

        return sb.toString();
    }
}
