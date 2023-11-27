package com.nikitapopov.library.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    @NotBlank(message = "Имя пользователя не может быть пустым!")
    @Pattern(message = "Введите данные в виде 'Фамилия Имя Отчество'",regexp = "([а-яА-Я]*? ){2}([а-яА-Я]*?)")
    @Size(min = 5, max = 50, message = "Недопустимая длина ФИО")
    private String fullName;

    @Column(name = "year_of_birth")
    @Max(value = 2023, message = "Человек не может быть рождён позже 2023 года! (на момент разработки приложения)")
    private int yearOfBirth;

    @OneToMany(mappedBy = "holder", cascade = CascadeType.PERSIST)
    private List<Book> books;

    public Person() {}

    public Person(String fullName, int yearOfBirth) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
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

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}