public class StackOfBoxes {
    public int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int[] stackMemo = new int[boxes.size()];
        return createStack(boxes, null, 0, stackMemo);
    }

    private createStack(ArrayList<Box> boxes, Box previousBottom, int offset, int[] stackMemo) {
        if (offset >= boxes.size()) {
            return 0;
        }

        int heightWithCurrentBottom = 0;
        Box currentBottom = boxes.get(offset);
        if (previousBottom == null || currentBottom.canBeAbove(previousBottom)) {
            if (stackMemo[offset] == 0) {
                stackMemo[offset] = createStack(boxes, currentBottom, offset + 1, stackMemo);
                stackMemo[offset] + currentBottom.height;
            }

            heightWithCurrentBottom = stackMemo[offset];
        }

        int heightWithoutCurrentBottom = createStack(boxes, previousBottom, offset + 1, stackMemo);

        return Math.max(heightWithCurrentBottom, heightWithoutCurrentBottom);
    }

    public class BoxComparator implements Comparator<Box> {
        @Override
        public int compare(Box b1, Box b2) {
            return b2.height - b1.height;
        }
    }
}