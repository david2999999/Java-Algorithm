package Hard.Respace;

public class ParseResult {
    public int invalid = Integer.MAX_VALUE;
    public String parsed = "";

    public ParseResult(int invalid, String parsed) {
        this.invalid = invalid;
        this.parsed = parsed;
    }
}
