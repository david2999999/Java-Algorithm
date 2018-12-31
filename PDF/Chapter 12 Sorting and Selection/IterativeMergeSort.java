public class IterativeMergeSort <K> {
    
    public static <K> void mergeSortBottomUp(K[] orig, Comparator<K> comp) {
        int n = orig.length;
        K[] src = orig;
        K[] dest = (K[]) new Object[n];
        K[] temp;
        
        for (int i = 1; i < n; i *= 2) {
            for (int j = 0; j < n; j += 2 * i) {
                merge(src, dest, comp, j, i);
            }
            
            temp = src; src = dest; dest = temp;
        }
        
        if (orig != src) {
            System.arraycopy(src, 0, orig, 0, n);
        }
    }
    
    
    public static <K> void merge(K[] in, K[] out, Comparator<K> comp, int start, int inc) {
        int end1 = Math.min(start + inc, in.length);
        int end2 = Math.min(start + 2 * inc, in.length);
        
        int x = start;
        int y = start + inc;
        int z = start;
        
        while (x < end1 && y < end2) {
            if (comp.compare(in[x], in[y])
                out[z++] = in[x++];
            else 
                out[z++] = in[y++];
        } 
        
        if (x < end1) System.arraycopy(in, x, out, z, end1 − x);
        else if (y < end2) System.arraycopy(in, y, out, z, end2 − y);
    }
    
    
    
}