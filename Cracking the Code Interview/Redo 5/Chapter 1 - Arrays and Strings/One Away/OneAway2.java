public class OneAway2 {
    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) return false;

        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;

        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) != second.charAt(index2)) {
                if (foundDifference) return false;
                foundDifference = true;

                if (first.length() == second.length()) {
                    index1++;
                }
            } else {
                index1++;
            }

            index2++;
        }

        return true;
    }
}