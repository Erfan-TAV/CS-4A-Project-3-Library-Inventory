package items;

import exceptions.InvalidIndexException;

public class Magazine extends Item {
    private int edition;
    private String mainArticleTitle;

    public Magazine() {
        super();
        this.edition = 0;
        this.mainArticleTitle = "";
    }
    public Magazine(String name, String description, int id, int edition, String mainArticleTitle) {
        super(name, description, id);
        this.edition = edition;
        this.mainArticleTitle = mainArticleTitle;
    }

    public int getEdition() {
        return edition;
    }
    public void setEdition(int edition) {
        if (edition > 0) {
            this.edition = edition;
        }
        else {
            throw new InvalidIndexException("Invalid Edition, must be greater than 0");
        }
    }

    public String getMainArticleTitle() {
        return mainArticleTitle;
    }
    public void setMainArticleTitle(String mainArticleTitle) {
        this.mainArticleTitle = mainArticleTitle;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEdition: " + edition +
                "\nMain Article Title: " + mainArticleTitle;
    }
}
