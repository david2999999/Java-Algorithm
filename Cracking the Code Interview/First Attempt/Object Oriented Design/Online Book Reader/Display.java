package ObjectOrientedDesign.OnlineBookReader;

public class Display {
    private User activeUser;
    private Book activeBook;
    private int bookNumber = 0;

    public void displayUser(User user) {
        this.activeUser = user;
        refreshUserName();
    }

    public void displayBook(Book book) {
        this.activeBook = book;
        this.bookNumber = 0;

        this.refreshTitle();
        this.refreshDetails();
        this.refreshPage();
    }

    public void turnPageForward() {
        bookNumber++;
        refreshPage();
    }

    public void turnPageBackward() {
        bookNumber--;
        refreshPage();
    }

    private void refreshTitle() {

    }

    private void refreshDetails() {

    }

    private void refreshPage() {
    }

    private void refreshUserName() {
    }

}
