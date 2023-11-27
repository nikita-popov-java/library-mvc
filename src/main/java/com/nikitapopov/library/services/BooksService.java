package com.nikitapopov.library.services;

import com.nikitapopov.library.models.Book;
import com.nikitapopov.library.models.Person;
import com.nikitapopov.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public List<Book> findAllPageable(Pageable pageable) {
        return booksRepository.findAll(pageable).stream().toList();
    }

    public Book find(int id) {
        return booksRepository.findById(id).orElse(null);
    }

    public List<Book> findAllByNameIgnoreCaseStartingWith(String queryString) {
        return booksRepository.findAllByNameIgnoreCaseStartingWith(queryString);
    }

    @Transactional
    public void save(Book book) {
        if (book.getHolder().getId() == 0)
            book.setHolder(null);
        book.setReceiptDate(new Date());

        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book book) {
        book.setId(id);
        booksRepository.save(book);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    @Transactional
    public void setBookToUser(int bookId, Person holder) {
        find(bookId).setHolder(holder);
    }
}
