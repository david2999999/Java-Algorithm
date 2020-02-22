public class DuplicateElement {
    public int findDuplicate(int[] intArray) {
        int n = intArray.length - 1;

        int positionInCycle = findPositionInCycle(intArray);
        int lengthOfCycle = findLengthOfCycle(intArray, positionInCycle);
        return getStartOfLoop(intArray, lengthOfCycle);
    }

    private int getStartOfLoop(int[] intArray, int cycleLength) {
        int start = intArray.length + 1;
        int ahead = intArray.length + 1;

        for (int i = 0; i < cycleLength; i++) {
            ahead = intArray[ahead - 1];
        }

        while (start != ahead) {
            start = intArray[start - 1];
            ahead = intArray[ahead - 1];
        }

        return start;
    }

    private int findLengthOfCycle(int intArray, int positionInCycle) {
        int rememberedPositionInCycle = positionInCycle;
        int currentPositionInCycle = intArray[positionInCycle - 1];
        int cycleStepCount = 1;

        while (currentPositionInCycle != rememberedPositionInCycle) {
            currentPositionInCycle = intArray[currentPositionInCycle - 1];
            cycleStepCount++;
        }

        return cycleStepCount;
    }

    private int findPositionInCycle(int[] intArray) {
        int positionInCycle = intArray.length + 1;

        for (int i = 0; i < intArray.length; i++) {
            positionInCycle = intArray[positionInCycle - 1];
        }

        return positionInCycle;
    }
}