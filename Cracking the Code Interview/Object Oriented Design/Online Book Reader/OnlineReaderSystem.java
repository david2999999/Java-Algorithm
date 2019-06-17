package ObjectOrientedDesign.OnlineBookReader;

public class OnlineReaderSystem {
    private Library library;
    private UserManager userManager;
    private Display display;

    private User activeUser;
    private Book activeBook;

    public OnlineReaderSystem() {
        this.library = new Library();
        this.userManager = new UserManager();
        this.display = new Display();
    }

    public Library getLibrary() {
        return library;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public Book getActiveBook() {
        return activeBook;
    }

    public void setActiveBook(Book book) {
        this.activeBook = book;
        this.display.displayBook(book);
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User user) {
        this.activeUser = user;
        this.display.displayUser(user);
    }
}
