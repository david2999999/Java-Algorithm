/* Returns the largest value in an array of n non-negative integers */
int CompareToMax(int array[], int n){
    int curMax, i;
    /* Make sure that there is at least one element in the array. */
    if (n <= 0)
        return -1;

    /* Set the largest number so far to the first array value. */
    curMax = array[0];

    /* Compare every number with the largest number so far. */
    for (i = 1; i < n; i++) {
        if (array[i] > curMax) {
            curMax = array[i];
        }
    }
    return curMax;
}

/* Returns the largest value in an array of n non-negative integers */
int CompareToAll(int array[], int n){
    int i, j;

    bool isMax;

    /* Make sure that there is at least one element in the array. */
    if (n <= 0)
        return -1;
    for (i = 0; i < n; i++) {
        isMax = true;
        for (j = 0; j < n; j++) {
            /* See if any value is greater. */
            if (array[j] > array[i]) {
                isMax = false; /* array[i] is not the largest value. */
                break;
            }
        }
        /* If isMax is true, no larger value exists; array[i] is max. */
        if (isMax) break;
    }

    return array[i];
}

// The analysis so far has shown that CompareToMax is O(n) and CompareToAll is O(n2). This means
//that as the array grows, the number of comparisons in CompareToAll becomes much larger than
//in CompareToMax. Consider an array with 30,000 elements. CompareToMax compares on the order
//of 30,000 elements, whereas CompareToAll compares on the order of 900,000,000 elements. You
//would expect CompareToMax to be much faster because it examines 30,000 times fewer elements.
//In fact, one benchmark timed CompareToMax at less than .01 seconds, whereas CompareToAll took
//23.99 seconds.