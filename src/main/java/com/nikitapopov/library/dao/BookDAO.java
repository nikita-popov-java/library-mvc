package com.nikitapopov.library.dao;

import com.nikitapopov.library.models.Book;
import com.nikitapopov.library.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO extends AbstractLibraryDAO<Book> {

    @Autowired
    public BookDAO(JdbcTemplate template) {
        super(template);
    }

    @Override
    public List<Book> index() {
        throw new IllegalArgumentException();
    }

    @Override
    public Optional<Book> show(String name) {
        throw new IllegalArgumentException();
    }

    @Override
    public Book show(int id) {
        throw new IllegalArgumentException();
    }

    @Override
    public void save(Book record) {

    }

    @Override
    public void update(int id, Book record) {

    }

    @Override
    public void delete(int id) {
    }

    public List<Book> getUserBooks(int id) {
        throw new IllegalArgumentException();
    }

    public Person getBookHolder(int bookId) {
        throw new IllegalArgumentException();
    }

    public void setBookToUser(int bookId, Integer userId) {
    }
}
