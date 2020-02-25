public class StackOfBoxesMemoization {
    public int createStack(ArrayList<Box> boxes) {
        if (boxes == null || boxes.size() == 0) {
            return 0;
        }

        Collections.sort(boxes, new BoxComparator());
        int[] stackMemo = new int[boxes.size()];
        int maxHeight = 0;

        for (int i = 0; i < boxes.size(); i++) {
            int height = getMaxHeight(boxes, i, stackMemo);
            maxHeight = Math.max(height, maxHeight);
        }

        return maxHeight;
    }

    private int getMaxHeight(ArrayList<Box> boxes, int bottomIndex, int[] stackMemo) {
        if (bottomIndex < boxes.size() && stackMemo[bottomIndex] > 0) {
            return stackMemo[bottomIndex];
        }

        Box bottomBox = boxes.get(bottomIndex);
        int maxHeight = 0;

        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            int height = getMaxHeight(boxes, i, stackMemo);
            maxHeight = Math.max(height, maxHeight);
        }

        maxHeight += bottomBox.height;
        stackMemo[bottomIndex] = maxHeight;
        return maxHeight;
    }

    public class BoxComparator implements Comparator<Box> {
        @Override
        public int compare(Box b1, Box b2) {
            return b2.height - b1.height;
        }
    }
}