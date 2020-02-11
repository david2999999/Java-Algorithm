public class BucketSort {
    public void sort(int[] arr) {
        int min = min(arr);
        int max = max(arr);
        int length = arr.length;
        Bucket[] buckets = new Bucket[length];

        for (int i = 0; i < length; i++) {
            int bucketIndex = calculateBucketIndex(arr[i], length, max, min);
            buckets[bucketIndex].add(arr[i]);
        }

        int i = 0;
        for (int j = 0; j < length; j++) {
            Bucket bucket = buckets[j];
            bucket.sort();

            for (int k = 0; k < bucket.size(); k++) {
                arr[i++] = bucket.get(k);
            }
        }
    }

    private int calculateBucketIndex(int value, int totalNumberOfBuckets, int max, int min) {
        return totalNumberOfBuckets * ((value - min) / (max - min + 1));
    }

    public int min(int[] arr) {
        int min = arr[0];

        for (int number: arr) {
            if (number < min) {
                min = number;
            }
        }

        return min;
    }

    public int max(int[] arr) {
        int max = arr[0];

        for (int number: arr) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }
}