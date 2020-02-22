public class Permutation {
    public ArrayList<String> getPerms(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, Integer> map = buildFrequencyTable(s);
        getPerms(map, "", s.length(), result);
        return result;
    }

    private void getPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
        if (remaining == 0) {
            result.add(prefix);
            return;
        }

        for (Character c: map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                getPerms(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }
        }
    }

    private HashMap<Character, Integer> buildFrequencyTable(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }

            map.put(c, map.get(c) + 1);
        }

        return map;
    }
}