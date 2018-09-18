package Redo.RecursionAndDynamicProgramming.StackOfBoxes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MaxBoxHeightWithMemo {

    public int getMaxHeight(ArrayList<Box> boxes) {
        int[] memo = new int[boxes.size()];

        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;

        for (int i = 0; i < boxes.size(); i++) {
            int height = getMaxHeight(boxes, i, memo);
            maxHeight = Math.max(height, maxHeight);
        }

        return maxHeight;
    }

    private int getMaxHeight(ArrayList<Box> boxes, int bottomIndex, int[] memo) {
        if (bottomIndex < boxes.size() && memo[bottomIndex] > 0) return memo[bottomIndex];

        Box bottomBox = boxes.get(bottomIndex);
        int maxHeight = 0;

        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottomBox)) {
                int height = getMaxHeight(boxes, i, memo);
                maxHeight = Math.max(height, maxHeight);
            }
        }

        maxHeight += bottomBox.height;
        memo[bottomIndex] = maxHeight;
        return memo[bottomIndex];
    }


    private class BoxComparator implements Comparator<Box> {

        @Override
        public int compare(Box o1, Box o2) {
            return o2.height - o1.height;
        }
    }
}
