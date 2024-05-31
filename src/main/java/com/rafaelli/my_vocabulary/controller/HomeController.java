package com.rafaelli.my_vocabulary.controller;

import com.rafaelli.my_vocabulary.model.LanguageCode;
import com.rafaelli.my_vocabulary.model.Student;
import com.rafaelli.my_vocabulary.model.Word;
import com.rafaelli.my_vocabulary.service.StudentService;
import com.rafaelli.my_vocabulary.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final StudentService studentService;
    private final WordService wordService;

    @GetMapping("/")
    public String homePage(Model m) {

        m.addAttribute("studentWords", studentService.getLoggedUser().getWords());

        return "index";
    }

    @PostMapping("/create-word")
    public RedirectView createWord(
            @RequestParam("newWord") String newWord,
            @RequestParam("description") String description
    ){
        Word word = new Word();
        word.setText(newWord);
        word.setDescription(description);
        word.setLanguage(LanguageCode.DE);
        word.setStudent(studentService.getLoggedUser());

        wordService.save(word);

        return new RedirectView("/");
    }

    @PostMapping("/delete-word")
    public RedirectView deleteWord(
            @RequestParam("wordId") Integer wordId
    ) {

        wordService.deleteWord(wordId);

        return new RedirectView("/");
    }


    @GetMapping("/learn")
    public String learnPage(Model m){

        Word word = studentService.getStudentRandomWord();

        m.addAttribute("word", word);

        return "learn";
    }

}
