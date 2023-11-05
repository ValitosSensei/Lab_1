import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public boolean removeBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Додавання книг до бібліотеки
        Book book1 = new Book("Книга 1", "Автор 1", "1234567890", 2022);
        Book book2 = new Book("Книга 2", "Автор 2", "2345678901", 2020);
        library.addBook(book1);
        library.addBook(book2);

        // Перегляд всіх книг в бібліотеці
        List<Book> allBooks = library.getAllBooks();
        for (Book book : allBooks) {
            System.out.println("Назва: " + book.getTitle());
            System.out.println("Автор: " + book.getAuthor());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Рік видання: " + book.getYear());
            System.out.println();
        }

        // Пошук книги за назвою
        Book foundBook = library.findBookByTitle("Книга 1");
        if (foundBook != null) {
            System.out.println("Знайдена книга: " + foundBook.getTitle());
        } else {
            System.out.println("Книга не знайдена.");
        }

        // Видалення книги за ISBN
        String isbnToRemove = "1234567890";
        if (library.removeBookByIsbn(isbnToRemove)) {
            System.out.println("Книга з ISBN " + isbnToRemove + " була видалена.");
        } else {
            System.out.println("Книга з ISBN " + isbnToRemove + " не знайдена в бібліотеці.");
        }
    }
}
