class RevStringComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        String s1rev = sb1.reverse().toString();
        String s2rev = sb2.reverse().toString();
        return s1rev.compareTo(s2rev);
    }
}