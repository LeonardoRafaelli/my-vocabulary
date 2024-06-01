package com.rafaelli.my_vocabulary.service;

import com.rafaelli.my_vocabulary.config.CustomUserDetails;
import com.rafaelli.my_vocabulary.model.Student;
import com.rafaelli.my_vocabulary.model.Word;
import com.rafaelli.my_vocabulary.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepo;

    public Student getLoggedInStudent() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if(principal instanceof UserDetails) {
                return ((CustomUserDetails) principal).getStudent();
            }
        }
        return null;
    }

    public Student save(Student student){
        return studentRepo.save(student);
    }

    public Student getByEmail(String username) {
        Optional<Student> optionalStudent = studentRepo.findByEmail(username);

        if(optionalStudent.isEmpty()) {
            throw new UsernameNotFoundException("Student email could not be found!");
        }

        return optionalStudent.get();
    }

    public Word getStudentRandomWord() {
        List<Word> words = getLoggedInStudent().getWords();

        int wordListLength = words.size();
        int randomIndex = (int) Math.floor(Math.random() * wordListLength);

        return words.get(randomIndex);
    }
}
