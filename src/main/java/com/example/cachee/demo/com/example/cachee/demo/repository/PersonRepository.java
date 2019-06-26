package com.example.cachee.demo.com.example.cachee.demo.repository;

import com.example.cachee.demo.com.example.cachee.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,String> {

    public Person findByFirstName(String FirstName);
    public List<Person> findByAge(int age);
}
