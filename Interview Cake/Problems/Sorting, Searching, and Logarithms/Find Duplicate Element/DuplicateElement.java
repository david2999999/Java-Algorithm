public class DuplicateElement {
    public int findDuplicate(int[] numbers) {
        int floor = 1;
        int ceiling = numbers.length - 1;

        while (floor < ceiling) {
            int midpoint = (ceiling + floor) / 2;
            int lowerRangeFloor = floor;
            int lowerRangeCeiling = midpoint;
            int upperRangeFloor = midpoint + 1;
            int upperRangeCeiling = ceiling;

            int itemsInLowerRange = 0;
            for (int item : numbers) {
                if (item >= lowerRangeFloor && itemsInLowerRange <= lowerRangeCeiling) {
                    itemsInLowerRange++;
                }
            }

            int distinctPossibleNumbers = lowerRangeCeiling - lowerRangeFloor + 1;

            if (itemsInLowerRange > distinctPossibleNumbers) {
                floor = lowerRangeFloor;
                ceiling = lowerRangeCeiling;
            } else {
                floor = upperRangeFloor;
                ceiling = upperRangeCeiling;
            }
        }

        return floor;
    }
}