public class StableSelectionSort {
    // Sort an array using a stable selection sort.
    public static void selectionSortStable( int[] data ){
        for ( int start = 0; start < data.length - 1; ++start ){
            insert( data, start, findMinimumIndex( data, start ) );
        }
    }

    // Insert the data into the array, shifting the array as necessary.
    private static void insert( int[] data, int start, int minIndex ){
        if ( minIndex > start ){
            int tmp = data[minIndex];
            System.arraycopy( data, start, data, start + 1, minIndex - start );
            data[start] = tmp;
        }
    }
}