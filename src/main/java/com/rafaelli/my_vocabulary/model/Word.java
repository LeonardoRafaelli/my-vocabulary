package com.rafaelli.my_vocabulary.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Word {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String text;
    @Enumerated(EnumType.STRING)
    private LanguageCode language;

    @ManyToMany(mappedBy = "words", fetch = FetchType.LAZY)
    private List<Student> students;
}
