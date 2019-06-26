package com.example.cachee.demo.com.example.cachee.demo.controller;


import com.example.cachee.demo.com.example.cachee.demo.model.Person;
import com.example.cachee.demo.com.example.cachee.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @CachePut(value="person", key="#firstName")
    @RequestMapping("/create")
    public String create(@RequestParam String firstName ,@RequestParam String lastName,@RequestParam int age){
        System.out.println("Creating A Records");
        Person p=personService.create(firstName,lastName,age);
        return p.toString();
    }


    @RequestMapping("/get")
    @ResponseBody
    public Person getPerson(@RequestParam String firstName){
        System.out.println("Getting One Records");
        return personService.getByFirstName(firstName);
    }

    @Cacheable(value = "person")
    @RequestMapping("/getAll")
    public List<Person> getAll(){
        System.out.println("Getting All Records");
        return personService.getAll();
    }

    @CachePut(value = "person" , key = "#firstName")
    @RequestMapping("/update")
    public String update (@RequestParam String firstName ,@RequestParam String lastName,@RequestParam int age){
        System.out.println("Updating a Record");
        Person p=personService.update(firstName ,lastName, age);
        return p.toString();

    }
    @CacheEvict(value = "person", key="#firstName")
    @RequestMapping("/deleteOne")
    public String delete(@RequestParam String firstName){
        System.out.println("Deleting One Records");
        personService.deleteOne(firstName);
          return "Deleted"+firstName;
    }
    @CacheEvict(value = "person", allEntries = true)
    @RequestMapping("/deleteAll")
    public String deleteAll(){
        System.out.println("Deleting All Records");
        personService.deleteAll();
        return "deleted All Rows";
    }

    @CacheEvict(value = "person ", allEntries = true)
    @RequestMapping("/clearCache")
    public String clearCache(){
        System.out.println("Cache Cleared");
        return "Cache Cleared";
    }
}
