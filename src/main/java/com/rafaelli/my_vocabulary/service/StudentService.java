package com.rafaelli.my_vocabulary.service;

import com.rafaelli.my_vocabulary.config.CustomUserDetails;
import com.rafaelli.my_vocabulary.model.enums.UserRole;
import com.rafaelli.my_vocabulary.model.Student;
import com.rafaelli.my_vocabulary.model.Word;
import com.rafaelli.my_vocabulary.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepo;
    private final PasswordEncoder passwordEncoder;

    private String getLoggedInStudentEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if(principal instanceof UserDetails) {
                return ((UserDetails) principal).getUsername();
            }
        }
        return null;
    }

    public Student getLoggedInStudent(){
        Optional<Student> optionalStudent = studentRepo.findByEmail(getLoggedInStudentEmail());
        return optionalStudent.get();
    }

    public Student save(String studentUsername, String studentPassword){
        Student student = new Student();
        student.setEmail(studentUsername);
        student.setPassword(passwordEncoder.encode(studentPassword));
        student.setUserRole(UserRole.USER);

        return studentRepo.save(student);
    }

    public Word getStudentRandomWord() {
        List<Word> words = getStudentWords();
        if(words == null) return null;

        int randomIndex = (int) Math.floor(Math.random() * words.size());

        return words.get(randomIndex);
    }

    public List<Word> getStudentWords() {
        List<Word> words = getLoggedInStudent().getWords();
        return words.isEmpty() ? null : words;
    }
}
