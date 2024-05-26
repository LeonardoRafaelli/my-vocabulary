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
    private String description;
    @Enumerated(EnumType.STRING)
    private LanguageCode language;

    @ManyToOne
    private Student student;
}
