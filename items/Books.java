package items;

import java.time.LocalDate;

public class Books extends Item {
    private String title;
    private String author;
    private LocalDate copyrightDate;

    Books(String name, String description, int id, String title, String author, LocalDate copyrightDate) {
        super(name, description, id);
        this.title = title;
        this.author = author;
        this.copyrightDate = copyrightDate;
    }
    Books() {
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
}
