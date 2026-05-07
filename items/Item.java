package items;

public class Item {
    private String name;
    private String description;
    private int id;

    Item(String name, String description, int id) {
        this.name = name;
        this.description = description;
    }
    Item() {
        this.name = "";
        this.description = "";
    }

    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return description;
    }
    void setDescription(String description) {
        this.description = description;
    }

    int getId() {
        return id;
    }
    void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nDescription: " + description +
                "\nID: " + id;
    }

}