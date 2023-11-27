package com.nikitapopov.library.dao;

import com.nikitapopov.library.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO extends AbstractLibraryDAO<Person> {

    @Autowired
    public PersonDAO(JdbcTemplate template) {
        super(template);
    }

    @Override
    public List<Person> index() {
        throw new IllegalArgumentException();
    }

    @Override
    public Optional<Person> show(String name) {
        throw new IllegalArgumentException();
    }

    @Override
    public Person show(int id) {
        throw new IllegalArgumentException();
    }

    @Override
    public void save(Person record) {
    }

    @Override
    public void update(int id, Person record) {
    }

    @Override
    public void delete(int id) {
    }
}