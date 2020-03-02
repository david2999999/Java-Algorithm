public class GroupAnagram {
    public void sort(String[] array) {
        HashMapList<String, String> mapList = createAnagramMap(array);

        int index = 0;
        for (String key: mapList.keySet()) {
            ArrayList<String> anagrams = mapList.get(key);
            for (String anagram: anagrams) {
                array[index++] = anagram;
            }
        }
    }

    private HashMapList<String, String> createAnagramMap(String[] array) {
        HashMapList<String, String> mapList = new HashMapList<>();

        for (String s: array) {
            String key = sort(s);
            mapList.put(key, s);
        }

        return mapList;
    }

    private String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}