public class Author implements Comparable<Author> {
    private String firstName;
    private String lastName;
    private String bookName;

    public Author(String firstName, String lastName, String bookName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookName = bookName;
    }

    @Override
    public int compareTo(Author other) {
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        return lastNameComparison == 0 ? this.firstName.compareTo(other.firstName) : lastNameComparison;
    }
}