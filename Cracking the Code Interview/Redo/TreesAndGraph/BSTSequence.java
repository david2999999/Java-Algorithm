package Redo.TreesAndGraph;

import CodeLibrary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequence {
    private ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);

        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        for (LinkedList<Integer> left: leftSeq) {
            for (LinkedList<Integer> right: rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveList(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }

        return result;
    }

    private void weaveList(LinkedList<Integer> first, LinkedList<Integer> second,
                           ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveList(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveList(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
