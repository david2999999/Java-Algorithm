public class TrackingHeadElement {
    public ListElement<Integer> insertInFront( ListElement<Integer> list, int data ){
        ListElement<Integer> l = new ListElement<Integer>( data );
        l.setNext( list );
        return l;
    }
}