public class StackOfBoxesRecursion {
    public int createStack(ArrayList<Box> boxes) {
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
            if (boxes.get(i).canBeOnTop(bottomBox)) {
                int height = getMaxHeight(boxes, i);
                maxHeight = Math.max(height, maxHeight);
            }
        }

        maxHeight += bottomBox.height;
        return maxHeight;
    }

    public class BoxComparator implements Comparator<Box> {
        @Override
        public int compare(Box b1, Box b2) {
            return b2.height - b1.height;
        }
    }
}