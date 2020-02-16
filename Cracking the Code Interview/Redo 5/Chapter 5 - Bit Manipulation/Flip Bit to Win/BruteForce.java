public class BruteForce {
    public int longestSequence(int n) {
        if (n == -1) {
            return Integer.BYTE * 8;
        }

        ArrayList<Integer> sequences = getAlternatingSequences(n);
        return findLongestSequence(sequences);
    }

    private int findLongestSequence(ArrayList<Integer> sequences) {
        int maxSequence = 1;

        for (int i = 0; i < sequences.size(); i += 2) {
            int zeroSeqCount = i;
            int onesSequenceRight = i - 1 >= 0 ? sequences.get(i - 1) : 0;
            int onesSequenceLeft = i + 1 < sequences.size() ? sequences.get(i + 1) : 0;

            int thisSequence = 0;
            if (zeroSeqCount == 0) {
                thisSequence = Math.max(onesSequenceLeft, onesSequenceRight);
            } else if (zeroSeqCount == 1) {
                thisSequence = onesSequenceLeft + onesSequenceRight + 1;
            } else if (zeroSeqCount > 1) {
                thisSequence = Math.max(onesSequenceLeft, onesSequenceRight) + 1;
            }

            maxSequence = Math.max(thisSequence, maxSequence);
        }

        return maxSequence;
    }

    private ArrayList<Integer> getAlternatingSequences(int num) {
        ArrayList<Integer> sequences = new ArrayList<>();

        int searchingFor = 0;
        int counter = 0;

        for (int i = 0; i < Integer.BYTE * 8; i++) {
            int rightMostDigit = num & 1;

            if (rightMostDigit != searchingFor) {
                sequences.add(counter);
                counter = 0;
                searchingFor = rightMostDigit;
            }

            counter++;
            num >>>= 1;
        }

        sequences.add(counter);
        return sequences;
    }
}