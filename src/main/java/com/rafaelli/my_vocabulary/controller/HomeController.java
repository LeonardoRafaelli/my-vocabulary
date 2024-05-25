package com.rafaelli.my_vocabulary.controller;

import com.rafaelli.my_vocabulary.model.LanguageCode;
import com.rafaelli.my_vocabulary.model.Student;
import com.rafaelli.my_vocabulary.model.Word;
import com.rafaelli.my_vocabulary.service.StudentService;
import com.rafaelli.my_vocabulary.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final StudentService studentService;
    private final WordService wordService;

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

}
