package Redo.OOD.OnlineBookReader;

public class BookReader {
    private Library library;
    private UserManager userManager;
    private Display display;

    private User activeUser;
    private Book activeBook;

    public BookReader() {
        this.library = new Library();
        this.userManager = new UserManager();
        this.display = new Display();
    }


    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
        this.display.displayUser(activeUser);
    }

    public void setActiveBook(Book activeBook) {
        this.activeBook = activeBook;
        this.display.displayBook(activeBook);
    }


    public User getActiveUser() {
        return activeUser;
    }

    public Book getActiveBook() {
        return activeBook;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public Display getDisplay() {
        return display;
    }

    public Library getLibrary() {
        return library;
    }
}
