public class ListClientExample {
    private List list;
    
    public ListClientExample() {
        list = new LinkedList();
    }
    
    private List getList() {
        return list;
    }
    
    public static void main(String[] args) {
        ListClientExample lce = new ListClientExample();
        List list = lce.getList();
        System.out.println(list);
    }
}