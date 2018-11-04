package CareerCup;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Permutation {
    public static void main(String[] args) {
        Set<String> permutations = new TreeSet<>();
        permutation("", "abc", permutations);

        for (String s: permutations) {
            System.out.println(s);
        }
    }

    private static void permutation(String prefix, String str, Set<String> permutations) {
        int n = str.length();
        if (n == 0) permutations.add(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), permutations);
        }
    }
}
