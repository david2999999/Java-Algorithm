int[] tally(String s) {
    int[] frequency = new int[26];
    for (int i = 0; i < s.length(); i++) {
        char ch = Character.toUpperCase(s.charAt(i));
        
    if (Character.isLetter(ch)) {
        ++frequency[(int)ch - (int)'A']; // count ch
    }
    return frequency;
}