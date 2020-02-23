public class CakeThief {
    public long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {
        long[] maxValuesAtCapacity = new long[weightCapacity + 1];

        for (int currentCapacity = 0; currentCapacity <= weightCapacity; currentCapacity++) {
            long currentMaxValue = 0;

            for (CakeType cakeType: cakeTypes) {
                if (cakeType.weight == 0 && cakeType.value != 0) {
                    throw new InfinityException();
                }

                if (cakeType.weight <= currentCapacity) {
                    long maxValueUsingCake = cakeType.value +
                            maxValuesAtCapacity[currentCapacity - cakeType.weight];

                    currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);
                }
            }

            maxValuesAtCapacity[currentCapacity] = currentMaxValue;
        }

        return maxValuesAtCapacity[weightCapacity];
    }
}