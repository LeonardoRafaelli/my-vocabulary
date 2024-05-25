package com.rafaelli.my_vocabulary;

import com.rafaelli.my_vocabulary.model.LanguageCode;
import com.rafaelli.my_vocabulary.model.Student;
import com.rafaelli.my_vocabulary.model.Word;
import com.rafaelli.my_vocabulary.repository.StudentRepository;
import com.rafaelli.my_vocabulary.repository.WordRepository;
import com.rafaelli.my_vocabulary.service.StudentService;
import com.rafaelli.my_vocabulary.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MyVocabularyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyVocabularyApplication.class, args);
	}

}
