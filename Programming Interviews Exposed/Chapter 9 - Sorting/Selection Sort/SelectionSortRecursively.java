public class SelectionSortRecursively {
    // Sort an array using a recursive selection sort.
    public static void selectionSortRecursive( int[] data ){
        selectionSortRecursive( data, 0 );
    }

    // Sort a subset of the array starting at the given index.
    private static void selectionSortRecursive( int[] data, int start ){
        if ( start < data.length - 1 ){
            swap( data, start, findMinimumIndex( data, start ) );
            selectionSortRecursive( data, start + 1 );
        }
    }

    // Find the position of the minimum value starting at the given index.
    private static int findMinimumIndex( int[] data, int start ){
        int minPos = start;
        for ( int i = start + 1; i < data.length; ++i ){
            if ( data[i] < data[minPos] ){
                minPos = i;
            }
        }
        return minPos;
    }

    // Swap two elements in an array.
    private static void swap( int[] data, int index1, int index2 ){
        if ( index1 != index2 ){
            int tmp = data[index1];
            data[index1] = data[index2];
            data[index2] = tmp;
        }
    }
}