package com.rafaelli.my_vocabulary.repository;

import com.rafaelli.my_vocabulary.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {
}
