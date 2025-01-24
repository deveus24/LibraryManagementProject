public class Book
{
    private String Id;
    private String Title;
    private String Author;
    private String Publisher;
    private int Pages;
    private boolean isAvailable;

    public Book(String id, String title, String author, String publisher, int pages, boolean isAvailable)
    {
        this.Id = id;
        this.Title = title;
        this.Author = author;
        this.Publisher = publisher;
        this.Pages = pages;
        this.isAvailable = isAvailable;
    }

    //Getters and Setters
    public String getId()
    {
        return Id;
    }
    public void setId(String id)
    {
        this.Id = id;
    }

    public String getTitle()
    {
        return Title;
    }
    public void setTitle(String title)
    {
        this.Title = title;
    }

    public String getAuthor()
    {
        return Author;
    }
    public void setAuthor(String author)
    {
        this.Author = author;
    }

    public String getPublisher()
    {
        return Publisher;
    }
    public void setPublisher(String publisher)
    {
        this.Publisher = publisher;
    }

    public int getPages()
    {
        return Pages;
    }
    public void setPages(int pages)
    {
        this.Pages = pages;
    }

    public boolean getIsAvailable()
    {
        return isAvailable;
    }
    public void setIsAvailable(boolean isAvailable)
    {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString()
    {
        return String.format("| %-18s | %-26s | %-20s | %-28s | %5d | %11b |",
                Id, Title, Author, Publisher, Pages, isAvailable);
    }

}
