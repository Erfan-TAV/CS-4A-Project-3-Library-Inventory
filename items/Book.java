package items;

import java.time.LocalDate;

public class Book extends Item {
    private String title;
    private String author;
    private LocalDate copyrightDate;

    public Book(String name, String description, int id, String title, String author, LocalDate copyrightDate) {
        super(name, description, id);
        this.title = title;
        this.author = author;
        this.copyrightDate = copyrightDate;
    }
    public Book() {
        super();
        this.title = "";
        this.author = "";
        this.copyrightDate = null;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


    public LocalDate getCopyrightDate() {
        return copyrightDate;
    }
    public void setCopyrightDate(int year, int month, int day) {
        this.copyrightDate = LocalDate.of(year, month, day);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTitle: " + title +
                "\nAuthor: " + author +
                "\nCopyright: " + copyrightDate;
    }
}
