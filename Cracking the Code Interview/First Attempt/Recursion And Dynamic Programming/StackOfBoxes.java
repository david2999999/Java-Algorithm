package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StackOfBoxes {
    private int createStack(ArrayList<Box> boxes){
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxHeight;
    }

    private int createStack(ArrayList<Box> boxes, int bottomIndex) {
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;

        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = createStack(boxes, i);
                maxHeight = Math.max(height, maxHeight);
            }
        }

        maxHeight += bottom.height;
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
