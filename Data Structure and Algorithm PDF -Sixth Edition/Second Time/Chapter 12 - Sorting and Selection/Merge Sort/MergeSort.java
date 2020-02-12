public class MergeSort {
    public <K> void sort(K[] s, Comparator<K> comp) {
        int length = s.length;
        if (length < 2) return;

        int mid = length / 2;
        K[] s1 = Arrays.copyOfRange(s, 0, mid);
        K[] s2 = Arrays.copyOfRange(s, mid, length);

        sort(s1, comp);
        sort(s2, comp);
        merge(s1, s2, s, comp);
    }

    public <K> void merge(K[] s1, K[] s2, K[] s, Comparator<K> comp) {
        int i = 0, j = 0;

        while (i + j < s.length) {
            if (j == s2.length || (i < s1.length && comp.compare(s1[i], s2[i]) < 0)) {
                s[i + j] = s1[i++];
            } else {
                s[i + j] = s2[i++];
            }
        }
    }
}