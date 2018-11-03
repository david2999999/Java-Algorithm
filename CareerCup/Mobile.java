package CareerCup;

import java.util.HashMap;

public class Mobile {
    private HashMap<Character, String> map;

    public Mobile() {
        map = new HashMap<>();

        map.put('1', "");
        map.put('2', "ABC");
        map.put('3', "DEF");
        map.put('4', "GHI");
        map.put('5', "JKL");
        map.put('6', "MNO");
        map.put('7', "PQRS");
        map.put('8', "TUV");
        map.put('9', "WXYZ");
        map.put('0', "");
    }

    // since we need 2 numbers to determine a value
    // if prev = 2 and next = 2, then we B
    private Character getCharacterFromNumber(char prev, char next) {
        if (prev == '1' || prev == '0') return null;
        int nextNum = next - '0' - 1;

        if (nextNum >= map.get(prev).length() || nextNum < 1) return null;
        else {
            return this.map.get(prev).charAt(nextNum);
        }
    }

    public String convertNumberToString(String num) {
        StringBuilder sb = new StringBuilder();
        char[] chars = num.toCharArray();
        int index = 1;

        while (index < chars.length) {
            Character prevLetter = chars[index - 1];
            Character currentLetter = chars[index];

            if (prevLetter == '#') {
                index++;
                sb.append(" |");
            } else if (getCharacterFromNumber(prevLetter, currentLetter) == null) {
                index++;
            } else {
                sb.append(getCharacterFromNumber(prevLetter, currentLetter));
                index += 2;
            }
        }

        return sb.toString();
    }
}
