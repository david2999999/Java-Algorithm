class HashDoubleApp
    {
    public static void main(String[] args) throws IOException
        {
        int aKey;
        DataItem aDataItem;
        int size, n;
        // get sizes
        System.out.print(“Enter size of hash table: “);
        size = getInt();
        System.out.print(“Enter initial number of items: “);
        n = getInt();
        // make table
        HashTable theHashTable = new HashTable(size);
        
        for(int j=0; j<n; j++) // insert data
            {
            aKey = (int)(java.lang.Math.random() * 2 * size);
            aDataItem = new DataItem(aKey);
            theHashTable.insert(aKey, aDataItem);
            }
            
        while(true) // interact with user
            {
            System.out.print(“Enter first letter of “);
            System.out.print(“show, insert, delete, or find: “);
            char choice = getChar();
            switch(choice)
                {
                case ‘s’:
                    theHashTable.displayTable();
                    break;
                case ‘i’:
                    System.out.print(“Enter key value to insert: “);
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    theHashTable.insert(aKey, aDataItem);
                    break;
                case ‘d’:
                    System.out.print(“Enter key value to delete: “);
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case ‘f’:
                    System.out.print(“Enter key value to find: “);
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if(aDataItem != null)
                        System.out.println(“Found “ + aKey);
                    else
                        System.out.println(“Could not find “ + aKey);
                    break;
                default:
                    System.out.print(“Invalid entry\n”);
                } // end switch
            } // end while
        } // end main()
    //--------------------------------------------------------------
    public static String getString() throws IOException
        {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
        }
    //--------------------------------------------------------------
    public static char getChar() throws IOException
        {
        String s = getString();
        return s.charAt(0);
        }
    //-------------------------------------------------------------
    public static int getInt() throws IOException
        {
        String s = getString();
        return Integer.parseInt(s);
        }
    //--------------------------------------------------------------
    } // end class HashDoubleApp
    ////////////////////////////////////////////////////////////////