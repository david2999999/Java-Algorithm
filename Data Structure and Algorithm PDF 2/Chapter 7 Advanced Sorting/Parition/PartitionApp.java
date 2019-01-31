class PartitionApp
    {
    public static void main(String[] args)
        {
        int maxSize = 16; // array size
        ArrayPar arr; // reference to array
        arr = new ArrayPar(maxSize); // create the array
        
        for(int j=0; j<maxSize; j++) // fill array with
            { // random numbers
            long n = (int)(java.lang.Math.random()*199);
            arr.insert(n);
            }
            
        arr.display(); // display unsorted array
        long pivot = 99; // pivot value
        System.out.print(“Pivot is “ + pivot);
        int size = arr.size();
        // partition array
        int partDex = arr.partitionIt(0, size-1, pivot);
        
        System.out.println(“, Partition is at index “ + partDex);
        arr.display(); // display partitioned array
        } // end main()
    }