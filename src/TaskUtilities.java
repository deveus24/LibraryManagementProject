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
            if(book.getIsAvailable())
                availableBooks.add(book);
        }
        return availableBooks;
    }

    public static void addANewBook(List <Book> books)
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
    }

    public static void removeBookByName(List<Book> books)
    {

        boolean removed = false;

        System.out.println("Please enter the name of the book you wish to remove: ");
        Scanner scanner = new Scanner(System.in);

        String bookNameToRemove = scanner.nextLine();

        System.out.println("Are you sure you want to remove: " + bookNameToRemove + " book?");

        String answer = scanner.nextLine();

        if(answer.equalsIgnoreCase("yes"))
        {
            for(Book book : books)
            {
                if(book.getTitle().equalsIgnoreCase(bookNameToRemove))
                {
                    books.remove(book);

                    InOutUtilities.printTableHeader();
                    System.out.println(book);
                    InOutUtilities.printTableFooter();
                    System.out.println("Book was removed successfully");

                    removed = true;
                    break;
                }
            }
            if(!removed)
                System.out.println("Error: book not found, check spelling");
        }
    }

    public static void totalNumberOfBooksInTheLibrary(List<Book> books)
    {
        int totalNumberOfBooks = books.size();
        System.out.println("Total number of books in the library: " + totalNumberOfBooks);
    }

    public static void totalNumberOfAvailableBooksInTheLibrary(List<Book> books)
    {
        int totalNumberOfAvailableBooks = 0;

        for(Book book : books)
        {
            if(book.getIsAvailable())
                totalNumberOfAvailableBooks++;
        }

        System.out.println("Total number of available books in the library: " + totalNumberOfAvailableBooks);
    }

    public static void sortBooksByNumberOfPages(List<Book> books)
    {
       books.sort((b1, b2) -> Integer.compare(b2.getPages(), b1.getPages()));
    }
}
