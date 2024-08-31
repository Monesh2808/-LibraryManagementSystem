import java.util.Scanner;
class BookNode {
    String title;
    String author;
    String isbn;
    BookNode next;
    public BookNode(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.next = null;
    }
}
class LibraryLinkedList {
    private BookNode head;
    public LibraryLinkedList() {
        this.head = null;
    }
    public void addBook(String title, String author, String isbn) {
        BookNode newBook = new BookNode(title, author, isbn);
        if (head == null) {
            head = newBook;
        } else {
            BookNode lastBook = head;
            while (lastBook.next != null) {
                lastBook = lastBook.next;
            }
            lastBook.next = newBook;
        }
        System.out.println("Book \"" + title + "\" added successfully.");
    }
    public void displayBooks() {
        if (head == null) {
            System.out.println("No books in the library.");
        } else {
            BookNode current = head;
            while (current != null) {
                System.out.println("Title: " + current.title + ", Author: " + current.author + ", ISBN: " + current.isbn);
                current = current.next;
            }
        }
    }
    public void searchBook(String title) {
        BookNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.println("Book found - Title: " + current.title + ", Author: " + current.author + ", ISBN: " + current.isbn);
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }
    public void removeBook(String isbn) {
        if (head == null) {
            System.out.println("The library is empty.");
            return;
        }
        if (head.isbn.equals(isbn)) {
            System.out.println("Book \"" + head.title + "\" removed.");
            head = head.next;  // Update head to the next book
            return;
        }
        BookNode previous = null;
        BookNode current = head;
        while (current != null) {
            if (current.isbn.equals(isbn)) {
                System.out.println("Book \"" + current.title + "\" removed.");
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }

        System.out.println("Book with the given ISBN not found.");
    }
}

    public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryLinkedList library = new LibraryLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Remove Book by ISBN");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(title, author, isbn);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter the title of the book to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 4:
                    System.out.print("Enter the ISBN of the book to remove: ");
                    String removeIsbn = scanner.nextLine();
                    library.removeBook(removeIsbn);
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
