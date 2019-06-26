package com.example.cachee.demo.com.example.cachee.demo.service;


import com.example.cachee.demo.com.example.cachee.demo.model.Person;
import com.example.cachee.demo.com.example.cachee.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    //create Method
    public Person create(String firstName,String lastName, int age){
        return personRepository.save(new Person(firstName,lastName,age));
    }

    //retrieve
    public List<Person> getAll(){
    return personRepository.findAll();
    }


    public Person getByFirstName(String firstName){
            return personRepository.findByFirstName(firstName);
    }

    //Update
    public Person update(String firstName ,String lastName, int age){
        Person p=personRepository.findByFirstName(firstName);
        p.setAge(age);
        p.setLastName(lastName);
        return personRepository.save(p);
    }

    //delete
    public void deleteAll(){
        personRepository.deleteAll();
    }

    public void deleteOne(String firstName){
        Person p= personRepository.findByFirstName(firstName);
        personRepository.delete(p);
    }
}
