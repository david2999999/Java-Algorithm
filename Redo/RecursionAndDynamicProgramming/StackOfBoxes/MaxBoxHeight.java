package Redo.RecursionAndDynamicProgramming.StackOfBoxes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MaxBoxHeight {

    private int createMaxHeight(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;

        for (int i = 0; i < boxes.size(); i++) {
            int height = getMaxHeight(boxes, i);
            maxHeight = Math.max(height, maxHeight);
        }

        return maxHeight;
    }

    private int getMaxHeight(ArrayList<Box> boxes, int bottomIndex) {
        Box bottomBox = boxes.get(bottomIndex);

        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottomBox)) {
                int height = getMaxHeight(boxes, i);
                maxHeight = Math.max(height, maxHeight);
            }
        }

        maxHeight += bottomBox.height;
        return maxHeight;
    }

    private class BoxComparator implements Comparator<Box> {

        @Override
        public int compare(Box o1, Box o2) {
            return o2.height - o1.height;
        }
    }
}
