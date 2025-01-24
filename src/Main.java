import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        InputStream inputStream = Main.class.getResourceAsStream("resources/BookData.txt");
        List<Book> books = InOutUtilities.readFile(inputStream);

        List <Book> allAvailableBooks = TaskUtilities.showAllAvailableBooks(books);

        InOutUtilities.printMainMenuOptions();
        String operation;
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            operation = scanner.nextLine();

            switch(operation)
            {
                case "1" ->
                {
                    InOutUtilities.printTable(books);
                }

                case "2" ->
                {
                    InOutUtilities.printTable(allAvailableBooks);
                }

                case "3" ->
                {
                    TaskUtilities.addANewBook(books);
                }

                case "4" ->
                {
                    Book foundBook = TaskUtilities.findBookByTitle(books);
                    InOutUtilities.printFoundBook(foundBook);
                }
            }
            InOutUtilities.printMainMenuOptions();
        }
    }
}