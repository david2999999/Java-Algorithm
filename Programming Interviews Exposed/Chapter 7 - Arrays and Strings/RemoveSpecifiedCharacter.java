public class RemoveSpecifiedCharacter {
    public void removeChars(StringBuilder str, String remove) {
        boolean[] flags = new boolean[128];
        int search, destination = 0;

        for (char c: remove.toCharArray()) {
            flags[c] = true;
        }

        for (search = 0; search < str.length(); search++) {
            char c = str.charAt(search);
            if (!flags[c]) {
                str.setCharAt(destination++, c);
            }
        }

        str.setLength(destination);
    }
}
