package com.rafaelli.my_vocabulary.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Student {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "student")
    private List<Word> words;

    @Override
    public String toString() {
        return STR."username: \{username}, password: \{password}";
    }

}
