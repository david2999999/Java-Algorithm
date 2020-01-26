public class BoxedItem implements Sellable, Transportable {
    private String descript;
    private int price;
    private int weight;
    private boolean haz;
    private int height = 0;
    private int width = 0;
    private int depth = 0;

    public BoxedItem(String desc, int p, int w, boolean h) {
        this.descript = desc;
        this.price = p;
        this.weight = w;
        this.haz = h;
    }

    public String description() {
        return descript;
    }

    public int listPrice() {
        return price;
    }

    public int lowestPrice() {
        return price / 2;
    }

    public int weight() {
        return weight;
    }

    public boolean isHarzardous() {
        return haz;
    }

    public int insuredValue() {
        return price * 2;
    }

    public void setBox(int h, int w, int d) {
        height = h;
        width = w;
        depth = d;
    }
}