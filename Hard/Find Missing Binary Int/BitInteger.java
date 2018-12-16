package Hard.FindMissingInt;

public class BitInteger {
    public static final int INTEGER_SIZE = 5;
    private String bitNumber;

    public int fetch(int column) {
        return Character.getNumericValue(bitNumber.charAt(column));
    }
}
