import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryCatalog {
    private List<Book> catalog;

    public LibraryCatalog() {
        catalog = new ArrayList<>();
    }

    public void addBook(Book book) {
        catalog.add(book);
        System.out.println("Book added to the catalog: " + book);
    }

    public Book searchByTitle(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book searchByAuthor(String author) {
        for (Book book : catalog) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

    public void displayCatalog() {
        System.out.println("Library Catalog:");
        for (Book book : catalog) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        LibraryCatalog libraryCatalog = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Catalog System");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Search Book by Author");
            System.out.println("4. Display Catalog");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String ISBN = scanner.nextLine();
                    Book book = new Book(title, author, ISBN);
                    libraryCatalog.addBook(book);
                    break;
                case 2:
                    System.out.print("Enter book title to search: ");
                    title = scanner.nextLine();
                    Book foundByTitle = libraryCatalog.searchByTitle(title);
                    if (foundByTitle != null) {
                        System.out.println("Book found: " + foundByTitle);
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter book author to search: ");
                    author = scanner.nextLine();
                    Book foundByAuthor = libraryCatalog.searchByAuthor(author);
                    if (foundByAuthor != null) {
                        System.out.println("Book found: " + foundByAuthor);
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 4:
                    libraryCatalog.displayCatalog();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
