package com.rafaelli.my_vocabulary.service;

import com.rafaelli.my_vocabulary.model.Word;
import com.rafaelli.my_vocabulary.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WordService {

    private final WordRepository wordRepo;

    public Word save(Word word) {
        return wordRepo.save(word);
    }

}
