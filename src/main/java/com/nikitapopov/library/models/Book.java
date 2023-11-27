package com.nikitapopov.library.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Название книги не может быть пустым!")
    private String name;

    @Column(name = "author")
    @NotBlank(message = "У книги не может не быть автора!")
    private String author;

    @Column(name = "year_of_created")
    @Max(value = 2023, message = "Книга не может быть написана позже 2023 года! (на момент разработки приложения)")
    private int yearOfCreated;

    @Column(name = "receipt_date")
    private Date receiptDate;

    @ManyToOne
    @JoinColumn(name = "holder_id", referencedColumnName = "id")
    private Person holder;

    @Transient
    private boolean isOverdue;

    public Book() {}

    public Book(String name, String author, int yearOfCreated, Person holder, Date receiptDate) {
        this.name = name;
        this.author = author;
        this.yearOfCreated = yearOfCreated;
        this.holder = holder;
        this.receiptDate = receiptDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfCreated() {
        return yearOfCreated;
    }

    public void setYearOfCreated(int yearOfCreated) {
        this.yearOfCreated = yearOfCreated;
    }

    public Person getHolder() {
        return holder;
    }

    public void setHolder(Person holder) {
        this.holder = holder;
    }
    public boolean isFree() {
        return holder == null;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean isOverdue() {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        long overdueTime = 1000 * 60 * 60 * 24 * 10; // ten days

        calendar.setTime(receiptDate);

        Date receiptDateTime = calendar.getTime();

        return currentDate.getTime() - receiptDateTime.getTime() > overdueTime;
    }

    public void setOverdue(boolean overdue) {
        isOverdue = overdue;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }
}
