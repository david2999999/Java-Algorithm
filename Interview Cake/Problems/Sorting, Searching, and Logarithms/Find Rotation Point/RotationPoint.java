public class RotationPoint {
    public int findRotationPoint(String[] words) {
        if (words == null || words.length < 2) {
            return -1;
        }

        String firstWord = words[0];

        int floor = 0;
        int ceiling = words.length - 1;

        while (floor < ceiling) {
            int mid = (ceiling + floor) / 2;

            if (words[mid] >= firstWord) {
                floor = mid;
            } else {
                ceiling = mid;
            }

            if (floor + 1 == ceiling) {
                break;
            }
        }

        return ceiling;
    }
}

// This is a modified version of binary search. At each iteration, we go right if the item we're
// looking at is greater than the first item and we go left if the item we're looking at is less than the first item.

// We keep track of the lower and upper bounds on the rotation point, calling them
// floorIndex and ceilingIndex (initially we called them "floor" and "ceiling," but
// because we didn't imply the type in the name we got confused and created bugs). When floorIndex
// and ceilingIndex are directly next to each other, we know the floor is the last item we added
// before starting from the beginning of the dictionary, and the ceiling is the first item we added after.

// Some languages—like German, Russian, and Dutch—can have arbitrarily long words,
// so we might want to factor the length of the words into our runtime. We could say
// the length of the words is l, each string comparison takes O(l) time,
// and the whole algorithm takes O(l * log(n)) time.