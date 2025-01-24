import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskUtilities
{
    public static Book findBookByTitle(List<Book> books)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the title of the book you wish to find: ");
        String bookTitle = scanner.nextLine();

        for(Book book : books)
        {
            if(book.getTitle().equalsIgnoreCase(bookTitle))
            {
                return book;
            }
        }
        return null;
    }

    public static List<Book> showAllAvailableBooks(List<Book> books)
    {
        List<Book> availableBooks = new ArrayList<>();

        for(Book book : books)
        {
            if(book.getIsAvailable() == true)
                availableBooks.add(book);
        }
        return availableBooks;
    }

    public static List <Book> addANewBook(List <Book> books)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the id of the book: ");
        String newBookId = scanner.nextLine();

        System.out.println("Please enter the title of the book: ");
        String newBookTitle = scanner.nextLine();

        System.out.println("Please enter the author of the book: ");
        String newBookAuthor = scanner.nextLine();

        System.out.println("Please enter the publisher of the book: ");
        String newBookPublisher = scanner.nextLine();

        System.out.println("Please enter the number of pages in the book: ");
        int newBookNumberOfPages = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter the availability of the book (true/false): ");
        boolean newBookAvailability = Boolean.parseBoolean(scanner.nextLine());

        Book newBook = new Book(newBookId, newBookTitle, newBookAuthor, newBookPublisher, newBookNumberOfPages, newBookAvailability);

        books.add(newBook);

        InOutUtilities.printNewBook(newBook);

        return books;

    }
}
