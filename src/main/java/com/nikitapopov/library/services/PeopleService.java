package com.nikitapopov.library.services;

import com.nikitapopov.library.models.Person;
import com.nikitapopov.library.repositories.PeopleRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person find(int id) {
        return peopleRepository.findById(id).orElse(null);
    }

    public Person find(int id, boolean isNeedInitBooks) {
        Person person = find(id);
        if (isNeedInitBooks)
            Hibernate.initialize(person.getBooks());
        return person;
    }

    public Optional<Person> findByFullName(String fullName) {
        return peopleRepository.findByFullName(fullName);
    }

    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person person) {
        person.setId(id);
        peopleRepository.save(person);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }
}