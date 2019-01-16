public class TotalDiskUsage {
    public static long diskUsage(File root) {
        long total = root.length();
        
        if (root.isDirectory()) {
            for (String childName: root.list()) {
                File child = new File(root, childName);
                total += diskUsage(child);
            }
        }
        
        return total;
    }
}