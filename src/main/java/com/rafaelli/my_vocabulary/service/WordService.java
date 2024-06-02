package com.rafaelli.my_vocabulary.service;

import com.rafaelli.my_vocabulary.model.Word;
import com.rafaelli.my_vocabulary.model.enums.LanguageCode;
import com.rafaelli.my_vocabulary.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WordService {

    private final WordRepository wordRepo;
    private final StudentService studentService;

    public Word save(String newWord, String description, LanguageCode languageCode) {
        Word word = new Word();
        word.setText(newWord);
        word.setDescription(description);
        word.setLanguage(languageCode);
        word.setStudent(studentService.getLoggedInStudent());

        return wordRepo.save(word);
    }

    public void deleteWord(Integer wordId) {
        wordRepo.deleteById(wordId);
    }
}
