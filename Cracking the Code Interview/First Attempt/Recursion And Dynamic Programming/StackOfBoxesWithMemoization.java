package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StackOfBoxesWithMemoization {
    private int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int[] stackMap = new int[boxes.size() + 1];

        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i, stackMap);
            maxHeight = Math.max(height, maxHeight);
        }

        return maxHeight;
    }

    private int createStack(ArrayList<Box> boxes, int bottomIndex, int[] stackMap) {
        if (bottomIndex < boxes.size() && stackMap[bottomIndex] > 0) return stackMap[bottomIndex];

        Box bottomBox = boxes.get(bottomIndex);
        int maxHeight = 0;

        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottomBox)) {
                int height = createStack(boxes, i, stackMap);
                maxHeight = Math.max(height, maxHeight);
            }
        }

        maxHeight += bottomBox.height;
        stackMap[bottomIndex] = maxHeight;

        return maxHeight;
    }

    private class Box {
        private int height;

        public boolean canBeAbove(Box bottom) {
            return true;
        }
    }

    class BoxComparator implements Comparator<Box> {

        @Override
        public int compare(Box o1, Box o2) {
            return o2.height - o1.height;
        }
    }
}
