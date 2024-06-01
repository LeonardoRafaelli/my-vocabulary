package com.rafaelli.my_vocabulary.model;

import com.rafaelli.my_vocabulary.config.UserRole;
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
    private String email;
    private String password;
    private UserRole userRole;

    @OneToMany(mappedBy = "student")
    private List<Word> words;

}
