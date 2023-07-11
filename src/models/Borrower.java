package models;

import java.sql.Date;
import java.time.LocalDate;

public class Borrower {
    private int id;
    private int userId;
    private int bookId;
    private LocalDate borrowDate;
    private LocalDate expDate;
    private int quantity;


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Borrower(int id, int userId, int bookId, LocalDate borrowDate, LocalDate expDate, int quantity) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.expDate = expDate;
        this.quantity = quantity;
    }



    public Borrower() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        int var10000 = this.id;
        return "" + var10000 + "," + this.userId + "," + this.bookId + "," + String.valueOf(this.borrowDate) + "," + String.valueOf(this.expDate) + "," + this.quantity;
    }
}
