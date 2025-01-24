import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InOutUtilities
{
    public static List<Book> readFile(InputStream inputStream)
    {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(";");
                String Id = data[0];
                String Title = data[1];
                String Author = data[2];
                String Publisher = data[3];
                int Pages = Integer.parseInt(data[4]);
                boolean isAvailable = Boolean.parseBoolean(data[5]);

                Book book = new Book(Id, Title, Author, Publisher, Pages, isAvailable);
                books.add(book);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return books;
    }

    public static void printMainMenuOptions()
    {
        System.out.println("Select an option:");
        System.out.println("1. Show all books");
        System.out.println("2. Show all available books");
        System.out.println("3. Add a new book");
        System.out.println("4. Find a book by title");
    }

    public static void printTableHeader()
    {
        System.out.println("+--------------------+----------------------------+----------------------+------------------------------+-------+-------------+");
        System.out.printf("| %-18s | %-26s | %-20s | %-28s | %-5s | %-11s |%n", "Id", "Title", "Author", "Publisher", "Pages", "isAvailable");
        System.out.println("+--------------------+----------------------------+----------------------+------------------------------+-------+-------------+");
    }

    public static void printTable(List<Book> books)
    {
        InOutUtilities.printTableHeader();
        for(Book book : books)
        {
            System.out.println(book.toString());
        }
        InOutUtilities.printTableFooter();
    }

    public static void printTableFooter()
    {
        System.out.println("+--------------------+----------------------------+----------------------+------------------------------+-------+-------------+");
    }

    public static void printFoundBook(Book foundBook)
    {
        if(foundBook != null)
        {
            System.out.println("Found book:");
            printTableHeader();
            System.out.println(foundBook.toString());
            printTableFooter();
        }
        else
        {
            System.out.println("No book found");
        }
    }

    public static void printNewBook(Book newBook)
    {
        System.out.println("New book added:");
        printTableHeader();
        System.out.println(newBook.toString());
        printTableFooter();
    }

}
