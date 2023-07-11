package models;

import java.time.LocalDate;

public class Book {
    private int id;
    private String fullName;
    private int quantity;
    private Category category;
    private String description;
    private String author;
    private Publisher publisher;
    private Status status;
    private LocalDate importDate;

    public Book(int id, String fullName, int quantity, Category category, String description, String author, Publisher publisher, Status status, LocalDate importdate) {
        this.id = id;
        this.fullName = fullName;
        this.quantity = quantity;
        this.category = category;
        this.description = description;
        this.author = author;
        this.publisher = publisher;
        this.status = status;
        this.importDate = importDate;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", quantity=" + quantity +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", publisher=" + publisher +
                ", status=" + status +
                ", importDate=" + importDate +
                '}';
    }


    public Book parse(String text) {
        String[] book = text.split(",");
        return new Book(Integer.parseInt(book[0]),
                book[1],
                Integer.parseInt(book[2]),
                Category.valueOf(book[3]),
                book[4],
                book[5],
                Publisher.valueOf(book[6]),
                Status.valueOf(book[7]),
                LocalDate.parse(book[8]));
    }


    public String serialize() {
        return id + "," +
                fullName + "," +
                quantity + "," +
                category + "," +
                description + "," +
                author + "," +
                publisher + "," +
                status + "," +
                importDate;
    }
}
