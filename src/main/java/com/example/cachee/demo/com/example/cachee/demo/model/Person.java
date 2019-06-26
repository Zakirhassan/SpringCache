package com.example.cachee.demo.com.example.cachee.demo.model;

import lombok.Getter;
import javax.persistence.*;

import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name="student")
@NoArgsConstructor
public class Person implements Serializable {
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Getter @Setter
    private Long id;


    @Getter @Setter
    String firstName;
    @Getter @Setter
    String lastName;
    @Getter @Setter
    int age;



    public  String toString(){

        return "First Name :"+firstName+"Last Name:"+lastName+"Age :"+age;
    }

}
