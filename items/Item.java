package items;

import java.time.LocalDate;

public class Item {
    private String name;
    private String description;
    private int id;

    // Checkout System
    private boolean checkedOut;
    private String borrowerName;
    private LocalDate dueDate;

    Item(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.checkedOut = false;
        this.borrowerName = "";
    }
    Item() {
        this.name = "";
        this.description = "";
        this.id = 0;
        this.checkedOut = false;
        this.borrowerName = "";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nDescription: " + description +
                "\nID: " + id;
    }

    public void markCheckedOut(String person, int borrowPeriod) {
        this.checkedOut = true;
        this.borrowerName = person;
        this.dueDate = LocalDate.now().plusDays(borrowPeriod);
    }
    public void markReturned() {
        this.checkedOut = false;
        this.borrowerName = "";
        this.dueDate = null;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public String getBorrowerName() {
        return borrowerName;
    }
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
}