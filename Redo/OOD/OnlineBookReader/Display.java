package Redo.OOD.OnlineBookReader;

public class Display {
    private User activeUser;
    private Book activeBook;
    private int pageNumber;

    public Display() {
        this.activeBook = null;
        this.activeUser = null;
        this.pageNumber = 0;
    }


    public void displayUser(User user) {
        activeUser = user;
        refreshUsername();
    }

    public void displayBook(Book book) {
        this.activeBook = book;
        pageNumber = 1;

        refreshTitle();
        refreshDetails();
        refreshPage();
    }

    public void turnPageForward() {
        pageNumber++;
        refreshPage();
    }

    public void turnPageBackward() {
        if (pageNumber == 0) return;

        pageNumber--;
        refreshPage();
    }

    public void refreshUsername() {}
    public void refreshTitle() {}
    public void refreshDetails() {}
    public void refreshPage() {}
}
